import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt;
    static int w;
    static int h;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;
            int[][] arr = new int[h][w];
            cnt = 0;

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(arr[i][j]==1) {
                        dfs(i,j,arr);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static void dfs(int y, int x, int[][] arr) {

        arr[y][x] = -1;
        for(int i=0; i<8; i++){
            int moveX = dx[i]+x;
            int moveY = dy[i]+y;
            if(isValidBoundary(moveX,moveY,arr)){// 이동이 가능하다면
                dfs(moveY,moveX,arr);
            }
        }

    }

    private static boolean isValidBoundary(int moveX, int moveY,int[][] arr) {
        return moveX>=0 && moveX<w && moveY>=0 && moveY<h && arr[moveY][moveX]==1;
    }

}//Main Class
