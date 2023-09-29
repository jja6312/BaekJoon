import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void read() throws IOException{
        while(true){
            String A = br.readLine();
            if(A.equals("#")) break;
            //aeiou
            //AEIOU
            int cnt=0;
            for(int i=0; i<A.length(); i++){
                if(A.charAt(i)=='a' || A.charAt(i)=='A' || A.charAt(i)=='e' || A.charAt(i)=='E' || A.charAt(i)=='i' || A.charAt(i)=='I' || A.charAt(i)=='o' || A.charAt(i)=='O' || A.charAt(i)=='u' || A.charAt(i)=='U'){
                    cnt++;
                }
            }
            bw.write(cnt+"\n");
        }
        
    }
    
    
}