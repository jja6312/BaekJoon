import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static Integer[]arr;
        public static void main(String[]args) throws IOException{
            read();
            bw.flush();
            bw.close();
            br.close();
            
        }//main()
    
        public static void read() throws IOException{
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            N = Integer.parseInt(br.readLine());
            arr = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            Deque <Integer> deque = new ArrayDeque<Integer>();
            Integer[] ans = new Integer[N];
            
            
            for(int i=0; i<N; i++) {
            	arr[i]=Integer.parseInt(st.nextToken());
            }
            
            for(int i=0; i<N;i++){
                while(!deque.isEmpty() && arr[deque.peekLast()]<arr[i]) {
                	ans[deque.pollLast()] = arr[i];
                }//while
                deque.offerLast(i);
            }//for
            
            while(!deque.isEmpty()){
            	ans[deque.pollLast()] = -1;
            }
            
            for(int i=0; i<N; i++) {
            	bw.write(ans[i]+" ");
            }
            
        }//read()
}//Main