import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer>[] arr;
    static boolean [] visited;




    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            arr[startNode].add(endNode);
            arr[endNode].add(startNode);
        }

        for(int i=0; i<arr.length; i++){
            Collections.sort(arr[i]);
        }

        dfs(v);

        //방문배열 초기화
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }
        bw.write("\n");

        bfs(v);


        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int v) throws IOException{
        if(visited[v]) return;
        visited[v] = true;

        bw.write(v+" ");
        for(int x:arr[v]){
            dfs(x);
        }
    }

    public static void bfs(int v) throws IOException{


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()){
            int currentNum = queue.poll();

            if(visited[currentNum]) continue;
            bw.write(currentNum+" ");
            visited[currentNum] = true;

            for(int x:arr[currentNum]){
                queue.offer(x);
            }
        }//while
    }

}//Main Class
