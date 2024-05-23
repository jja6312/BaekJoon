import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int NOT_CARD = 777777777;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int[] point = new int[max + 1];
        Arrays.fill(point, NOT_CARD);

        for (int i = 0; i < n; i++) {
            int card = arr[i];
            point[card] = 0;
        }

        for (int i = 1; i <= max; i++) {
            if (point[i] == NOT_CARD) continue;

            int cnt = 0;
            for (int cardMul = 2 * i; cardMul <= max; cardMul += i) {
                if (point[cardMul] == NOT_CARD) continue;
                point[cardMul]--;
                cnt++;
            }
            point[i] += cnt;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = point[arr[i]];
        }

        for (int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
