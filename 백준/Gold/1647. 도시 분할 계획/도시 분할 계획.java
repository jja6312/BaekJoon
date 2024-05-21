import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;
    static ArrayList<Edge> edgeList;

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }


    public static void main(String[] args) throws IOException {
        // 최소비용 :  크루스칼 알고리즘
        // => N개의 집은 N-1개의 길만으로 연결된 상태가 된다.

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(start, end, weight));

        }

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        Collections.sort(edgeList);

        //모든 집이 n-1개의 길로 연결되도록 만듦
        int ans = 0;
        int bigCost = 0;
        for(int i=0; i< edgeList.size(); i++){
            Edge edge = edgeList.get(i);

            //사이클이 발생하는 간선은 제외
            if(find(edge.start)!=find(edge.end)){
                ans+= edge.weight;
                union(edge.start, edge.end);

                bigCost = edge.weight;
            }
        }
        bw.write(ans-bigCost+"\n");

        bw.flush();
        bw.close();
        br.close();
    }


    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[y] = x;
        }
    }

}
