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

    }//main()

    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int count=0;
        for(int i=5; i<=N; i*=5){
            count+= N/i;
        }
        
        
        bw.write(count+"");
    }//read()
}//Main
   