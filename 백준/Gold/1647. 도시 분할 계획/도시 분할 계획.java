import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            return weight-edge.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        // 최소비용 :  크루스칼 알고리즘
        // => N개의 집은 N-1개의 길만으로 연결된 상태가 된다.

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        //parent 초기화
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //가중치가 낮은 순서대로 큐에 삽입
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(start,end,weight);
            pq.offer(edge);
        }

        int ans = 0;
        int bigCost = 0;
        //최소 신장 트리로 연결한다.
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.start)!=find(edge.end)){//순환하는 구조가 아닐때
                ans+= edge.weight;// 연결
                bigCost = edge.weight;

                union(edge.start,edge.end);
            }
        }
        bw.write(ans-bigCost+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int node){
        //노드가 최상위 노드일때 반환
        if(node == parent[node]) return node;

        //아니라면, 크루스칼 알고리즘을 통해 경로를 압축한다.
        return parent[node] = find(parent[node]);
    }

    public static void union(int start, int end){

        int root1 = find(start);
        int root2 = find(end);
        parent[root1] = root2;//한쪽을 다른쪽루트로 결합
    }

}
