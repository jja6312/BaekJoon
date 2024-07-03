import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(0,0,0,1);
        
        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start, int current, int cost, int cnt) {
        if(cnt == n && arr[current][start]!=0){
            min = Math.min(min, cost + arr[current][start]);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i] && arr[current][i]!=0){
                visited[i] = true;
                dfs(start, i, cost+arr[current][i], cnt+1);
                visited[i] = false;
            }
        }

    }


}
