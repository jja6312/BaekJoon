import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        String str;
        while((str=br.readLine())!=null){

            bw.write(str+"\n");
            bw.flush();
        }
        bw.close();
        br.close();


    }//main

}//Main Class
