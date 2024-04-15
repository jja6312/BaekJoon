import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    public static void main(String[] args) throws IOException {

        arr = new int[10001];
        for(int i=1; i<=10000; i++){
            loop(i);
        }
        arr[2] = -1;
        arr[4] = -1;
        arr[6] = -1;
        arr[8] = -1;
        arr[10] = -1;
        arr[12] = -1;
        arr[14] = -1;
        arr[16] = -1;
        arr[18] = -1;

        for(int i=1; i<=10000; i++){
            if(arr[i]==0) bw.write(i+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }//main

    public static void loop(int num){
        if(num<10) return;
        if(num>10000) return;

        String A = ""+num;
        int sum=num;
        for(int i=0; i<A.length(); i++){
            sum+=Integer.parseInt(""+A.charAt(i));
        }
        if(sum>10000) return;
        arr[sum] = -1;
        loop(sum);
    }


}//Main