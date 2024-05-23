import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        //부분 배열 합 계산
        List<Integer> sumA = getAllsubarraySums(A);
        List<Integer> sumB = getAllsubarraySums(B);

        //sumA를 TreeMap에 저장
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        for(int sum : sumA){
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum,0)+1);
        }

        //sumB를 탐색하며 T-sumB[i]가 TreeMap에 있는지 확인
        long cnt=0;
        for(int sum:sumB){
            if(sumCountMap.containsKey(t-sum)){
                cnt += sumCountMap.get(t-sum);
            }
        }
        bw.write(cnt+"");


        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static List<Integer> getAllsubarraySums(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int sum=0;
            for(int j=i; j< arr.length; j++){
                sum+=arr[j];
                result.add(sum);
            }
        }

        return result;
    }

}//Main Class
