

import java.io.*;
import java.util.*;

// =============== 문제 접근 ===============
// 1. edgeList에 갈 수 있는 방향의 노드를 담는다.
// 2. bfs
public class Solution {
    static int e, start;
    static int[] cntArr;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");
            StringTokenizer st= new StringTokenizer(br.readLine());
            e = Integer.parseInt(st.nextToken());// 간선의 개수
            start = Integer.parseInt(st.nextToken());
            cntArr = new int[101];

            list = new ArrayList[101];

            for(int i=1; i<=100; i++){
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<e/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
            }

            bfs();//bfs로 cntArr를 초기화

            int max = Arrays.stream(cntArr).max().getAsInt();
            int ans = 0;
            for(int i=1; i<=100; i++){
                if(max==cntArr[i]) ans = i;
            }
            sb.append(ans).append("\n");

        }//for-test
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); //첫 시작을 offer
        cntArr[start] = 1; // 방문처리

        while(!queue.isEmpty()){//큐가 비지않을때까지 반복
            int current = queue.poll() ; //큐에서 현재 값을 꺼내서

            for(int next : list[current]){
                // 만약 next 노드를 방문하지않았다면
                if(cntArr[next]==0){
                    cntArr[next] = cntArr[current]+1; //지금노드 +1
                    queue.offer(next);
                }
            }

        }
    }
}
