import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        int start = 1;
        while(sum+start<=n){
            sum+=start;
            start++;
        }
        bw.write(start-1+"");


        bw.flush();
        bw.close();
        br.close();


    }//main



}//Main
