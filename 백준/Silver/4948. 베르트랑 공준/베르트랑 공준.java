import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long N;
    
    public static void main(String[]args) throws IOException{
        
    	while(true) {
        	long number = Long.parseLong(br.readLine());
        	if (number==0) break;
        	long result = inspector(number);
        	bw.write(result+"\n");
        	
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }//main
    

    public static boolean isSosu(long n){
        if(n<=1) return false;
        for(long i=2; i<=(long)Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }//isSosu()
    
    public static long inspector(long number){
        long count=0;
        for(long i=number+1; i<=2*number; i++){
            if(isSosu(i)==true) count++;
        }
        return count;
    }
    
    
}//Main