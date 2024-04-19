import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [] arr;
    static int n;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        //이분탐색
        long startVal = 1;
        long endVal = arr[k-1];
        long answer =0;
        while(startVal<=endVal){
            long mid = (startVal+endVal)/2;
            long cnt= countingN(mid);

            if(cnt>=n){
                answer = mid;
                startVal = mid+1;
            }else{
                endVal = mid-1;
            }

        }//while

        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();

    }//main

    public static long countingN(long mid){
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+= arr[i]/mid;
        }
        return sum;
    }

}//Main class
