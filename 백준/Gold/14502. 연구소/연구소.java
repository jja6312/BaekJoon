import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int map[][];
    static int n;
    static int m;
    static int maxCnt;



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        // map 초기화
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //6중 for문을 통해 벽 3개를 세운다.
        for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               //첫 번째 벽
               if(map[i][j]!=0) continue;
               for(int y2=0; y2<n; y2++){
                   for(int x2=0; x2<m; x2++){
                       //두 번째 벽
                       if(map[y2][x2]!=0 || i==y2 && j==x2) continue;//첫 번째 벽과 두 번째 벽의 좌표가 같으면 넘어가라
                       for(int y3=0; y3<n; y3++){
                           for(int x3=0; x3<m; x3++){
                               //세 번째 벽
                               if(map[y3][x3]!=0 || (i==y3 && j==x3) || (y2==y3 && x2==x3)) continue; //첫,두번째 벽과 세번째벽의 좌표가 같으면 넘어가라.
                               //첫번째,두번째,세번째 벽이 셋 다 0(빈 공간)이라면
                               //맵을 가상맵에 복제해서
                               int[][] virtualMap = new int[n][m];
                               for(int vmY=0; vmY<n; vmY++){
                                   for(int vmX=0; vmX<m; vmX++){
                                       virtualMap[vmY][vmX] = map[vmY][vmX];
                                   }
                               }

                               //가상맵에 벽을 설치한다.
                               virtualMap[i][j] = 1;
                               virtualMap[y2][x2] = 1;
                               virtualMap[y3][x3] = 1;

                               boolean[][] visited = new boolean[n][m];
                               //바이러스 전염
                               for(int vmY=0; vmY<n; vmY++){
                                   for(int vmX=0; vmX<m; vmX++){
                                       //가상맵을 순회하며 2를 찾고, 2라면 바이러스를 전이시킨다.
                                       if(virtualMap[vmY][vmX] == 2 && !visited[vmY][vmX]){//방문하지 않았을때만
                                           dfs(vmY,vmX,virtualMap, visited);
                                       }
                                   }
                               }


                               //virtualMap의 남은 0의 개수를 센다.(최대값 산출)
                               int cnt = cntZero(virtualMap);
                               maxCnt = Math.max(maxCnt, cnt);//최대값을 저장


                           }
                       }
                   }

               }
           }
        }
        bw.write(maxCnt+"");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int cntZero(int[][] virtualMap) {
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(virtualMap[i][j]==0) cnt++; //0의 개수 세기
            }
        }

        return cnt;
    }

    private static void dfs(int vmY, int vmX, int[][] virtualMap, boolean[][] visited) {
        if(visited[vmY][vmX]) return;//방문했으면 종료
        visited[vmY][vmX] = true;//현재 위치를 방문처리

        //움직일수있는곳으로 바이러스 전파
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,-1,1};
        for(int i=0; i<4; i++){
            int moveY = dy[i] + vmY;
            int moveX = dx[i] + vmX;
            if(validBoundary(moveY,moveX,virtualMap)){//이동 좌표가 유효하면

                virtualMap[moveY][moveX] = 2;//2로 상태를 변이시키고
                dfs(moveY,moveX,virtualMap,visited);//거기서부터 또다시 전염시작

            }
        }
    }

    private static boolean validBoundary(int moveY, int moveX, int[][] virtualMap) {
        //이동한 좌표가 0이어야만 바이러스를 전이할 수 있음.
        return moveY>=0 && moveY<n && moveX>=0 && moveX<m && virtualMap[moveY][moveX]==0;
    }


}
