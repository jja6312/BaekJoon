import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //abcdefghijklmnopqrstuvwxyz
        //97~122
        String S = br.readLine();
        for(int i=97; i<123; i++){
            char castingNumber = (char)i;
            int check = S.indexOf(castingNumber);
            bw.write(""+check+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}