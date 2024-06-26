import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int l;
    static int r;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean isMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) break;
            days++;
        }

        bw.write(days + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.offer(new int[]{y, x});
        union.add(new int[]{y, x});
        visited[y][x] = true;
        int sum = arr[y][x];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentY = current[0];
            int currentX = current[1];

            for (int i = 0; i < 4; i++) {
                int moveY = currentY + dy[i];
                int moveX = currentX + dx[i];

                if (isBoundary(moveY, moveX) && !visited[moveY][moveX]) {
                    int diff = Math.abs(arr[currentY][currentX] - arr[moveY][moveX]);
                    if (diff >= l && diff <= r) {
                        queue.offer(new int[]{moveY, moveX});
                        union.add(new int[]{moveY, moveX});
                        visited[moveY][moveX] = true;
                        sum += arr[moveY][moveX];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int newPopulation = sum / union.size();
            for (int[] pos : union) {
                arr[pos[0]][pos[1]] = newPopulation;
            }
            return true;
        }

        return false;
    }

    private static boolean isBoundary(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
