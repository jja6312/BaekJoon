

import java.io.*;
import java.util.StringTokenizer;

// ============= 문제 접근 =============
// n이 100,000 이므로, 만약 n^2 이라면 10,000,000,000 => 백억. 즉 n log n으로 문제를 풀어야 한다.
// 2중 for문으로 수행하되, 2중 for문 내부에서 조건을 충족하지않을때 바깥 for 그만큼을 건너뛰고 그다음부터 검사를 수행한다.(길게 쩜프하는 전략)
// 이러한 전략을 '길어지는 경우' 와 '짧아지는 경우' 총 두 번 수행한다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[]arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        //길어지는 수열
        for(int i=0; i<n-1; i++){
            int len = 1;
            for(int j=i; j<n-1; j++){
                if(arr[j] <= arr[j+1]){
                    len++;
                }else{
                    i=j;// i를 j부터 건너뛰고 시작한다. i와 j사이에는 어차피 현재 len보다 긴게 나올수가없음.
                    break;
                }
            }
            max = Math.max(max,len);
        }

        //짧아지는 수열
        for(int i=0; i<n-1; i++){
            int len = 1;
            for(int j=i; j<n-1; j++){
                if(arr[j] >= arr[j+1]){
                    len++;
                }else{
                    i=j;// i를 j부터 건너뛰고 시작한다. i와 j사이에는 어차피 현재 len보다 긴게 나올수가없음.
                    break;
                }
            }
            max = Math.max(max,len);
        }
        if(n == 1){
            sb.append("1");
        }else{
            sb.append(max);
        }
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
