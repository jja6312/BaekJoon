import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int n;
    static int m;



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];


        //depth가 0인 dfs를통해 경우의수를모두출력하자.
        dfs(0);

        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int depth) throws IOException{
        if(depth==m){
            for(int i=0; i<m; i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }


        for(int i=1; i<=n; i++){
            if(depth>0 && arr[depth-1] > i) continue;

            arr[depth] = i;
            dfs(depth+1);
        }

    }


}//Main Class
