import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.valueOf(br.readLine());
        for(int i=0; i<N; i++){
            String a = br.readLine();
            char first = a.charAt(0);
            char last = a.charAt(a.length()-1);
            bw.write(""+first+last+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }//main()
}//Main class