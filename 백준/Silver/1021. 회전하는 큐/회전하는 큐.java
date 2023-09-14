import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		read();
		bw.flush();
		bw.close();
		br.close();
	}

	public static void read() throws IOException {
	    String A = br.readLine();
	    StringTokenizer st = new StringTokenizer(A, " ");

	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    Deque<Integer> deque = new ArrayDeque<>();
	    int[] arrM = new int[M];

	    for (int i = 1; i <= N; i++) {
	        deque.offerLast(i);
	    }

	    String B = br.readLine();
	    st = new StringTokenizer(B, " ");
	    for (int i = 0; i < M; i++) {
	        arrM[i] = Integer.parseInt(st.nextToken());
	    }

	    int cnt = 0;
	    for (int i = 0; i < M; i++) {
	        int target = arrM[i];
	        int index = 0;
	        for (Integer num : deque) {
	            if (num == target) break;
	            index++;
	        }
	        
	        int left = index;
	        int right = deque.size() - index;

	        cnt += Math.min(left, right);

	        while (deque.peekFirst() != target) {
	            if (left < right) {
	                deque.offerLast(deque.pollFirst());
	            } else {
	                deque.offerFirst(deque.pollLast());
	            }
	        }

	        deque.pollFirst();
	    }
	    
	    bw.write(cnt + "");
	}

}