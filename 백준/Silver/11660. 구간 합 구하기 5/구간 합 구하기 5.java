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
        int M = Integer.parseInt(st.nextToken());
        int[][] arrSum = new int[N+1][N+1];
        for(int i=0; i<N+1; i++){
            arrSum[0][i] = 0;
            arrSum[i][0] = 0;
        }
        
        /*
         0 0 0 0 0 0
         0 1 2 3 8 8
         0 4 5 6 8 8
         0 7 8 9 8 8
         0 9 9 9 9 8
         
         x1,y1
         x2,y2
         s[x2,y2]-s[x1-1,y1]
         
         (s[x2,y1-1]-s[x2,1]) - (s[x1,N]-s[x1,y2])
         
         */
        for(int i=1; i<=N; i++){
            String B = br.readLine();
            st = new StringTokenizer(B, " ");
            for(int j=1; j<=N; j++){
            	arrSum[i][j] = arrSum[i-1][j]+arrSum[i][j-1]-arrSum[i-1][j-1]+Integer.parseInt(st.nextToken());
            }//for2
        }//for1
        
        for(int i=0; i<M; i++){
            String C = br.readLine();
            st = new StringTokenizer(C, " ");
            int point11 = Integer.parseInt(st.nextToken());
            int point12 = Integer.parseInt(st.nextToken());
            int point21 = Integer.parseInt(st.nextToken());
            int point22 = Integer.parseInt(st.nextToken());
            bw.write(arrSum[point21][point22]-(arrSum[point21][point12-1])-arrSum[point11-1][point22]+arrSum[point11-1][point12-1]+"\n");
        }
    }//read()
}//Main