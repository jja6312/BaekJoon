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
    static Map<String, Integer> map = new HashMap<>();



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

        dfs(0,0);



        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int startIdx, int depth) throws IOException{
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<m; i++){
                sb.append(answer[i]+" ");
            }
            if(!map.containsKey(String.valueOf(sb))){//이미 입력된 값이 아니라면, 저장하고 출력
                map.put(String.valueOf(sb),1);
                bw.write(String.valueOf(sb));
                bw.write("\n");
            }

            return;
        }

        for(int i=0; i<n; i++){
            if(startIdx>0 && answer[startIdx-1] > arr[i]) continue;
            //결과에 방문한 순서의 배열을 담는다.
            answer[startIdx] = arr[i];
            //다음 index로 넘어간다.
            dfs(startIdx+1, depth+1);
        }

    }


}//Main Class
