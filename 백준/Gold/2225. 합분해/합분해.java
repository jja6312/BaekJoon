import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        //0~n까지의 정수 k개를 더해서 그 합이 n이되는 경우의 수
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[k+1][n+1];
        for(int i=0; i<=k; i++){
            dp[i][0] = 1;
        }


        //n=1 k=1 (1) => 1
        //n=1 k=2 (0+1),(1+0) => 2
        //n=1 k=3 (0+0+1),(0+1+0),(1+0+0) => 3

        //n=2 k=1 (2) => 1
        //n=2 k=2 (2+0,0+2,1+1) =>3
        //n=2 k=3 (1+1+0, 1+0+1, 0+1+1, 2+0+0, 0+2+0, 0+0+2) =>6

        //n=3 k=1 (3) => 1
        //n=3 k=2 (1+2, 2+1, 3+0, 0+3) => 4
        //n=3 k=3 (1+1+1, 2+1+0, 2+0+1, 0+2+1, 1+2+0, 0+1+2, 1+0+2, 3+0+0,0+3+0,0+0+3) => 10

        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000;
            }
        }
        bw.write(dp[k][n]+"");


        bw.flush();
        bw.close();
        br.close();

    }


}
