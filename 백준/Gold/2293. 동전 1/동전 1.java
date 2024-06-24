import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n ;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        int[] dp = new int[k+1];

        dp[0] = 1;


        //1 을 만드는 경우의수 = 1 => 1개
        //2를 만드는 경우의 수 = 1+1, 2 => 2개
        //3을 만드는 경우의 수 = 1+1+1, 1+2 =>2개
        //4를 만드는 경우의 수 = 1+1+1+1, 2+1+1, 2+2 => 3개
        //참고한 블로그 https://velog.io/@jxlhe46/%EB%B0%B1%EC%A4%80-2293%EB%B2%88.-%EB%8F%99%EC%A0%84-1-bfi120m5
        for(int i=0; i<n; i++){
            for(int j=arr[i]; j<=k; j++){
                dp[j] += dp[j-arr[i]];
            }
        }

        bw.write(dp[k]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
