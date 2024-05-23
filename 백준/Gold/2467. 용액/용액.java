import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[] fluid;
    static long INF = 2000000000;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        fluid = new long[n];
        for (int i = 0; i < n; i++) {
            fluid[i] = Long.parseLong(st.nextToken());
        }
        int lt = 0;
        int rt = n - 1;
        int ansLt = 0;
        int ansRt = n - 1;
        long min = INF;

        while (lt < rt) {
            long sum = fluid[lt] + fluid[rt];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ansLt = lt;
                ansRt = rt;
            }

            if (sum < 0) {
                lt++;
            } else if (sum > 0) {
                rt--;
            } else {
                break; // 합이 0인 경우 더 이상 탐색할 필요가 없음
            }
        }

        bw.write(fluid[ansLt] + " " + fluid[ansRt]);
        bw.flush();
        bw.close();
        br.close();
    }
}
