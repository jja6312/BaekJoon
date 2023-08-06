
import java.util.*;
import java.io.*;

public class Main{
    static long gcd;
    long lcm;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        String[] aArr = A.split(" ");
        long a = Long.parseLong(aArr[0]);
        long b = Long.parseLong(aArr[1]);
        Main m = new Main();
        gcd = gcd(a,b);
        m.lcm = lcm(a,b);
        bw.write(""+m.lcm);
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static long gcd(long a, long b){
        while(b!=0){
            long remainder = a%b;
            a = b;
            b = remainder;
        }
        return a;
    }
    
    public static long lcm(long a, long b){
    	Main m = new Main();
        m.lcm = a*b/gcd;
        return m.lcm;
    }
}