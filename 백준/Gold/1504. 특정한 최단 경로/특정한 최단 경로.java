import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int e;
    static List<Edge>[] edgeList;

    static class Edge implements Comparable<Edge>{
        int nextNode;
        int distance;

        public Edge(int nextNode, int distance){
            this.nextNode = nextNode;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o){
            return distance-o.distance;
        }

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edgeList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            edgeList[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            int distance =  Integer.parseInt(st.nextToken());
            //양방향으로 추가
            edgeList[start].add(new Edge(end,distance));
            edgeList[end].add(new Edge(start,distance));

        }

        st = new StringTokenizer(br.readLine());
        int requiredNode1 = Integer.parseInt(st.nextToken());
        int requiredNode2 = Integer.parseInt(st.nextToken());


        // 시작점 ~ requiredNode1 까지의 최단경로
        // +  requiredNode1 ~ requiredNode2 까지의 최단경로
        // + requiredNode2 ~ 끝점 까지의 최단경로

        // 또는

        // 시작점 ~ requiredNode1 까지의 최단경로
        // +  requiredNode1 ~ requiredNode2 까지의 최단경로
        // + requiredNode2 ~ 끝점 까지의 최단경로
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        int distance1_1 = findMinDistance(pq,requiredNode1, 1);

        //새로운 빈 pq를 생성 (기존pq가 전부 안비워져있을경우 상정)
        pq = new PriorityQueue<>();
        pq.offer(new Edge(requiredNode1, 0));
        int distance1_2 = findMinDistance(pq,requiredNode2, requiredNode1);

        pq = new PriorityQueue<>();
        pq.offer(new Edge(requiredNode2, 0));
        int distance1_3 = findMinDistance(pq, n, requiredNode2);

        //------------------------------------------------
        pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        int distance2_1 = findMinDistance(pq,requiredNode2, 1);

        //새로운 빈 pq를 생성 (기존pq가 전부 안비워져있을경우 상정)
        pq = new PriorityQueue<>();
        pq.offer(new Edge(requiredNode2, 0));
        int distance2_2 = findMinDistance(pq,requiredNode1, requiredNode2);

        pq = new PriorityQueue<>();
        pq.offer(new Edge(requiredNode1, 0));
        int distance2_3 = findMinDistance(pq, n, requiredNode1);

        //하나라도 -1이 있는지? ( 즉, 아래 변수 둘 다 -1을포함하고있다면 -1을출력 )
        boolean checkMinus1 = isContainMinusOne(distance1_1,distance1_2,distance1_3);
        boolean checkMinus2 = isContainMinusOne(distance2_1,distance2_2,distance2_3);
        if(checkMinus1 && checkMinus2){
            bw.write("-1");
            bw.flush();
            bw.close();
            br.close();
            return;
        }else if(checkMinus1 && !checkMinus2){//2만 길이 보인다면,
            int sum = distance2_1 + distance2_2 + distance2_3;
            bw.write(sum+"");
        }else if(!checkMinus1 && checkMinus2){//1만 길이 보인다면
            int sum = distance1_1 + distance1_2 + distance1_3;
            bw.write(sum+"");
        }else{
            int sum1 = distance1_1 + distance1_2 + distance1_3;
            int sum2 = distance2_1 + distance2_2 + distance2_3;
            int min = Math.min(sum1,sum2);
            bw.write(min+"");
        }



        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isContainMinusOne(int distance1, int distance2, int distance3) {
        return distance1==-1 || distance2 ==-1 || distance3==-1;
    }

    private static int findMinDistance(PriorityQueue<Edge> pq, int goal, int start) {
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int now = current.nextNode;
            int distance = current.distance;

            if(distance > dist[now]) continue;
            if(now == goal) return distance;


            for(Edge edge : edgeList[now]){//갈수있는 엣지
                int next = edge.nextNode;
                int nextDistance = edge.distance;
                if(dist[now] + nextDistance < dist[next]){
                    dist[next] = dist[now] + nextDistance;
                    pq.offer(new Edge(next, distance + nextDistance));
                }

            }
        }

        return -1;
    }


}
