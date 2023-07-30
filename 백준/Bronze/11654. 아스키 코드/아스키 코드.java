import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        char s = S.charAt(0);
        bw.write(Integer.toString((int)s));
        bw.flush();
        bw.close();
        br.close();
    }
}