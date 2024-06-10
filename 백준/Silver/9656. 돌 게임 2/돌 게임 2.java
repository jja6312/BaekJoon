import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        if(n%2==0){
            bw.write("SK");
        }else{
            bw.write("CY");
        }


        bw.flush();
        bw.close();
        br.close();


    }//main


}//Main
