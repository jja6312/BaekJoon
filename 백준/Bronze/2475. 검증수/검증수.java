import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        StringTokenizer st= new StringTokenizer(A, " ");
        int sum = 0;
        for(int i=0; i<5; i++){
            sum+= Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        int answer = sum%10;
        bw.write(answer+"");


        bw.flush();
        bw.close();
        br.close();


    }//main



}//Main