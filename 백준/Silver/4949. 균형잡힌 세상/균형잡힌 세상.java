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
        
        while(true){
            String A = br.readLine();
            if(A.equals(".")) break;
            char[] arrA = new char[A.length()];
            Stack<Character> st = new Stack<Character>();
            boolean trueSwitch = true;
            
            for(int i=0; i<A.length(); i++){
                arrA[i] = A.charAt(i);
                if(arrA[i]=='[' || arrA[i]=='(') {
                	st.push(arrA[i]);
                	
                }
                else if(arrA[i]==']') {
                	if(st.isEmpty() || st.pop() != '[' ) {
                		trueSwitch = false;
                		break;
                	}
                	
                }
                
                else if(arrA[i]==')') {
                	if(st.isEmpty() || st.pop() != '(' ) {
                		trueSwitch = false;
                		break;
                	}
                	
                }
            
            }//for
            if(!st.isEmpty()) {
            	trueSwitch=false;
            }
            if(trueSwitch==false){
                bw.write("no\n");
            }else{
                bw.write("yes\n");
            }
        }//while
    }//read()
}//Main