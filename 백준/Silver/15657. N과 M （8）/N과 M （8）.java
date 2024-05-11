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

        dfs(0,0);



        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int startIdx, int depth) throws IOException{
        if(depth == m){
            for(int i=0; i<m; i++){
                bw.write(answer[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(startIdx>0 && answer[startIdx-1] > arr[i]) continue;
            answer[startIdx] = arr[i];


            dfs(startIdx+1, depth+1);
        }

    }


}//Main Class
