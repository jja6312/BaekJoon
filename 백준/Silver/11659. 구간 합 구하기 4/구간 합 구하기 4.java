import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String B = br.readLine();
        st = new StringTokenizer(B, " ");
        
        int[] sumArr = new int[N+1];
        sumArr[0]=0;
        for(int i=1; i<=N; i++){
            sumArr[i] = sumArr[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++){
        	String C = br.readLine();
        	st = new StringTokenizer(C, " ");        	
            bw.write(-(sumArr[Integer.parseInt(st.nextToken())-1])+(sumArr[Integer.parseInt(st.nextToken())])+"\n");
        }
    }//read()
}//Main