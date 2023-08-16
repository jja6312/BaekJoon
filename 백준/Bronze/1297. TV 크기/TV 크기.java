import java.util.*;
import java.io.*;

public class Main{
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static StringTokenizer st;
        public static void main(String[]args) throws IOException{
            read();
            bw.flush();
            bw.close();
            br.close();
            
        }//main()
    
        public static void read() throws IOException{
            String A = br.readLine();
            st = new StringTokenizer(A, " ");
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            //(H^2+W^2)X^2 = D^2
            //double x = (double)d^2/(h^2+w^2)
            double xx = (double)D*D/(H*H+W*W);
            double x = Math.sqrt(xx);
            double w = x*W;
            double h = x*H;
            bw.write((int)h+" "+(int)w);
        }//read()
}//Main