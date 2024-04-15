import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){


            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            arr = new int[k+1][16];

            for(int l=1; l<=15; l++){
                arr[0][l] = l;
            }

            for(int j=1; j<=k; j++){
                int sum = 0;
                for(int l=1; l<=n; l++){
                     sum += arr[j-1][l];
                    arr[j][l] = sum;
                }

            }



            bw.write(arr[k][n]+"\n");


        }

        bw.flush();
        bw.close();
        br.close();
    }//main



}//Main