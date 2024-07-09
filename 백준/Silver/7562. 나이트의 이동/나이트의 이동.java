import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int l;


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<t; i++){
            l = Integer.parseInt(br.readLine());
            int[][] map = new int[l][l];

            //현재 있는 칸
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            //이동해야 하는 칸
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int answer = bfs(map,startX,startY,endX,endY);
            bw.write(answer+"\n");

        }



        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int[][] map, int startX, int startY, int endX, int endY) {


        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[l][l];

        queue.offer(new int[]{startX,startY,0});
        visited[startY][startX] = true;

        int[] dx = {-1,-2,-2,-1,1,2,2,1};
        int[] dy = {-2,-1,1,2,2,1,-1,-2};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int cnt = current[2];

            if(currentX==endX && currentY==endY) return cnt;

            for(int i=0; i<8; i++){
                int moveX = dx[i]+currentX;
                int moveY = dy[i]+currentY;

                if(isBoundary(moveX,moveY) && !visited[moveY][moveX]){
                    queue.offer(new int[]{moveX,moveY,cnt+1});
                    visited[moveY][moveX] = true;
                }
            }

        }



        return -1;

    }

    private static boolean isBoundary(int moveX, int moveY) {
        return moveX>=0 && moveX<l && moveY>=0 && moveY<l;
    }


}
