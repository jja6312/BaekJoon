import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.valueOf(br.readLine());    
        int M = N;
        
        int divFive = N/5; //5로 '나눈' 값
        int divThree = 0; //3으로 '나눌' 값
        boolean trueSwitch=false;
        
        if(N%5==0) {
            bw.write(""+divFive); 
        } else {                
            if(N>=5){
                while(divFive>=0){
                	M=N-divFive*5;
                    if(M%3==0){  
                        divThree=M/3;
                        bw.write((divFive+divThree)+""); 
                        trueSwitch=true;
                        break;
                    }
                    divFive-=1;  
                }
                if(trueSwitch==false){
                   bw.write(""+(-1)); 
                }
            } else if(N%3==0) {
                bw.write(""+N/3);
            } else {
               bw.write(""+(-1)); 
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
