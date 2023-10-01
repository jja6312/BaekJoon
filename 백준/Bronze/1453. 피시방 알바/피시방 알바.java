import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String []args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[100];
        for(int i=0; i<100; i++){
            arr[i]=0;
        }
        
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        
        int cnt=0;
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(arr[a-1]!=0) cnt++;
            else arr[a-1]++;
        }
        
        bw.write(cnt+"");
        
    }
}