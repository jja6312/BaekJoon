import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int cnt;
    static int m;
    static char[][] map;
    static boolean[][] visitied;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};



    public static void main(String[] args) throws Exception {
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visitied = new boolean[n][m];
        int startY = -1;
        int startX = -1;
        for(int i=0; i<n; i++){
            String A = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = A.charAt(j);
                if(map[i][j]=='I'){
                    startY = i;
                    startX = j;
                }
            }
        }

        dfs(startY,startX);
        if(cnt==0){
            System.out.println("TT");
            return;
        }else{
            bw.write(cnt+"");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x) {
        //현위치를 다시방문x
        if(visitied[y][x]) return;
        visitied[y][x] = true;//현위치 방문처리.

        //현재 위치에 P가 있으면
        if(map[y][x]=='P'){
            cnt++;
        }

        for(int i=0; i<4; i++){
            int moveY = y+dy[i];
            int moveX = x+dx[i];
            if(validBoundary(moveY,moveX) && !visitied[moveY][moveX]){
                dfs(moveY,moveX);
            }
        }
    }

    private static boolean validBoundary(int moveY, int moveX) {
        return moveY>=0 && moveY<n && moveX>=0 && moveX<m && map[moveY][moveX]!='X';
    }

}
