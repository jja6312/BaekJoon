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
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        
        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();
        String d = st.nextToken();
        String ab = a+b;
        String cd = c+d;
        long abab = Long.parseLong(ab);
        long cdcd = Long.parseLong(cd);
        bw.write((abab+cdcd)+"");
    }//read()
}//Main