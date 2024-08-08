

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t ++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            // arr 초기화
            for(int i=0; i<n; i++){
                String A = br.readLine();
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(A.charAt(j)+"");
                }
            }

            int mid = n/2;
            int lt = mid;
            int rt = mid;

            int sum = 0;
            //lt~rt까지 합친다.
            for(int i=0; i<n; i++){
                for(int j=lt; j<=rt; j++){
                    sum +=arr[i][j];
                }
                if(i<n/2){
                    lt--;
                    rt++;
                }else{
                    lt++;
                    rt--;
                }

            }
            sb.append(sum).append("\n");
        }//for - test
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }//main()
}
