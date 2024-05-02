import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Integer [][] dp = new Integer[41][2];;


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){

            int n = Integer.parseInt(br.readLine());
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            fibonacci(n);
            bw.write(dp[n][0]+" "+dp[n][1]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

    public static Integer[] fibonacci(int n) {
        if(dp[n][0] == null || dp[n][1] == null){ //null일때만 초기화
            dp[n][0] = fibonacci(n-2)[0] + fibonacci(n-1)[0];
            dp[n][1] = fibonacci(n-2)[1] + fibonacci(n-1)[1];
        }
        return dp[n]; //초기화된 dp를 반환
    }
}//Main
