import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer>[] listEdge;
    static boolean[] visited;
    static int[] subtreeSize;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        listEdge = new ArrayList[n+1];
        visited = new boolean[n+1];
        subtreeSize = new int[n+1];

        for(int i=1; i<=n; i++){
            listEdge[i] = new ArrayList();
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            listEdge[u].add(v);
            listEdge[v].add(u);
        }

        dfs(r);


        for(int i=0; i<q; i++){
            int u = Integer.parseInt(br.readLine());
            bw.write(subtreeSize[u]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();


    }//main

    private static int dfs(int node) {
        visited[node] = true;
        subtreeSize[node] = 1;//자기 자신 포함

        for(int next: listEdge[node]){
            if(!visited[next]){
                subtreeSize[node] += dfs(next);
            }

        }
        return subtreeSize[node];
    }

}//Main
