import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> deque = new LinkedList<Integer>();

    public static void main(String[]args) throws IOException{
    	read();
        bw.flush();
        bw.close();
        br.close();

        
    }//main()
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String A = br.readLine();
            String[] arrA;
            
            if(A.charAt(0)=='1'){
                arrA=A.split(" ");
                int x = Integer.parseInt(arrA[1]);
                deque.addFirst(x);
                
            }else if(A.charAt(0)=='2'){
                arrA=A.split(" ");
                int x = Integer.parseInt(arrA[1]);
                deque.addLast(x);
                
            }else if(A.charAt(0)=='3'){
                if(!deque.isEmpty()) bw.write(deque.pollFirst()+"\n");
                else bw.write(-1+"\n");
                
            }else if(A.charAt(0)=='4'){
                 if(!deque.isEmpty()) bw.write(deque.pollLast()+"\n");
                else bw.write(-1+"\n");
                 
            }else if(A.charAt(0)=='5'){
                bw.write(deque.size()+"\n");
                
            }else if(A.charAt(0)=='6'){
                if(deque.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
                
            }else if(A.charAt(0)=='7'){
                if(!deque.isEmpty()) bw.write(deque.peekFirst()+"\n");
                else bw.write(-1+"\n");
                
            }else if(A.charAt(0)=='8'){
                if(!deque.isEmpty()) bw.write(deque.peekLast()+"\n");
                else bw.write(-1+"\n");
                
            }
            
        }

    }
    
}//Main