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
        int N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();
        int[] arrA = new int[N];
        int[] arrB = new int[N];
        
        StringTokenizer st = new StringTokenizer(A, " ");
        
        for(int i=0; i<N; i++){
          arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(B, " ");
        for(int i=0; i<N; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        
        int sum1=0;
        int sum2=0;
        
        for(int i=0; i<N; i++){
            sum1 += arrA[i]*arrB[N-1-i];
        }
        for(int i=0; i<N; i++){
            sum2 += arrA[N-1-i]*arrB[i];
        }
        if(sum1<=sum2) bw.write(sum1+"");
        else bw.write(sum2+"");
        
    }//read()
}//Main