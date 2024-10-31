import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dice = new int[7]; // 주사위의 각 면 (1번 인덱스가 윗면, 6번이 바닥면)
    static int[] dx = {0, 0, 0, -1, 1}; // 동서북남 이동
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());
            int nx = x + dx[command];
            int ny = y + dy[command];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 지도 범위를 벗어나면 명령 무시
            rollDice(command); // 주사위 굴리기
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6]; // 지도 칸이 0이면 주사위 바닥면 복사
            } else {
                dice[6] = map[nx][ny]; // 지도 칸이 0이 아니면 지도 숫자 복사 후 지도는 0으로
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
            System.out.println(dice[1]); // 윗면 출력
        }
    }

    static void rollDice(int command) {
        int[] temp = dice.clone();
        if (command == 1) { // 동쪽
            dice[1] = temp[4];
            dice[4] = temp[6];
            dice[6] = temp[3];
            dice[3] = temp[1];
        } else if (command == 2) { // 서쪽
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[6] = temp[4];
            dice[4] = temp[1];
        } else if (command == 3) { // 북쪽
            dice[1] = temp[5];
            dice[5] = temp[6];
            dice[6] = temp[2];
            dice[2] = temp[1];
        } else if (command == 4) { // 남쪽
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[6] = temp[5];
            dice[5] = temp[1];
        }
    }
}
