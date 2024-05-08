import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<2*n-1; i++){
            if(i<n){
                for(int j=0; j<n-i-1; j++){
                    bw.write(" ");
                }
                for(int j=0; j<=i;j++){
                    bw.write("*");
                }
            }else{
                for(int j=0; j<i-n+1; j++){
                    bw.write(" ");
                }
                // n=3 ,i = 3 에서 j가 두번돌아야함.
                // n=3 ,i = 4 에서 j가 한번돌아야함.

                // n=4, i=4에서 j가 3번돌아야함.
                // n=4, i=5에서 j가 2번돌아야함.
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
