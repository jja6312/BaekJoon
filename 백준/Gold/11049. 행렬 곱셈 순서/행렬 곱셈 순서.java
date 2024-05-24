import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        // n<=500
        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];

        for(int len=1; len<n; len++){
            for(int i=0; i<n-len; i++){
                int j=i+len;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost = dp[i][k] + dp[k+1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
                    dp[i][j] = Math.min(dp[i][j],cost);
                }
            }
        }
        bw.write(dp[0][n-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }




}
