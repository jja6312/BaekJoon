import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
    static Stack<Integer> stack = new Stack<Integer>(); 
   
    
    public static void main(String[] args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
        
    }
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N ; i++){
            String A = br.readLine();
            if(A.charAt(0)=='p'){
                 if(A.charAt(1)=='u'){        //1번
                     st = new StringTokenizer(A, " ");
                     String a = st.nextToken();
                     int b = Integer.parseInt(st.nextToken());
                     stack.push(b);
                 }else if(A.charAt(1)=='o'){    //2번
                     if(stack.size()!=0){
                         bw.write(stack.pop()+"\n");
                     }else{
                         bw.write(-1+"\n");
                     }
                 }
            }else if(A.charAt(0)=='s'){//3번
                bw.write(stack.size()+"\n");
            }else if(A.charAt(0)=='e'){//4번
                if(stack.size()==0){
                    bw.write(1+"\n");
                }else{
                    bw.write(0+"\n");
                }
            }else if(A.charAt(0)=='t'){//5번
                if(stack.size()!=0){
                    bw.write(stack.peek()+"\n");    
                }else{
                    bw.write(-1+"\n");
                }
                
                
            }
            
        }
    }
}