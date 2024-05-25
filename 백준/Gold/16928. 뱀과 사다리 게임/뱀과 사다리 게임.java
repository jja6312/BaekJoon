import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] map;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int 사다리수 = Integer.parseInt(st.nextToken());
        int 뱀수 = Integer.parseInt(st.nextToken());
        map = new int[101];
        for(int i = 0; i < 사다리수; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());
            map[idx] = move;
        }
        for(int i = 0; i < 뱀수; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());
            map[idx] = move; // 뱀수와 사다리수를 신경쓰지 말자.
        }

        int cnt = bfs();

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        queue.offer(new int[]{1, 0}); // 1번 인덱스, 주사위 0번.
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int idx = current[0];
            int cnt = current[1];

            // 100번에 가장 빨리 도달한 cnt를 반환
            if(idx == 100) return cnt;

            // 주사위를 굴려서 이동
            for(int i = 1; i <= 6; i++){
                int nextIdx = idx + i;
                if(nextIdx <= 100 && !visited[nextIdx]) {
                    if(map[nextIdx] != 0) {
                        nextIdx = map[nextIdx]; // 뱀이나 사다리의 목적지로 이동
                    }
                    if(!visited[nextIdx]) {
                        queue.offer(new int[]{nextIdx, cnt + 1});
                        visited[nextIdx] = true; // 큐에 추가할 때 방문으로 표시
                    }
                }
            }
        }

        return -1;
    }
}
