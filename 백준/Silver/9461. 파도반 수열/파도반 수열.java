import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n =  Integer.parseInt(br.readLine());
            long[] dp = new long[n];
            if(n==1 || n==2 || n==3){
                bw.write("1\n");
                continue;
            }
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for(int j=3; j<n; j++){
                dp[j] = dp[j-3]+dp[j-2];
            }
            bw.write(dp[n-1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }




}
