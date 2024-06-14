import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k;

    static int[][] arr;


    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String A = br.readLine();

            for (int j = 0; j < m; j++) {
                int light = A.charAt(j) - '0';
                arr[i][j] = light;

            }

        }

        k = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int zero = 0;
            for(int j=0; j<m; j++){
                sb.append(arr[i][j]);
                if(arr[i][j]==0) zero++;
            }
            if(zero<=k && k%2==zero%2){
                String pattern = sb.toString();
                map.put(pattern, map.getOrDefault(pattern,0)+1);
            }
        }

        int max = 0;
        for(int cnt : map.values()){
            max = Math.max(cnt,max);
        }
        bw.write(max+"");

        bw.flush();
        bw.close();
        br.close();


    }//main


}//Main
