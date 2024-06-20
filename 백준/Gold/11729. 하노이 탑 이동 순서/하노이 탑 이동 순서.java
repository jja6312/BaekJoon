import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        //이동횟수
        bw.write((int)Math.pow(2,n)-1+"\n");
        dfs(n,1,2,3);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int n, int from, int aux, int to) throws IOException {
        if(n==1){
            bw.write(from+" "+to+"\n");
            return;
        }

        //n-1개를 from 에서 aux로 이동
        dfs(n-1,from,to,aux);

        //가장 큰 원판을 from에서 to로 이동
        bw.write(from +" "+to+"\n");

        //n-1개를 aux에서 to으로 이동
        dfs(n-1,aux,from,to);
    }


}
