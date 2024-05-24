import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] dp;



    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=10; i++){
            //3을 더하는 경우의 수, 2를 더하는 경우의 수, 1을 더하는 경우의 수
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        for(int i=1; i<=n; i++){
            bw.write(dp[arr[i]]+"\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }




}
