import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static class Line implements Comparable<Line>{
        int A;
        int B;

        public Line(int A, int B){
            this.A = A;
            this.B = B;
        }

        @Override
        public int compareTo(Line o){
            return this.A - o.A;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lines.add(new Line(A, B));
        }

        Collections.sort(lines);  // A 기준으로 정렬

        int[] lis = new int[n];
        int lisLength = 0;

        for (Line line : lines) {
            int pos = Arrays.binarySearch(lis, 0, lisLength, line.B);
            if (pos < 0) pos = -pos - 1;
            lis[pos] = line.B;
            if (pos == lisLength) lisLength++;
        }

        int answer = n - lisLength;  // 전체 전깃줄 수 - 가장 긴 증가하는 부분 수열 길이
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}