import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int x;

    static class Edge implements Comparable<Edge>{
        int next;
        int time;

        public Edge(int next, int time){
            this.next=next;
            this.time=time;
        }

        @Override
        public int compareTo(Edge o) {
            return time-o.time;
        }
    }


    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        List<Edge>[] listEdge = new ArrayList[n+1];
        List<Edge>[] reverseEdge = new ArrayList[n + 1];

        for(int i=1; i<=n; i++){
            listEdge[i] = new ArrayList<>();
            reverseEdge[i] = new ArrayList<>();
        }



        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            listEdge[start].add(new Edge(end,time));
            reverseEdge[end].add(new Edge(start, time));
        }

        int[] distToX = dijkstra(x, listEdge);  // 마을 x로 가는 최단 경로
        int[] distFromX = dijkstra(x, reverseEdge);  // 마을 x에서 돌아오는 최단 경로

        int maxTime = 0;
        for(int i=1; i<=n; i++){
            if(i!=x){
                maxTime = Math.max(maxTime,distToX[i] + distFromX[i]);
            }

        }
        bw.write(maxTime+"\n");





        bw.flush();
        bw.close();
        br.close();


    }//main

    private static int[] dijkstra(int start, List<Edge>[] edges) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] cost = new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[start] = 0;

        pq.offer(new Edge(x,0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int current = edge.next;
            int currentTime = edge.time;

            //현재의 비용이 작으면 업데이트시킨다.
            if(cost[current] > currentTime ){
                cost[current] = currentTime;
            }

            for(Edge nextEdge : edges[current]){//다음엣지로 이동
                int next = nextEdge.next;
                int nextTime = nextEdge.time;

                if(cost[next]>cost[current]+nextTime) pq.offer(new Edge(next, cost[current]+nextTime));

            }

        }

        return cost;
    }


}//Main
