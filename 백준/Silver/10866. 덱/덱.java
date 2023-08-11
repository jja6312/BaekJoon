import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Deque<Integer> deque = new ArrayDeque<Integer>();
    
    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
    }//main
    
    public static void read() throws IOException{
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++){
            String C = br.readLine();
            
            if(C.startsWith("push_front")){
                st = new StringTokenizer(C, " ");
                st.nextToken(); // skip the command
                int B = Integer.parseInt(st.nextToken());
                deque.offerFirst(B);
            }
            else if(C.startsWith("push_back")){
                st = new StringTokenizer(C, " ");
                st.nextToken(); // skip the command
                int B = Integer.parseInt(st.nextToken());
                deque.offerLast(B);
            }
            else if(C.equals("pop_front")){
                if(!deque.isEmpty()) bw.write(deque.pollFirst()+"\n");
                else bw.write("-1\n");
            }
            else if(C.equals("pop_back")){
                if(!deque.isEmpty()) bw.write(deque.pollLast()+"\n");
                else bw.write("-1\n");
            }
            else if(C.equals("size")) {
                bw.write(deque.size()+"\n");
            }
            else if(C.equals("empty")) {
                if(deque.isEmpty()){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }                
            }
            else if(C.equals("front")){
                if(!deque.isEmpty()){
                    bw.write(deque.peekFirst()+"\n");
                }else{
                    bw.write("-1\n");
                }
            }
            else if(C.equals("back")){
                if(!deque.isEmpty()){
                    bw.write(deque.peekLast()+"\n");
                }else{
                    bw.write("-1\n");
                }
            }
        }
    }
}//Main
