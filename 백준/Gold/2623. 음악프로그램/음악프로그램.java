import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        List<Integer>[] arrList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arrList[i] = new ArrayList<>();
        }

        //위상정렬
        int[] indegree = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for(int j=1; j<num; j++){
                int singer = Integer.parseInt(st.nextToken());
                arrList[before].add(singer);
                indegree[singer]++;//현재 가수의 간선 개수 늘리기

                before = singer;//전,후 숫자를 그래프로 잇기 위해 before 초기화
            }
        }

        String ans = topologicalSort(arrList, indegree, n);
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static String topologicalSort(List<Integer>[] arrList, int[] indegree, int n) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(indegree[i]==0){//간선이 없는 가수 i에 대해
                queue.offer(i);//queue에 추가한다.
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();//가수를 꺼내서
            result.add(now);//결과에 순서대로 담는다

            for(int next: arrList[now]){//해당 가수 다음 순서 가수를 꺼낸다.
                indegree[next]--; // 다음 가수의 간선을 하나 빼고
                if(indegree[next]==0){// 이 가수를 호출하는 가수가 더이상 없으면
                    queue.offer(next); //큐에 담는다.
                }
            }
        }

        //위 반복문의 결과가 n이 아니라면 사이클이 발생했다는 의미
        if(result.size()!=n) return "0";

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.size(); i++){
            sb.append(result.get(i)+"\n");
        }
        return sb.toString();
    }

}//Main Class
