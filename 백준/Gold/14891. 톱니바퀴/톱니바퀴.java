import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Integer>[] listArr = new LinkedList[5];
    static int sum;
    static int k;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        for(int i=1; i<=4; i++){
            listArr[i] = new LinkedList<>();
        }

        // 톱니바퀴 상태 입력 받기
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        String D = br.readLine();

        for(int i=0; i<8; i++){
            listArr[1].add(A.charAt(i)-'0');
            listArr[2].add(B.charAt(i)-'0');
            listArr[3].add(C.charAt(i)-'0');
            listArr[4].add(D.charAt(i)-'0');
        }

        k = Integer.parseInt(br.readLine()); // 회전 회수

        StringTokenizer st;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()); // 회전시킨 톱니바퀴의 번호
            int direction = Integer.parseInt(st.nextToken()); // 방향

            visited = new boolean[5]; // 방문 배열 초기화
            rotate(num, direction); // 회전 함수 호출
        }

        int point = 1;
        for(int i=1; i<=4; i++){
            if(listArr[i].get(0) == 1) sum += point;
            point *= 2;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void rotate(int num, int direction) {
        if(visited[num]) return; // 이미 방문한 톱니바퀴는 다시 방문하지 않음

        visited[num] = true; // 현재 톱니바퀴 방문 처리

        int left = num - 1;
        int right = num + 1;

        // 왼쪽 톱니바퀴 확인 및 회전
        if(left >= 1 && !visited[left] && listArr[num].get(6) != listArr[left].get(2)) {
            rotate(left, -direction);
        }

        // 오른쪽 톱니바퀴 확인 및 회전
        if(right <= 4 && !visited[right] && listArr[num].get(2) != listArr[right].get(6)) {
            rotate(right, -direction);
        }

        // 현재 톱니바퀴 회전
        if(direction == 1) { // 시계 방향
            int last = listArr[num].removeLast();
            listArr[num].addFirst(last);
        } else if(direction == -1) { // 반시계 방향
            int first = listArr[num].removeFirst();
            listArr[num].addLast(first);
        }
    }
}
