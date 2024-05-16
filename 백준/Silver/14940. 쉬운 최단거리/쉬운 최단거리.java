import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int startX;
    static int startY;
    static int[][] arr;
    static int[][] distance;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }

        // 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    startX = j;
                    startY = i;
                } else if (arr[i][j] == 0) {
                    distance[i][j] = 0;  // 갈 수 없는 땅은 0으로 설정
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(distance[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        distance[startY][startX] = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentY = current[0];
            int currentX = current[1];

            for (int i = 0; i < 4; i++) {
                int moveY = dy[i] + currentY;
                int moveX = dx[i] + currentX;

                if (isBoundary(moveY, moveX) && distance[moveY][moveX] == -1 && arr[moveY][moveX] != 0) {
                    queue.offer(new int[]{moveY, moveX});
                    distance[moveY][moveX] = distance[currentY][currentX] + 1;
                }
            }
        }
    }

    private static boolean isBoundary(int moveY, int moveX) {
        return moveX >= 0 && moveX < m && moveY >= 0 && moveY < n;
    }
}
