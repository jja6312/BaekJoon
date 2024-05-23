import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        double weight;

        public Edge(int start, int end, double weight){
            this.start = start;
            this.end = end;
            this.weight =weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight-o.weight>0 ? 1 : -1;
        }
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        int[][] god = new int[n+1][2];//우주신 좌표 저장 배열

        //황선자를 포함한 우주신의 좌표
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            god[i][0] = Integer.parseInt(st.nextToken());
            god[i][1] = Integer.parseInt(st.nextToken());
        }
        //이미 연결된 우주신
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


            union(start,end);//이미 연결된 통로는 union
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //연결할 수 있는 모든 통로를 큐에 추가
        for(int i=1; i<n; i++){
            for(int j=1+i; j<n+1; j++){
                int x1 = god[i][0];
                int y1 = god[i][1];
                int x2 = god[j][0];
                int y2 = god[j][1];

                double weight = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));

                pq.add(new Edge(i,j, weight));
            }
        }

        double result = 0;

        //크루스칼
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int start = edge.start;
            int end = edge.end;
            double weight = edge.weight;
            if(find(start)!=find(end)){
                result+=weight;
                union(start,end);
            }
        }

        String answer = String.format("%.2f", result);
        bw.write(answer);

        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static void union(int start, int end) {
        int root1 = find(start);
        int root2 = find(end);

        if(root1!=root2) parent[root2] = root1;
    }

    private static int find(int x) {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

}//Main Class
