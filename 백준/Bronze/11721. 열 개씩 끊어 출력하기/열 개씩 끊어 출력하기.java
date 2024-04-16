import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String A  =br.readLine();

        while(A.length()>10){
            String subA = A.substring(0,10);
            A = A.substring(10,A.length());
            bw.write(subA+"\n");
        }
        bw.write(A);



        bw.flush();
        bw.close();
        br.close();


    }//main



}//Main