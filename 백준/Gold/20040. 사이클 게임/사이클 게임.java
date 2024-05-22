import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static Queue<Line> queue = new LinkedList<>();
    static int[] parent;



    static class Line {
        int start;
        int end;
        boolean visited = false;

        public Line(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent =new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(find(start)==find(end)){
                System.out.println(i+1);
                return;
            }else{
                union(start,end);
            }
        }

        System.out.println("0");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int start) {
        if(parent[start]==start) return start;

        return parent[start] = find(parent[start]);
    }

    private static void union(int start, int end){
        int root1 = find(start);
        int root2 = find(end);

        if(root1!=root2) parent[root2] = root1;
    }


}
