
import java.util.*;
import java.io.*;

public class Main{
    static String A;
    static String []arrA;
    static long a1;
    static long b1;
    
    static String B;
    static String []arrB;
    static long a2;
    static long b2;
    
    public static long gcd;
    public static long lcm;
    
    //--main
    public static void main(String[]args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        reader();
    	gcd = gcd(b1, b2);
        lcm = lcm(b1, b2);
        
        long firstBoonjaValue = boonja(a1,b1);
        long secondBoonjaValue = boonja(a2,b2);
        long sum = firstBoonjaValue+secondBoonjaValue;
        
        long gcdResult = gcd(sum,lcm);
        bw.write(sum/gcdResult+" "+lcm/gcdResult);
        bw.flush();
        bw.close();
        
        /*
        최소공배수를 구하고, 분모를 최소공배수로 맞춘다. 그리고 더해주기.
        */
        
    }//main--
    public static void reader() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        A = br.readLine();
        arrA = A.split(" ");
        a1 = Long.parseLong(arrA[0]);
        b1 = Long.parseLong(arrA[1]);
        B = br.readLine();
        arrB = B.split(" ");
        a2 = Long.parseLong(arrB[0]);
        b2 = Long.parseLong(arrB[1]);
        br.close();
    }
    public static long gcd(long b1, long b2){
        while(b2!=0){
            long remainder = b1%b2;
            b1 = b2;
            b2 = remainder;
        }
        return b1;
    }
    
    public static long lcm(long b1, long b2){
        return b1*b2/gcd;
    }
    
    public static long boonja(long a,long b){
        long mulValue = lcm/b;
        return a*mulValue;
    }
}//Main