import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            String request = st.nextToken();
            if(request.equals("push")){
                deque.offer(Integer.parseInt(st.nextToken()));
            }else if(request.equals("pop")){
                if(deque.isEmpty()) {
                    bw.write("-1\n");
                }
                else{
                    int pop = deque.pop();
                    bw.write(pop+"\n");
                }

            }else if(request.equals("size")){
                bw.write(deque.size()+"\n");
            }else if(request.equals("empty")){
                if(deque.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }else if(request.equals("front")){
                if(deque.isEmpty()) {
                    bw.write("-1\n");
                }else{
                    
                    bw.write(deque.peekFirst()+"\n");
                }
            }else if(request.equals("back")){
                if(deque.isEmpty()) {
                    bw.write("-1\n");
                }else{
                    
                    bw.write(deque.peekLast()+"\n");
                }
            }

        }//for
        bw.flush();
        bw.close();
        br.close();

    }

}
