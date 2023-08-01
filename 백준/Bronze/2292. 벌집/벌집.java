import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Integer.valueOf(br.readLine());
        
        int count=1;
        int i = 1;
        while(N>i){
            i += count*6;
            count++;
        }
        bw.write(""+count);
        bw.flush();
        bw.close();
        br.close();
    }
}