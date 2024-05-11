import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0, new boolean[n]);



        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int startIdx, int depth, boolean[] visited) throws IOException{
        if(depth == m){
            for(int i=0; i<m; i++){
                bw.write(answer[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue; //이미방문한곳이라면 넘어간다.

            boolean[] visited2 = new boolean[n];//새로운주소 생성(주소공유로인해 혼선발생방지위함.)
            for(int j=0; j<n; j++){//방문배열 복제
                visited2[j] = visited[j];
            }

            answer[startIdx] = arr[i];
            visited2[i] = true; //현재 방문한곳을 방문처리


            dfs(startIdx+1, depth+1, visited2);
        }

    }


}//Main Class
