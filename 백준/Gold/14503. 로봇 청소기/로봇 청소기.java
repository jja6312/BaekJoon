import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[][] map;
    static int cnt;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moveRobot(r, c, direction);

        bw.write(cnt+"");


        bw.flush();
        bw.close();
        br.close();
    }

    private static void moveRobot(int r, int c, int direction) {
        //현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
        if (map[r][c] == 0) {
            cnt++;
            map[r][c] = -1;//청소완료
        }
        boolean existArroundZero = false;

        for (int i = 0; i < 4; i++) {
            int moveX = c + dx[i];
            int moveY = r + dy[i];
            if (isExistArroundZero(moveX, moveY)) {//주변에 청소하지 않은 칸이 있는가?
                existArroundZero = true;
                break;
            }
        }

        if (existArroundZero) {//주변에 청소하지 않은 칸이 있다면

            //반시계방향으로 방향을 회전
            direction = (direction+3)%4;

            //바라보는 방향을 기준으로 앞 쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
            if(isPossibleGo(r,c,direction)){
                /* 바라보는 방향 */
                //0 : 상
                //1 : 우
                //2 : 하
                //3 : 좌
                if(direction==0) moveRobot(r-1,c,direction);
                else if(direction==1) moveRobot(r,c+1,direction);
                else if(direction==2) moveRobot(r+1,c,direction);
                else if(direction==3) moveRobot(r,c-1,direction);
            }else{//전진할수없다면, 다시 방향을바꿔야겟지. 다시 호출.
                moveRobot(r,c,direction);
            }



        } else {//없다면
            //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            if (isPossibleBack(r, c, direction)) {

                if (direction == 0) moveRobot(r+1,c,direction);
                else if (direction == 1) moveRobot(r,c-1,direction);
                else if(direction==2) moveRobot(r-1,c,direction);
                else if(direction==3) moveRobot(r,c+1,direction);
            }else{//후진이 안되면 종료
                return;
            }
        }

    }

    private static boolean isPossibleGo(int r, int c, int direction) {
        if (direction == 0) return (r - 1) >= 0 && (r - 1) < n && c >= 0 && c < m && map[r-1][c]==0;
        else if (direction == 1) return r >= 0 && r < n && (c + 1) >= 0 && (c + 1) < m&& map[r][c+1]==0;
        else if(direction==2) return (r+1)>=0 && (r+1)<n && c>=0 && c<m && map[r+1][c]==0;
        else if(direction==3) return r>=0 && r<n && (c-1)>=0 && (c-1)<m && map[r][c-1]==0;

        else return false;
    }

    private static boolean isPossibleBack(int r, int c, int direction) {
        /* 바라보는 방향 */
        //0 : 상
        //1 : 우
        //2 : 하
        //3 : 좌
        if (direction == 0) return (r + 1) >= 0 && (r + 1) < n && c >= 0 && c < m && map[r+1][c]!=1;
        else if (direction == 1) return r >= 0 && r < n && (c - 1) >= 0 && (c - 1) < m&& map[r][c-1]!=1;
        else if(direction==2) return (r-1)>=0 && (r-1)<n && c>=0 && c<m && map[r-1][c]!=1;
        else if(direction==3) return r>=0 && r<n && (c+1)>=0 && (c+1)<m && map[r][c+1]!=1;

        else return false;
    }

    private static boolean isExistArroundZero(int moveX, int moveY) {

        return moveX >= 0 && moveX < m && moveY >= 0 && moveY < n && map[moveY][moveX] == 0;
    }


}
