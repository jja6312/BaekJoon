import java.awt.*;
import java.io.*;
import java.util.*;

class Point {
    private int x;
    private int y;
    private int distance;

    public Point(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance(){
        return this.distance;
    }

}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    static int answer;
    static boolean[][] isVisited;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isVisited = new boolean[n][m];


        //갔던 길은 가지 않고 최소값을 구하자.

        //1. 초기화
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt("" + str.charAt(j));
            }//for2
        }//for1

        answer=bfs(0,0);


        bw.write("" + answer);
        bw.flush();
        bw.close();
        br.close();


    }//main

    private static int bfs(int y, int x) {
        Deque<Point> deque = new ArrayDeque();
        deque.add(new Point(y, x, 1));
        isVisited[y][x] = true;



        while (!deque.isEmpty()) {
            Point p = deque.poll();

            if (p.getY() == n - 1 && p.getX() == m - 1) return p.getDistance();

            //상하좌우로 이동
            int[] dx = {0, 0, -1, 1};
            int[] dy = {1, -1, 0, 0};
            for (int i = 0; i < 4; i++) {
                int moveX = dx[i] + p.getX();
                int moveY = dy[i] + p.getY();

                if (moveX < m && moveX >= 0 && moveY < n && moveY >= 0 && !isVisited[moveY][moveX]  && arr[moveY][moveX] == 1) {
                    
                    deque.add(new Point(moveY, moveX, p.getDistance()+1));
                    isVisited[moveY][moveX] = true;
                }

            }//for
        }//while

        return -1; // 도달할 수 없는 경우
    }//bfs
}//MainClass