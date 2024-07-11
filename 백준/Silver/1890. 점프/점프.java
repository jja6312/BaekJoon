import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] arr;
    static long[][] memo;

    public static void main(String[] args) throws IOException {
        n =  Integer.parseInt(br.readLine());
        arr = new int[n][n]; // 배열 크기 초기화
        memo = new long[n][n]; // 메모이제이션 배열 초기화
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1; // 초기값 -1로 설정 (방문하지 않은 상태)
            }
        }

        long count = dfs(0, 0);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static long dfs(int y, int x) {
        if (y == n - 1 && x == n - 1) {
            return 1; // 마지막 칸에 도달했을 때 경로의 수 1을 반환
        }

        if (memo[y][x] != -1) {
            return memo[y][x]; // 이미 계산된 경로의 수 반환
        }

        long count = 0;
        int move = arr[y][x];

        if (move == 0) {
            memo[y][x] = 0; // 이동할 수 없는 칸은 경로의 수 0으로 설정
            return 0;
        }

        if (isBoundary(y + move)) {
            count += dfs(y + move, x);
        }
        if (isBoundary(x + move)) {
            count += dfs(y, x + move);
        }

        memo[y][x] = count; // 계산된 경로의 수를 메모이제이션 배열에 저장
        return count; // 모든 가능한 경로의 수를 반환
    }

    private static boolean isBoundary(int xy) {
        return xy >= 0 && xy < n;
    }
}
