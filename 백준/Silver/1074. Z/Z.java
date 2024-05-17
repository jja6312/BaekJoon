import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int r;
    static int c;
    static int cnt;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);

        find(size, r, c);
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void find(int size, int r, int c) {
        if (size == 1) return;

        int half = size / 2;

        // 1사분면
        if (r < half && c < half) {
            find(half, r, c);
        }
        // 2사분면
        else if (r < half && c >= half) {
            cnt += half * half;
            find(half, r, c - half);
        }
        // 3사분면
        else if (r >= half && c < half) {
            cnt += 2 * half * half;
            find(half, r - half, c);
        }
        // 4사분면
        else {
            cnt += 3 * half * half;
            find(half, r - half, c - half);
        }
    }
}
