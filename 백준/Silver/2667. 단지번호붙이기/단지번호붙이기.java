import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][]map;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int cnt;
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            String A = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(A.charAt(j)));
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cnt = 0;
                if(map[i][j]==1){
                    dfs(i,j);
                    list.add(cnt);
                }

            }
        }

        Collections.sort(list);
        bw.write(list.size()+"\n");
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x) {
        //현재 위치를 -1로 바꾼다.
        map[y][x] = -1;
        cnt++;

        for(int i=0; i<4; i++){
            int moveX = dx[i]+x;
            int moveY = dy[i]+y;
            if(isValidBoundary(moveY,moveX) && map[moveY][moveX]==1){//이동할수있는곳이라면
                dfs(moveY,moveX);
            }
        }

    }//dfs

    private static boolean isValidBoundary(int moveY, int moveX) {

        return moveY>=0 && moveY<n && moveX>=0 && moveX<n;
    }

}
