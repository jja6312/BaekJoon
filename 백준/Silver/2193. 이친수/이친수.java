import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];

        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        bw.write(dp[n]+"");



        bw.flush();
        bw.close();
        br.close();


    }//main


}//Main
