import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return weight-o.weight;
        }

    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        parent = new int[v+1];
        //그래프 순환을 검사하기 위해 루트노드 저장
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Node(start,end,weight));

        }




        int sum = 0;
        while(!pq.isEmpty()){
            // 저장된 노드를 꺼내서
            Node node = pq.poll();
            int start = node.start;
            int end = node.end;
            int weight = node.weight;

            // 그래프가 순환되지 않는다면(== 출발과 끝 노드의 루트가 같지 않다) sum 에 값을 추가한다.
            if(find(start)!=find(end)){
                sum+=weight;
                union(start,end);
            }
        }
        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int start, int end) {
        int rootS = find(start);
        int rootE = find(end);
        if(rootS!=rootE){
            parent[rootE] = rootS;
        }
    }

    public static int find(int edge){
        if(edge==parent[edge]) return edge;

        return parent[edge] = find(parent[edge]);
    }



}