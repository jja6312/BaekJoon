import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] isvisited;
    static ArrayList<Integer>[] listArr;


    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isvisited = new boolean[n + 1];
        listArr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            listArr[start].add(end);
            listArr[end].add(start);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(isvisited[i]) continue;
            cnt++;
            dfs(i);
        }

        bw.write(""+cnt);


        bw.flush();
        bw.close();
        br.close();

    }//main

    private static void dfs(int num){
        if(isvisited[num]) return;

        isvisited[num] = true;
        for(int x: listArr[num]){
            dfs(x);
        }
    }//dfs
}