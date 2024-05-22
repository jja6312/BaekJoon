import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    static int zeroTomato;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    zeroTomato++;
                } else if (arr[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0}); // 익은 토마토 저장
                    visited[i][j] = true; // 이미 익은 토마토 방문 처리
                } else if (arr[i][j] == -1) {
                    visited[i][j] = true; // 장애물 방문 처리
                }
            }
        }

        int minTime = bfs(queue);
        bw.write(minTime + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(Queue<int[]> queue) {
        int day = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int time = current[2];
            day = time;

            for (int i = 0; i < 4; i++) {
                int moveY = dy[i] + y;
                int moveX = dx[i] + x;
                if (isValid(moveX, moveY) && !visited[moveY][moveX] && arr[moveY][moveX] == 0) {
                    visited[moveY][moveX] = true; // 방문 처리
                    arr[moveY][moveX] = 1; // 토마토 익히기
                    queue.offer(new int[]{moveY, moveX, time + 1});
                    zeroTomato--; // 익지 않은 토마토 개수 감소
                }
            }
        }

        return zeroTomato == 0 ? day : -1; // 모든 토마토가 익었는지 확인
    }

    private static boolean isValid(int moveX, int moveY) {
        return moveX >= 0 && moveX < m && moveY >= 0 && moveY < n && arr[moveY][moveX] != -1;
    }
}
