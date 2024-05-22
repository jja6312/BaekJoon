import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int time = bfs(n,k);
        bw.write(time+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int n, int k) {
        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{n,0});
        while(!queue.isEmpty()){

            //현위치
            int[] currentQueue = queue.poll();
            int currentPosition = currentQueue[0];
            int currentTime = currentQueue[1];

            if(currentPosition>100000 || currentPosition<0) continue;
            if(visited[currentPosition]) continue;
            visited[currentPosition] = true;

            if(currentPosition==k) return currentTime;

            queue.offer(new int[]{currentPosition+1,currentTime+1});
            queue.offer(new int[]{currentPosition-1,currentTime+1});
            queue.offer(new int[]{currentPosition*2,currentTime+1});
        }

        return -1;
    }
}
