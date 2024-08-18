

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test=0; test<4; test++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());


            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                sb.append("d\n"); // 서로 겹치지 않는 경우
            } else if ((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2)
                    || (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2)) {
                sb.append("c\n");
            } else if (p1 == x2 || p2 == x1 || q1 == y2 || q2 == y1) {
                sb.append("b\n"); // 선으로 만나는 경우
            } else {
                sb.append("a\n"); // 겹치는 경우
            }
        }//for


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
