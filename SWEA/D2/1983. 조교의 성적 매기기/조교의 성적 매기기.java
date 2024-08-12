

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Student implements Comparable<Student> {
        int no;
        int 중간고사;//35%
        int 기말고사;//45%
        int 과제;//20%
        double 총점;

        public Student(int no, int 중간고사, int 기말고사, int 과제) {
            this.no = no;
            this.중간고사 = 중간고사;
            this.기말고사 = 기말고사;
            this.과제 = 과제;
            this.총점 = 중간고사 * 0.35 + 기말고사 * 0.45 + 과제 * 0.2;
        }

        @Override
        public int compareTo(Student o) {
            return o.총점 - 총점 > 0 ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            PriorityQueue<Student> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int 중간고사 = Integer.parseInt(st.nextToken());
                int 기말고사 = Integer.parseInt(st.nextToken());
                int 과제 = Integer.parseInt(st.nextToken());
                pq.offer(new Student(i + 1, 중간고사, 기말고사, 과제));
            }
            //k번째 학생이 상위 몇프로인지 번호순으로 꺼내본다.
            int rankOfTop = 0;
            while (!pq.isEmpty()) {
                Student student = pq.poll();
                rankOfTop++;
                if (student.no == k) break;
            }

            //등수를 등급으로 전환
            double rangeOfTop = (double) rankOfTop / n;
            if (rangeOfTop <= 0.1) sb.append("A+\n");
            else if (0.1 < rangeOfTop && rangeOfTop <= 0.2) sb.append("A0\n");
            else if (0.2 < rangeOfTop && rangeOfTop <= 0.3) sb.append("A-\n");
            else if (0.3 < rangeOfTop && rangeOfTop <= 0.4) sb.append("B+\n");
            else if (0.4 < rangeOfTop && rangeOfTop <= 0.5) sb.append("B0\n");
            else if (0.5 < rangeOfTop && rangeOfTop <= 0.6) sb.append("B-\n");
            else if (0.6 < rangeOfTop && rangeOfTop <= 0.7) sb.append("C+\n");
            else if (0.7 < rangeOfTop && rangeOfTop <= 0.8) sb.append("C0\n");
            else if (0.8 < rangeOfTop && rangeOfTop <= 0.9) sb.append("C-\n");
            else if (0.9 < rangeOfTop && rangeOfTop <= 1) sb.append("D0\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
