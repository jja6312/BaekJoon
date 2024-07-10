import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] path = new int[n + 1];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }

        bw.write(dp[n] + "\n");

        StringBuilder sb = new StringBuilder();
        for (int i = n; i != 0; i = path[i]) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString().trim() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
