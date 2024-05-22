import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[]parent;
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
        public int compareTo(Edge o) {
            return weight-o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }
        for(int i=1; i<=n; i++){
            int createCost = Integer.parseInt(br.readLine());
            pq.offer(new Edge(0, i, createCost));
        }

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int weight = Integer.parseInt(st.nextToken());
                pq.offer(new Edge(i,j,weight));
            }
        }
        int sum=0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;

            if(find(start)!=find(end)){
                sum+=weight;
                union(start,end);
            }
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static void union(int start, int end) {
        int root1 = find(start);
        int root2 = find(end);

        if(root1!=root2) parent[root2] = root1;
    }

    private static int find(int start) {
        if(start== parent[start]) return start;

        return parent[start] = find(parent[start]);
    }
}//Main Class
