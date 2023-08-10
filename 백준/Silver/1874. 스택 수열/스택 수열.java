import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<Integer>();
        int num = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            while (num <= value) {
                st.push(num++);
                sb.append("+\n");
            }

            if (!st.isEmpty() && st.peek() == value) {
                st.pop();
                sb.append("-\n");
            } else {
                bw.write("NO\n");
                bw.flush();
                return; // 프로그램 종료
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
