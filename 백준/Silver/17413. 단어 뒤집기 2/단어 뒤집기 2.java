import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String []args) throws IOException {
        String input = br.readLine();
        SpecialString(input);
        
        bw.flush();
        bw.close();
        br.close();
    }

   public static void SpecialString(String input) throws IOException {
    int len = input.length();
    int i = 0;

    while (i < len) {
        // <와 > 사이의 문자는 그대로 출력
        if(input.charAt(i) == '<') {
            while(i < len && input.charAt(i) != '>') {
                bw.write(input.charAt(i++));
            }
            if (i < len) {
                bw.write(input.charAt(i++));
            }
        }
        // 단어 뒤집기
        else {
            Deque<Character> stack = new ArrayDeque<>();
            while(i < len && input.charAt(i) != '<' && input.charAt(i) != ' ') {
                stack.push(input.charAt(i++));
            }

            while(!stack.isEmpty()) {
                bw.write(stack.pop());
            }

            if(i < len && input.charAt(i) == ' ') {
                bw.write(input.charAt(i++));
            }
        }
    }
}

}
