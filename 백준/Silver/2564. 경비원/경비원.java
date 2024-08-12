

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, y, x;
    static int[][] arr;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        // arr의 가장자리 변(갈 수 있는 위치)을 '1'로 표시
        arr = new int[n+1][m+1];
        for (int i = 0; i <= m; i++) {
            arr[0][i] = 1;
            arr[n][i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            arr[i][0] = 1;
            arr[i][m] = 1;
        }

        // 가게 위치 입력받기
        int storeEA = Integer.parseInt(br.readLine());
        List<int[]> storeList = new ArrayList<>();
        for (int i = 0; i < storeEA; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            // 1: 북쪽
            // 2: 서쪽
            // 3: 남쪽
            // 4: 동쪽
            int distance = Integer.parseInt(st.nextToken());
            storeList.add(new int[]{direction, distance});
        }

        st = new StringTokenizer(br.readLine());
        int direction = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        if (direction == 1) arr[0][distance] = 3;// 3은 현재 내위치
        else if (direction == 3) arr[distance][0] = 3;
        else if (direction == 2) arr[n][distance] = 3;
        else if (direction == 4) arr[distance][m] = 3;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (arr[i][j] == 3) {
                    y = i;
                    x = j;
                    arr[i][j] = 1;//다시 1로바꿔놓자.
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < storeList.size(); i++) {
            int min = bfs(storeList.get(i));
            sum += min;
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
        br.close();

    }//main()

    private static int bfs(int[] storeInfo) {
        // storeInfo에 따라 목적지 초기화
        int goalY = 0;
        int goalX = 0;
        int direction = storeInfo[0];
        int distance = storeInfo[1];
        if (direction == 1) {
            goalY = 0;
            goalX = distance;
        } else if (direction == 3) {
            goalY = distance;
            goalX = 0;
        } else if (direction == 2) {
            goalY = n;
            goalX = distance;
        } else if (direction == 4) {
            goalY = distance;
            goalX = m;
        }


        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n+1][m+1];

        queue.offer(new int[]{y,x,0}); // y,x 에서 출발
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentY = current[0];
            int currentX = current[1];
            int cnt = current[2];

            if(currentY == goalY && currentX == goalX){
                return cnt;
            }
            //상하좌우 중 범위 이내이며, 방문하지않고, 요소가 1인것들을 탐색
            for(int i=0; i<4; i++){
                int moveY = dy[i] + currentY;
                int moveX = dx[i] + currentX;
                if(isBoundary(moveY,moveX)
                        && !visited[moveY][moveX]
                        && arr[moveY][moveX] == 1){
                    visited[moveY][moveX] = true;
                    queue.offer(new int[]{moveY,moveX, cnt+1});
                }
            }
        }//while
        return -1;
    }

    public static boolean isBoundary(int moveY, int moveX){
        return moveY>=0 && moveY<=n && moveX>=0 && moveX<=m;
    }

}//Main Class
