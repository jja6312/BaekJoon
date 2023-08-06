import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[]args) throws IOException{
        readAndCal();
        bw.flush();
        bw.close();
        br.close();
    	
    	
    }//main
    
    public static void readAndCal() throws IOException{
        long N = Long.parseLong(br.readLine());
        for(long i=0; i<N; i++){
            long number = Long.parseLong(br.readLine());
            while(true){
                if (isNotSosu(number)==false) break;
                number++;
            }//while
            bw.write(number+"\n");
        }
    }
    
    public static boolean isNotSosu(long n){
    	if(n<=1) return true;
        for(long i=2; i<=Math.sqrt(n); i++){
                if(n%i==0) return true;
            }//for
        return false;
        
    }//isSosu
}//Main