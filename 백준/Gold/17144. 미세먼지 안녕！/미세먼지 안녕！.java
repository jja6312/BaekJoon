import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

import static java.nio.file.Files.move;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int r;
    static int c;
    static int t;
    static int airPos1;
    static int airPos2;
    static int[] up = {1, -1, 0, 0}, side = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        // 입력값 초기화
        initMap();

        // 공기청정기 위치를 찾아 airPos1, airPos2에 넣는다.
        findAir();

        for(int i=0; i<t; i++){//시간만큼 확산시킨다.
            solve();
        }
        int result = count()+2;// 공기청정기의 값인 -1을 2번 더했으므로 2를 다시 더해준다.
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

    private static int count() {
        int tmp = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                tmp += map[i][j];
            }
        }
        return tmp;
    }

    private static void solve() {
        map = dustSimulation(); // 먼지가 퍼져나가는 것을 구하는 함수
        airSimulation(); //공기청정기로 먼지가 들어오며 나가는 것을 구하는 함수
    }

    private static void airSimulation() {
        int top = airPos1; //공기청정기 윗 부분좌표이며, 반시계 방향으로 진행

        for(int x = top-1; x>0; x--){
            map[x][0] = map[x-1][0];
        }
        for(int y=0; y<c-1; y++){
            map[0][y] = map[0][y+1];
        }
        for(int x=0; x<top; x++){
            map[x][c-1] = map[x+1][c-1];
        }
        for(int y=c-1; y>1; y--){
            map[top][y] = map[top][y-1];
        }

        map[top][1] = 0; //공기청정기로 나가는 곳이므로 먼지는 0이다.

        int bottom = airPos2; //공기청정기 밑 부분좌표이며, 시계방향으로 진행
        for (int x = bottom + 1; x < r - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            map[r - 1][y] = map[r - 1][y + 1];
        }

        for (int x = r - 1; x > bottom; x--) {
            map[x][c - 1] = map[x - 1][c - 1];
        }

        for (int y = c - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y - 1];
        }

        map[bottom][1] = 0; //공기청정기로 나가는 곳이므로 먼지는 0이다.
    }

    private static int[][] dustSimulation() {
        int[][] tMap = new int[50][50];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] ==-1){
                    tMap[i][j] = -1;
                    continue;
                }
                tMap[i][j] += map[i][j];
                for(int k=0; k<4; k++){
                    int nx = j+side[k];
                    int ny = i+up[k];

                    if(ny<0 || ny>=r || nx<0 || nx>=c) continue;
                    if(map[ny][nx]==-1) continue;

                    tMap[ny][nx] += map[i][j]/5;
                    tMap[i][j] -= map[i][j]/5;
                }
            }
        }
        return tMap;
    }

    private static void findAir() {
        for(int i=0; i<r; i++){
            if(map[i][0] == -1){
                airPos1 = i;
                airPos2 = i+1;
                return;
            }
        }
    }

    private static void initMap() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }




}//Main Class
