import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
    }
    public static void read() throws IOException{
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine, " ");
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int result = logic(k,e);
        bw.write(result +"");

        
    }
    public static Integer logic(int k, int e){
        int round = 0;
        while(k!=e){
            k = k/2 + k%2;
            e = e/2 + e%2;
            round++;
        }
        return round;
    }//logic
}