import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String []args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
            
    }
    public static void read() throws IOException{
        int cnt = 0;
        
        for(int i=0; i<8; i++){
            String A = br.readLine();
            for(int j=0; j<8; j++){
                if(i%2==1){
                    if(j%2==1){
                        if(A.charAt(j)=='F') cnt++;
                    }
                }//if1
                else{
                    if(j%2!=1){
                        if(A.charAt(j)=='F') cnt++;
                    }
                }
            }
        }
        bw.write(cnt+"");
        
    }
}