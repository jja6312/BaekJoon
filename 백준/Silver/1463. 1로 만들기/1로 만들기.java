import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int cnt = bfs(n);
        bw.write(cnt+"");

        bw.flush();
        bw.close();
        br.close();

    }

    public static int bfs(int n){
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];

        queue.offer(new int[]{n,0});
        visited[n] = true;

        while(!queue.isEmpty()){

            int[] current = queue.poll();
            int currentNum = current[0];
            int level =  current[1];

            if(currentNum==1) return level;

            if(currentNum%3==0 && !visited[currentNum/3]){
                visited[currentNum/3] = true;
                queue.offer(new int[]{currentNum/3, level+1});
            }

            if(currentNum%2 == 0 && !visited[currentNum/2]){
                visited[currentNum/2] = true;
                queue.offer(new int[]{currentNum/2, level+1});
            }

            if(currentNum>1 && !visited[currentNum-1]){
                visited[currentNum-1] = true;
                queue.offer(new int[]{currentNum-1,level+1});
            }

        }


        return -1;
    }

}//Main Class
