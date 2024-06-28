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

        //0~20까지의 정수 2개를 더해서 그 합이 20이되려면?
        //0+20, 1+19, ... ,19+1, 20+0

        int[][] dp = new int[k+1][n+1];

        for(int i=0; i<=k; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = (dp[i-1][j]+ dp[i][j-1])%1000000000;
            }
        }
        bw.write(dp[k][n]+"");
        bw.flush();
        bw.close();
        br.close();

    }


}
