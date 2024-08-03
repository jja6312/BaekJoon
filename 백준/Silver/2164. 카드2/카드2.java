
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            deque.offerLast(i);
        }

        while(deque.size()>1){
            deque.pollFirst();
            deque.offerLast(deque.pollFirst());
        }

        bw.write(deque.peek()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
