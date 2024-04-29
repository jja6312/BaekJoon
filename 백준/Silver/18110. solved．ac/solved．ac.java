import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if(n==0){
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int avg = calAvg(arr);
        bw.write(""+avg);


        bw.flush();
        bw.close();
        br.close();

    }//main

    public static int calAvg(int[] arr){
        int sum = 0;
        int divNum = 0;
        double avg = 0;
        int startIdx = (int)Math.round(arr.length*0.15);
        int endIdx = arr.length-startIdx;

        for(int i=startIdx; i<endIdx; i++){
            sum += arr[i];
            divNum++;
        }

        avg = (double)sum/divNum;
        return (int)Math.round(avg);
    }

}//Main
