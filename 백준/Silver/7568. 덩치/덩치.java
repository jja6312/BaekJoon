import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            int rank = 1;
            for(int j=0; j<n; j++){
                if(i==j) continue;

                if(arr[i][0]<arr[j][0] && arr[i][1] < arr[j][1])rank++;
            }

            bw.write(""+rank+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

}//Main