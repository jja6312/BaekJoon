import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt1=1;
    static int cnt2=0;
    static int[] dp;



    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if(n==1 || n==2){
            bw.write("1 1");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        dp = new int[n+1];

        fibo(n);
        fiboDP(n);

        bw.write(cnt1+" "+cnt2);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void fiboDP(int n) {
        if(n==1||n==2){
            return;
        }
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-2] + dp[i-1];
            cnt2++;
        }
    }

    private static void fibo(int n) {
        if(n==1||n==2){
            return;
        }

        cnt1++;
        fibo(n-1);
        fibo(n-2);
    }


}
