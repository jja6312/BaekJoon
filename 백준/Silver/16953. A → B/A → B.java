import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int b;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        Queue<Long> queue = new LinkedList<>();
        queue.offer((long)a);
        int minCnt = bfs(0, queue);

        if (minCnt == -1) {
            bw.write("-1");
        } else {
            bw.write(minCnt + 1 + "");
        }


        bw.flush();
        bw.close();
        br.close();

    }

    public static int bfs(int cnt, Queue<Long> queue) {
        Queue<Long> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {//현재 큐가 빌때까지,
            long num = queue.poll();
            if (num == b) return cnt; //값을 찾은 경우 cnt를 반환
            else if(num<b) {
                //다음큐에 연산을 저장
                nextQueue.offer(num*10+1);
                nextQueue.offer(num*2);
            }
        }
        //다음 큐에 넣은게 있으면 재귀호출
        if(!nextQueue.isEmpty()) {
            return bfs(cnt+1, nextQueue);
        }else{
            return -1;
        }
    }


}//Main Class
