import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count[] = new int[10000];
        
        for(int i=0; i<10000; i++) {
        	count[i] = 0; 
        }
        
        for(int i=0; i<N; i++){
            int M = Integer.parseInt(br.readLine());
            count[M-1]+=1;
        }
        
        for(int i=0; i<10000; i++){
            if(count[i]!=0){
            	for(int j=0; j<count[i];j++) {
            		bw.write(i+1+"\n");    
            	}
            }
        }
        bw.flush();
        bw.close();
        br.close();
       
        
    }//main()
}//Main