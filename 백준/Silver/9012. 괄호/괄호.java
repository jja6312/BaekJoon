import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[]args) throws IOException{
    	read();
        bw.flush();
        bw.close();
        br.close();
        
    	
    }//main
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String A = br.readLine();
            char left = '(';
            char right = ')';
            
            int count=0;
            int count2=0;
            boolean trueInspector=true;
            for(int j=0; j<A.length(); j++){
                if(A.charAt(j)=='(') count++;
                else if(A.charAt(j)==')'){
                    count2++;
                    if(count<count2) trueInspector=false;
                }
                if(j==A.length()-1){
                    if(count!=count2) trueInspector=false;
                }//if
            }//for2
            if(trueInspector){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
            
        }//for1
    }//read()
}//Main