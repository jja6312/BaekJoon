import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        // dp 배열 초기화
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악의 경우는 1^2을 i번 사용하는 것
        }

        // DP 배열 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
