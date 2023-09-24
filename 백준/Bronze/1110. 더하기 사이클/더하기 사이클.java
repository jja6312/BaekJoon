
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args)throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int a;
        int b;
        int M;
        int cnt=0;
        int O=N;

        while(true){
            /*
            새로운수구하기
            */
            a = N/10;
            b = N - N/10*10;
            M = a+b;
            M = M - M/10*10;
            M = b*10+M;
            //----------------
            cnt++;
            if(M==O){
                break;
            }else{
                N=M;
            }


        }//while
        bw.write(cnt+"");

    }
}