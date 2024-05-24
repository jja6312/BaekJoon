import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[n+1][n+1];

        //길이가 1인 구간은 팰린드롬
        for(int i=1; i<=n; i++){
            dp[i][i] = true;
        }

        //길이가 2인 구간 초기화
        for(int i=1; i<n; i++){
            if(arr[i]==arr[i+1]) dp[i][i+1] = true;
        }

        //길이가 3 이상
        for(int length=3; length<=n; length++){
            for(int i=1; i<=n-length+1; i++){
                int j = i+length -1;
                if(arr[i]==arr[j] && dp[i+1][j-1]) dp[i][j] = true;
            }
        }



        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(dp[start][end] ? "1\n" : "0\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }




}
