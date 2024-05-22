import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] parent;

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;
        public Node(int start,int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o){
            return weight - o.weight;
        }

    }


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i]=i;
        }

        for(int i=0; i<m; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start,end,weight));
        }

        int sum=0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int start = node.start;
            int end = node.end;
            int weight = node.weight;

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

    private static int find(int end) {
        if(end==parent[end])return end;

        return parent[end] = find(parent[end]);
    }

    private static void union(int start, int end){
        int root1 = find(start);
        int root2 = find(end);

        if(root1!=root2){
            parent[root2] = root1;
        }

    }


}
