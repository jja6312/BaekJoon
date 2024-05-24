import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;




    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n==1){
            System.out.println(arr[0]);
            return;
        }

        int [] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0]+arr[1]);

        int max = Math.max(dp[0],dp[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }




}
