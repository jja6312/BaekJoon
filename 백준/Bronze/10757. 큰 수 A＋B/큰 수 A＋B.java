import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    public static void main(String[] args) throws IOException {

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        String lt = st.nextToken();
        String rt = st.nextToken();

        int ltLen = lt.length();
        int rtLen = rt.length();

        int max = Math.max(ltLen,rtLen);
        int min = Math.min(ltLen,rtLen);


        String zero = "";
        for(int i=0; i<max-min; i++){
            zero += "0";
        }

        if(ltLen==max){
            zero+=rt;
            rt = zero;
        }else{
            zero+=lt;
            lt = zero;
        }

        int[] ltArr = new int[max];
        int[] rtArr = new int[max];
        int[] sum = new int[max];


        for(int i=max-1; i>=0; i--){
            ltArr[i] = Integer.parseInt(""+lt.charAt(i));
            rtArr[i] = Integer.parseInt(""+rt.charAt(i));

            sum[i] += ltArr[i] + rtArr[i];

            if(i!=0 && sum[i]/10>=1) {
                sum[i-1] += 1;
                sum[i] -= 10;
            }
        }

        for(int x: sum){
            bw.write(""+x);
        }





        bw.flush();
        bw.close();
        br.close();
    }//main

}//Main