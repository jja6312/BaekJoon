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
        int N = A.length();
        Deque<Integer> arrDeque = new ArrayDeque<Integer>();

        // 2진수 문자열을 뒤에서부터 3자리씩 끊어서 8진수로 변환
        // 이 부분의 시간 복잡도는 O(N)
        for (int i = N - 1; i >= 0; i -= 3) {
            int sum = 0;

            // 각 3자리 블록에 대해 8진수 숫자 하나를 계산
            // 이 내부 루프는 상수 시간 O(1)을 소요
            for (int j = 0; j < 3; ++j) {
                if (i - j < 0) break;
                int bitValue = A.charAt(i - j) - '0';
                sum += bitValue * (int) Math.pow(2, j);
            }

            // 계산된 8진수 숫자를 앞에 추가 (Deque를 사용)
            arrDeque.offerFirst(sum);
        }

        // 최종 8진수 문자열을 만들기
        // 이 부분의 시간 복잡도는 O(N)
        StringBuilder sb = new StringBuilder();
        while (!arrDeque.isEmpty()) {
            sb.append(arrDeque.pollFirst());
        }

        bw.write(sb.toString());
    } // read()
} // Main
