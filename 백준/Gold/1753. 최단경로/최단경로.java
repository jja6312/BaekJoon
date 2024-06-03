    import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Edge implements Comparable<Edge>{
        int endEdge;
        int weight;

        public Edge( int endEdge, int weight){
            this.endEdge = endEdge;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return weight-o.weight;
        }
    }


    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int initNode = Integer.parseInt(br.readLine());


        int[]dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        List<Edge>[] graph = new ArrayList[v+1];
        for(int i=1; i<=v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[startNode].add(new Edge(endNode,weight));
        }

        dist[initNode] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(initNode, 0));
        while(!pq.isEmpty()){
            Edge currentEdge = pq.poll();
            int currentNode =currentEdge.endEdge;
            int currentWeight = currentEdge.weight;

            if( currentWeight > dist[currentNode]) continue;

            for(Edge edge: graph[currentNode]){
                int nextNode = edge.endEdge;
                int weight = edge.weight;

                if(dist[nextNode] > dist[currentNode] + weight){
                    dist[nextNode] = dist[currentNode] + weight;
                    pq.offer(new Edge(nextNode, dist[nextNode]));
                }
            }



        }
        for(int i=1; i<=v; i++){
            int x = dist[i];
            if(x==Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(x+"\n");
        }

        bw.flush();
        bw.close();
        br.close();


    }//main

}//Main
