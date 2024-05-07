import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<2*n-1; i++){
            if(i<n){
                for(int j=0; j<i+1; j++){
                    bw.write("*");
                }
                for(int j=0; j<n-i-1; j++){
                    bw.write(" ");
                }
                for(int j=0; j<n-i-1; j++){
                    bw.write(" ");
                }
                for(int j=0; j<i+1; j++){
                    bw.write("*");
                }
            }else{
                for(int j=0; j<2*n-i-1; j++){
                    bw.write("*");
                }
                for(int j=0; j<2*i-2*n+2; j++){
                    bw.write(" ");
                }
                for(int j=0; j<2*n-i-1; j++){
                    bw.write("*");
                }
            }

            bw.write("\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }




}//Main Class
