import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

import static java.nio.file.Files.move;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int n;
    static int cnt;

    
    

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);
        bw.write(""+cnt);

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int depth) {
        if(depth==n) {
            cnt++;
            return;
        }
        for(int i=0; i<n; i++){
            arr[depth] = i;
            if(possible(depth)){
                dfs(depth+1);
            }
        }
    }

    private static boolean possible(int col) {
        for(int i=0; i<col; i++){

            //수평에 값이 있으면 false
            if(arr[i]==arr[col]) return false;

            //대각에 값이 있으면 false
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) return false;
        }
        return true;


    }
}//Main Class
