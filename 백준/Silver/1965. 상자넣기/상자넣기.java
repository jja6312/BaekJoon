import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[]arr;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int [] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int maxLen = 0;
        for(int x:dp){
            maxLen = Math.max(x,maxLen);
        }

        bw.write(maxLen+"\n");



        bw.flush();
        bw.close();
        br.close();
    }
}