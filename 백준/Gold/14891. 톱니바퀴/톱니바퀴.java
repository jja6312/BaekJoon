import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Integer>[] listArr = new LinkedList[5];
    static int sum;
    static int k;

    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        String D = br.readLine();

        for (int i = 1; i <= 4; i++) {
            listArr[i] = new LinkedList<>();
        }

        for (int i = 0; i < 8; i++) {
            listArr[1].add(A.charAt(i) - '0');
            listArr[2].add(B.charAt(i) - '0');
            listArr[3].add(C.charAt(i) - '0');
            listArr[4].add(D.charAt(i) - '0');
        }

        k = Integer.parseInt(br.readLine()); // 회전 회수

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            // 1. 회전시킨 톱니바퀴의 번호
            int num = Integer.parseInt(st.nextToken());
            // 2. 방향
            int direction = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[5]; // 방문 배열 초기화
            rotate(num, direction, visited);
        }

        int point = 1;
        for (int i = 1; i <= 4; i++) {
            if (listArr[i].get(0) == 1) sum += point;
            point *= 2;
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void rotate(int num, int direction, boolean[] visited) {
        if (visited[num]) return; // 방문했으면 방문하지 않는다.
        visited[num] = true;

        // 좌, 우를 회전
        int left = num - 1;
        int right = num + 1;

        if (left >= 1 && !visited[left] && listArr[num].get(6) != listArr[left].get(2)) {
            rotate(left, direction * -1, visited);
        }

        if (right <= 4 && !visited[right] && listArr[num].get(2) != listArr[right].get(6)) {
            rotate(right, direction * -1, visited);
        }

        // 현재 톱니바퀴 회전
        if (direction == 1) {
            int last = listArr[num].get(7);
            listArr[num].remove(7); // 마지막 순서를 지우고
            listArr[num].addFirst(last); // 가장 앞에 추가시킨다.
        } else {
            int first = listArr[num].get(0);
            listArr[num].remove(0);
            listArr[num].addLast(first);
        }
    }
}
