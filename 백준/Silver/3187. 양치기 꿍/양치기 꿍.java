import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static char[][] arr;
    static int[][] move;
    static int sheepTotal;
    static int wolfTotal;
    static int sheep;
    static int wolf;

    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];

        // 1. arr 초기화
        for (int i = 0; i < r; i++) {
            String A = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = A.charAt(j);
                if (arr[i][j] == '#') visited[i][j] = true;
            }
        }

        //상하좌우로 이동하는 로직
        move = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};


        // 2. dfs로 '#'이 아니면 탐색시작
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sheep = 0;
                wolf = 0;
                dfs(i, j);
                if(sheep>wolf) sheepTotal+=sheep;
                else wolfTotal+=wolf;
            }
        }
        bw.write(""+sheepTotal+" "+wolfTotal);
        bw.flush();
        bw.close();
        br.close();


    }//main

    private static void dfs(int y, int x) {
        if (visited[y][x]) return;

        visited[y][x] = true;


        if (arr[y][x] != '#') {
            if(arr[y][x]=='k') sheep++;
            if(arr[y][x]=='v') wolf++;

            for (int i = 0; i < move.length; i++) {
                boolean validation = checkValid(move[i][0] + y, move[i][1] + x);
                if (validation) {//유효범위내라면 dfs실행
                    dfs(y + move[i][0], x + move[i][1]);
                }
            }//for
        }


    }//dfs

    private static boolean checkValid(int dy, int dx) {
        if (dy >= 0 && dy < r && dx >= 0 && dx < c) return true;

        else return false;
    }

}//Main