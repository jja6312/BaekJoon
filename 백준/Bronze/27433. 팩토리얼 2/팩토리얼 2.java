import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long n = Integer.parseInt(br.readLine());
        long answer = 1;
        while(n>0){
            answer *= n--;
        }
        bw.write(answer+"\n");

        bw.flush();
        bw.close();
        br.close();


    }
}
