import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1,0);

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int startNum, int depth) throws IOException {

        if(depth==m){
            for(int x: arr){
                bw.write(x+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=startNum; i<=n; i++){
            arr[depth] = i;
            dfs(i+1,depth+1);
        }
    }


}//Main Class
