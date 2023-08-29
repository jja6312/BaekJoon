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
        
    }
    public static void read() throws IOException{
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap <String,String>map = new HashMap<String,String>();
        
        for(int i=0; i<N; i++){
            String B = br.readLine();
            st = new StringTokenizer(B, " ");
            map.put(st.nextToken(),st.nextToken());
        }
        for(int i=0; i<M; i++){
            bw.write(map.get(br.readLine())+"\n");
        }
    }
}