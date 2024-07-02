import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;

    static int max;
    static int n;
    static int m;
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n  =Integer.parseInt(st.nextToken());
        m  =Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = arr[0][0];

        for(int i=1; i<m; i++){
            dp[0][i] = arr[0][i] + dp[0][i-1];
        }

        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + arr[i][j];
            }
        }

        bw.write(dp[n-1][m-1]+"");


        bw.flush();
        bw.close();
        br.close();
    }




}
