import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int sum=0;
        for(int i=0; i<N; i++){
            char s = S.charAt(i);
            int sInt = Character.getNumericValue(s);
            sum += sInt;
        }
        
        bw.write(""+sum);
        bw.flush();
        bw.close();
        br.close();
    }
}