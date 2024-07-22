import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;
    static int cnt;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][21];

        dp[0][arr[0]] = 1;
        for(int i=1; i<n-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    if(j+arr[i] <=20){
                        dp[i][j+arr[i]] += dp[i-1][j];
                    }
                    if(j-arr[i]>=0){
                        dp[i][j-arr[i]] += dp[i-1][j];
                    }
                }
            }
        }


        bw.write(dp[n-2][arr[n-1]]+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
