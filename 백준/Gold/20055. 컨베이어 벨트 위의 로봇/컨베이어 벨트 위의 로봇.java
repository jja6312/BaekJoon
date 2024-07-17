import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int k;
    static int level;
    static int totalZero;
    static int[] arr;
    static boolean[] robotBoolean;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[2 * n];
        robotBoolean = new boolean[2 * n];
        st = new StringTokenizer(br.readLine());
        // i == 0 => 올리는 위치
        // i == n => 내리는 위치
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            level++;
            rotateArr();
            robotMove();
            if (arr[0] > 0) createRobot();
            countTotalZero();
            if (totalZero >= k) break;
        }
        bw.write(level + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void countTotalZero() {
        int zero = 0;
        for (int x : arr) {
            if (x == 0) zero++;
        }
        totalZero = zero;
    }

    private static void createRobot() {
        robotBoolean[0] = true;
        arr[0]--;
    }

    private static void robotMove() {
        for (int i = n - 1; i >= 0; i--) {
            if (robotBoolean[i]) {
                int nextIdx = (i + 1) % (2 * n);
                if (!robotBoolean[nextIdx] && arr[nextIdx] > 0) {
                    robotBoolean[i] = false;
                    if (nextIdx != n - 1) { // 내리는 위치가 아니면
                        robotBoolean[nextIdx] = true;
                    }
                    arr[nextIdx]--;
                }
            }
        }
    }

    private static void rotateArr() {
        int tmp = arr[2 * n - 1];
        for (int i = 2 * n - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;

        // 로봇 위치도 함께 회전
        for (int i = n - 1; i >= 1; i--) {
            robotBoolean[i] = robotBoolean[i - 1];
        }
        robotBoolean[0] = false;
        robotBoolean[n - 1] = false; // 내리는 위치 초기화
    }
}
