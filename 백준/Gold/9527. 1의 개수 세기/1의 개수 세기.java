import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] dp = new long[55];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        setDp();//누적합 계산
        long result = calOne(end) - calOne(start-1);
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    //1~n 정수에 대해 1의 개수를 구한다.
    private static long calOne(long n) {
        long cnt = n%2;
        //N보다 작은 2ⁿ의 n의 최대값
        int size = (int) (Math.log(n)/Math.log(2));
        for(int i=size;i>0;i--) {
            if((n & (1L<<i)) != 0L) {
                cnt += dp[i-1] +(n - (1L<<i) + 1);
                n -= (1L << i);	//비트 이동시키기
            }
        }
        return cnt;
    }

    private static void setDp() {
        dp[0] = 1;
        for(int i=1; i<55; i++){
            //DP[n] = DP[n-1] × 2 + 2ⁿ
            dp[i] = (dp[i-1]<<1) + (1L << i);
        }
    }


}
