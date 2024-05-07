import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        for(int l=0; l<k; l++){
            int sum=0;
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int h=i-1; h<=x-1; h++){
                for(int w=j-1; w<=y-1; w++){
                    sum += arr[h][w];
                }
            }
            bw.write(sum+"\n");
        }





        bw.flush();
        bw.close();
        br.close();

    }




}//Main Class
