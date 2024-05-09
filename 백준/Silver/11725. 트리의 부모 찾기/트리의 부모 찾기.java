import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer>[] node;
    static boolean[] visited;
    static int[] root;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        node = new ArrayList[n+1];
        visited = new boolean[n+1];
        root = new int[n+1];

        StringTokenizer st;

        for(int i=0; i<=n; i++){
            node[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine()," ");
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            node[lt].add(rt);
            node[rt].add(lt);

        }



        //한 번 방문한 노드는 방문하지않고,
        //루트에서 하위노드를 모두탐색하면서 관계를 정립해가자.
        bfs(1);

        for(int i=2; i<=n; i++){
            bw.write(root[i]+"\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs(int startNode) {
        if(visited[startNode]) return; //이미방문한곳이면 return;

        visited[startNode] = true;//현재방문한 노드를 방문처리

        for(int subNode: node[startNode]){
            //부모관계를 정의
            if(!visited[subNode]){//조건문 없을떈 다시업데이트돼버리는문제. 따라서 한번업데이트된건 다시업데이트하지않아야함.
                root[subNode] = startNode;
            }


            //하위노드들을 탐색
            bfs(subNode);
        }

    }


}//Main Class
