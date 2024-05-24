import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long [][]dp = new long[n+1][10];
        long mod = 1000000000;

        //초기값 설정
        for(int i=1; i<=9; i++){
            dp[1][i]= 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                if(j>0) dp[i][j] += dp[i-1][j-1];
                if(j<9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= mod;
            }
        }
        long sum=0;
        for(long x: dp[n]){
            sum+=x;
        }
        sum%=mod;
        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();
    }




}
