import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;
    

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        arrive = false;
        
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            String readLines = br.readLine();
            st = new StringTokenizer(readLines, " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }
        for(int i=0; i<N; i++){
            DFS(i,1); //Depth 1부터 시작
            if(arrive) break;
            
        }
        if(arrive) bw.write("1");
        else bw.write("0");
        
    }//read()
    
    public static void DFS(int now,int depth){
        if(depth ==5 || arrive){
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i:A[now]){
            if(!visited[i]){
                DFS(i,depth +1);
            }
        }
        visited[now] = false;
    }
}//Main