import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack <Integer>st = new Stack<Integer>();
    static long sum=0;
    public static void main(String[]args) throws IOException{
    	read();
        while(!st.isEmpty()) {
        	sum+=(long)st.pop();
        	
        }
        
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
        
    	
    }//main
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                st.pop();
            }else{
                st.push(a);
            }
        }
    }
}//Main