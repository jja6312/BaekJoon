import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        String A = br.readLine();

        String[] arr = A.split("-");

        for(int i=0; i<arr.length; i++){
            if(i==0) sum+= sumCal(arr[i]);
            else sum -= sumCal(arr[i]);
        }





        bw.write("" + sum);

        bw.flush();
        bw.close();
        br.close();
    }

    private static int sumCal(String str) {
        int sumStr = 0;
        String[] plusArr = str.split("\\+");
        for (String x : plusArr) {
            sumStr += Integer.parseInt(x);
        }

        return sumStr;
    }


}