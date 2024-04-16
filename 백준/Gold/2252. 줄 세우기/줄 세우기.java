import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        String A = br.readLine();
        st = new StringTokenizer(A, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] indegree = new int[n+1]; //간선의 개수를 저장하는 배열
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());

            indegree[rt]++;//본인을 가리키고 있는 간선 개수 추가
            list[lt].add(rt);//노드 연결
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0) deque.offer(i); //큐에 시작점을 추가.
        }

        while(!deque.isEmpty()){
            int now = deque.poll();
            bw.write(now+" ");
            for(int next: list[now]){
                indegree[next]--;//그다음 노드를 향하는 간선을 제거
                if(indegree[next]==0) deque.offer(next);
            }
        }//while

        bw.flush();
        bw.close();
        br.close();


    }//main



}//Main