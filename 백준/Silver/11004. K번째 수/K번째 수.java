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
        StringTokenizer st = new StringTokenizer(A, " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String B = br.readLine();
        int[]arr = new int[N];
        st = new StringTokenizer(B, " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            
        }
        
        Arrays.sort(arr);
        
        bw.write(arr[K-1]+"");
    }//read()
}//Main