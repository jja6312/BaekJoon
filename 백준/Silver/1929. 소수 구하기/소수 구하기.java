import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    
    public static void main(String[]args) throws IOException{
    	read();
        for(int i=N; i<=M; i++){
            if(isSosu(i)==true) bw.write(i+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    	
    }//main
    
    public static void read() throws IOException{
        String A = br.readLine();
        String[] arrA = A.split(" ");
        N = Integer.parseInt(arrA[0]);
        M = Integer.parseInt(arrA[1]);
    }//read()
    
    public static boolean isSosu(int n){
        if(n<=1) return false;
        else{
            for(int i=2; i<=Math.sqrt(n); i++){
                if (n%i==0) return false;
            }
        }//else
        return true;
    }
}//Main