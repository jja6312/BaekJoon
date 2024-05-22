import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] allHouse;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        allHouse = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            allHouse[i][0] = red;
            allHouse[i][1] = green;
            allHouse[i][2] = blue;
        }

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[n + 1][3];

            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[1][i] = allHouse[1][i];
                } else {
                    dp[1][i] = 1001; // 충분히 큰 값으로 설정
                }
            }

            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + allHouse[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + allHouse[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + allHouse[i][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    min = Math.min(min, dp[n][lastColor]);
                }
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
