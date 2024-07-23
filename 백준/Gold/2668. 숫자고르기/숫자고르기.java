import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++){
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }
        Collections.sort(list);
        bw.write(list.size()+"\n");
        for(int x : list){
            bw.write(x+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start, int target) {
        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            dfs(arr[start],target);
            visited[arr[start]] = false;
        }

        if(arr[start] == target){
            list.add(arr[start]);
        }

    }
}
