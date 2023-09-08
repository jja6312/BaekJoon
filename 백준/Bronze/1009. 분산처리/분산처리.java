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
        int N = Integer.parseInt(br.readLine());
        String B;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            B = br.readLine();
            st = new StringTokenizer(B, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = a%10;
            int result = 1;
            for(int j=0; j<b; j++) {
            	result = (result*a)%10; 
            }
            if(result==0) {
            	result = 10;
            }
            bw.write(result+"\n");
        }
    }//read()
}//Main
