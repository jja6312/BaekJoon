import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[][] arr;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initDp();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[n - 1][i], max);
        }


        bw.write(max + "");

        bw.flush();
        bw.close();
        br.close();

    }

    private static void initDp() {
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int lt = Integer.MIN_VALUE;

                if (j - 1 >= 0) {
                    lt = dp[i - 1][j - 1] + arr[i][j];
                }

                int rt = dp[i - 1][j] + arr[i][j];

                dp[i][j] = Math.max(lt, rt);
            }
        }
    }


}//Main Class
