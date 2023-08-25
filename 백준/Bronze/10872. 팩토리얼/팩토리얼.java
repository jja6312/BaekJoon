import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        int A = Integer.parseInt(br.readLine());
        int result = 1;
        for(int i=1; i<=A; i++){
            result *= i;
        }
        bw.write(result+"");
    }//read()
}//Main
