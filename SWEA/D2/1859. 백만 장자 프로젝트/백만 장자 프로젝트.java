

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t ++) {
            sb.append("#").append(t).append(" ");
            //입력값받기
            int n = Integer.parseInt(br.readLine());

            //arr초기화
            int[] arr = new int[n];
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 맨 뒤에서부터 탐색하며, max를 초기화한다.
            // 본인보다 작은 값이 나오면 그 차이를 sum에 합친다.
            // 본인보다 큰 값이 나온다면 max를 초기화한다.
            int max = -1;
            long sum = 0;
            for(int i=n-1; i>=0; i--){
                if(arr[i]>max){//현재 값이 최대값이라면
                    max = arr[i];
                }else{//자기보다 작은 값이 나온다면
                    sum += max - arr[i]; // 차액을 합계에 더한다.
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
