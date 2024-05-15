import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] map;
    static Shark shark = null;

    static class Shark {
        int y;
        int x;
        int level = 2;
        int experience = 0;

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void eatFish() {
            experience++;
            if (experience == level) {
                level++;
                experience = 0;
            }
        }
    }

    static class Fish implements Comparable<Fish> {
        int y;
        int x;
        int distance;

        public Fish(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish other) {
            if (this.distance == other.distance) {
                if (this.y == other.y) {
                    return this.x - other.x;
                }
                return this.y - other.y;
            }
            return this.distance - other.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j); // 상어의 위치 초기화
                    map[i][j] = 0; // 상어 위치를 0으로 초기화
                }
            }
        }

        int totalTime = 0;

        while (true) {
            Fish nearestFish = findNearestFish();
            if (nearestFish == null) break;

            shark.eatFish();
            map[nearestFish.y][nearestFish.x] = 0;
            shark.y = nearestFish.y;
            shark.x = nearestFish.x;
            totalTime += nearestFish.distance;
        }

        bw.write(totalTime + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static Fish findNearestFish() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        List<Fish> fishList = new ArrayList<>();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        queue.offer(new int[]{shark.y, shark.x, 0});
        visited[shark.y][shark.x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentY = current[0];
            int currentX = current[1];
            int currentDistance = current[2];

            for (int i = 0; i < 4; i++) {
                int moveX = dx[i] + currentX;
                int moveY = dy[i] + currentY;

                if (isInBoundary(moveY, moveX) && !visited[moveY][moveX]) {
                    visited[moveY][moveX] = true;
                    queue.offer(new int[]{moveY, moveX, currentDistance + 1});
                    if (map[moveY][moveX] > 0 && map[moveY][moveX] < shark.level) {
                        fishList.add(new Fish(moveY, moveX, currentDistance + 1));
                    }
                }
            }
        }

        if (fishList.isEmpty()) return null;

        Collections.sort(fishList);
        return fishList.get(0);
    }

    private static boolean isInBoundary(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n && map[y][x] <= shark.level;
    }
}
