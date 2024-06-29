import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        for(int i=0; i<A.length(); i++){
            bw.write((int)A.charAt(i)-64+" ");
        }



        bw.flush();
        bw.close();
        br.close();

    }



}
