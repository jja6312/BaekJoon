import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ans;
    static int n;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        //setting
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        StringTokenizer st;

        //init
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs
        ans = 0;
        dfs(1, 2, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }


    private static void dfs(int y, int x, int direction) {
        //direction==0 파이프 가로방향
        //direction==1 파이프 세로방향
        //direction==2 파이프 대각선방향

        if (y == n && x == n) {
            ans++;
            return;
        }
        if (direction == 0) {
            if (x + 1 <= n && map[y][x + 1] == 0) {//가로일 경우 오른쪽으로 갈 수 있음
                dfs(y, x + 1, 0);
            }
        } else if (direction == 1) {//세로일 경우 아래로 갈 수 있음
            if (y + 1 <= n && map[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
        } else if (direction == 2) {//대각일 경우 오른쪽이나 아래쪽으로 갈 수 있음.
            if (x + 1 <= n && map[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }

            if (y + 1 <= n && map[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
        }

        //파이프의 방향과 관계 없이, 대각선으로 갈 수 있음.
        if (x + 1 <= n && y + 1 <= n && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0) {
            dfs(y + 1, x + 1, 2);
        }

    }


}//Main Class
