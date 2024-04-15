import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());


        for(int i=0; i<n; i++){
            int sum = calSum(br.readLine());
            bw.write(sum+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

    public static int calSum(String A){
        int plus = 0;
        int sum=0;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='O'){
                plus++;
                sum+=plus;
            }else{
                plus=0;
            }
        }
        return sum;
    }

}//Main