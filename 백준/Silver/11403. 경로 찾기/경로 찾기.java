import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer>[] listArr;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1; k<=n; k++){
            for(int s=1; s<=n; s++){
                for(int e=1; e<=n; e++){
                    if(arr[s][k]==1 && arr[k][e]==1) arr[s][e] = 1;
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                bw.write(arr[i][j]+" ");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
