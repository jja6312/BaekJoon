import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static int bugCnt;



    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){

            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];

            for(int j=0; j<k; j++){//arr 초기화
                st = new StringTokenizer(br.readLine(), " ");
                int lt = Integer.parseInt(st.nextToken());
                int rt = Integer.parseInt(st.nextToken());
                arr[lt][rt] = 1;
            }

            bugCnt = 0;
            for(int j=0; j<m; j++){
                for(int l=0; l<n; l++){
                    if(arr[j][l]==0 || arr[j][l]==-1) continue;
                    else {
                        bugCnt++;
                        dfs(j,l,m,n);

                    }

                }//for - l
            }//for - j
          bw.write(bugCnt+"\n");

        }//for - t



        bw.flush();
        bw.close();
        br.close();
    }//main

    private static void dfs(int y, int x, int m, int n) {
        if(arr[y][x] == 0 || arr[y][x] == -1) return;

        //현재 위치를 벌레가 갉아먹게해라.
        arr[y][x] = -1;

        //상하좌우로 이동하며 1을 갉아먹는다.
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for(int i=0; i<4; i++){
            int mx = dx[i] + x;
            int my = dy[i] + y;
            //유효한 값이라면 dfs로 벌레를 전염시켜라.
            if(mx>=0 && mx<n && my>=0 && my<m){
                dfs(my,mx,m,n);
            }//if
        }//for

    }//dfs()

}//Main Class
