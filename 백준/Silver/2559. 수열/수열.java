

import java.io.*;
import java.util.StringTokenizer;


//============= 문제 접근 =============
// n = 100,000. 즉 n log n으로 문제를 접근해야 한다.
// k는 연속적인 날짜의 수이므로, lt = 0, rt =k-1으로 설정한다.  lt~rt 구간합을 구하고, 우측으로 한칸씩 이동하며 lt의값을 빼고 rt+1의 값을 더하는식으로 값을 구하는 문제.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = k-1;
        int max = 0;
        //초기 값 설정
        for(int i=lt; i<=rt; i++){
            max += arr[i];
        }
        int sum = max; //현재 구간의 합
        lt++; //다음구간의합부터 반복문수행
        rt++;
        while(rt<n){
            sum -= arr[lt-1];// 구간에서 벗어난부분을 뺀다.
            sum += arr[rt];//구간에서 추가된부분을 더한다.

            max = Math.max(max,sum);

            lt++;
            rt++;
        }

        sb.append(max);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
