import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] dist;



    public static void main(String[] args) throws Exception {
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //노드간 최단거리 구하기
        //1~n까지의 노드가 있다.

        dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           dist[start][end] = 1;
           dist[end][start] = 1;
        }

        //최단거리, 플로이드-와셜 알고리즘
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    //경로가 무한대가 아니라면
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        int resultNode = -1;

        for(int i=1; i<=n; i++){
            int sum=0;
            for(int j=1; j<=n; j++){
                sum+= dist[i][j];
            }
            if(minSum>sum){
                minSum = sum;
                resultNode = i;
            }
        }
        bw.write(resultNode+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
