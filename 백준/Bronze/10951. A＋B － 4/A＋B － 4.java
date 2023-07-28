import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while((line = br.readLine())!=null){
        	StringTokenizer st = new StringTokenizer(line, " ");
            String A = st.nextToken();
            String B = st.nextToken();
            int a = Integer.parseInt(A);
            int b = Integer.parseInt(B);
            
            bw.write(a+b+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
    
}