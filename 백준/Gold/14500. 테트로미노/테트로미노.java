import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
                checkOtherShapes(i, j); // 보라색(ㅗ) 모양 체크
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isValidBoundary(moveY, moveX) && !visited[moveY][moveX]) {
                visited[moveY][moveX] = true;
                dfs(moveY, moveX, sum + arr[moveY][moveX], cnt + 1);
                visited[moveY][moveX] = false;
            }
        }
    }

    private static void checkOtherShapes(int y, int x) {
        // ㅗ 모양의 네 가지 회전 형태를 체크
        if (isValidBoundary(y, x + 1) && isValidBoundary(y, x - 1) && isValidBoundary(y + 1, x))
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y][x - 1] + arr[y + 1][x]);
        if (isValidBoundary(y, x + 1) && isValidBoundary(y, x - 1) && isValidBoundary(y - 1, x))
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y][x - 1] + arr[y - 1][x]);
        if (isValidBoundary(y + 1, x) && isValidBoundary(y - 1, x) && isValidBoundary(y, x + 1))
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y - 1][x] + arr[y][x + 1]);
        if (isValidBoundary(y + 1, x) && isValidBoundary(y - 1, x) && isValidBoundary(y, x - 1))
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y - 1][x] + arr[y][x - 1]);
    }

    private static boolean isValidBoundary(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
