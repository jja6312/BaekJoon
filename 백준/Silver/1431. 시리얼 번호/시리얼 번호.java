import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class CompareStr implements Comparable<CompareStr> {
        String str;

        public CompareStr(String str){
            this.str = str;
        }

        @Override
        public int compareTo(CompareStr o) {
            if (str.length() != o.str.length()) {
                return str.length() - o.str.length();
            } else {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isDigit(str.charAt(i))) {
                        sum1 += str.charAt(i) - '0';
                    }
                }
                for (int i = 0; i < o.str.length(); i++) {
                    if (Character.isDigit(o.str.charAt(i))) {
                        sum2 += o.str.charAt(i) - '0';
                    }
                }
                if (sum1 != sum2) {
                    return sum1 - sum2;
                } else {
                    return str.compareTo(o.str);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<CompareStr> pq = new PriorityQueue<>();
        for (int i = 0; i < t; i++) {
            String A = br.readLine();
            pq.offer(new CompareStr(A));
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll().str + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
