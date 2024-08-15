

import java.io.*;
import java.util.StringTokenizer;

// =============== 문제 접근 ===============
// 가로 세로 수를 의미하는 n = 5 이기때문에,
// 주어진 제한 시간 1초동안 수행하기에 다소 복잡한 시간복잡도로도 충분하다.
// 예를 들어, 4중 for문인 O(n^4) 또한 가능할 것으로 보인다.
// 따라서, 지워야할 숫자가 주어진다면 2중 for문으로 배열을 순회하는 것은 충분히 가능한 시나리오다.

// 1. 배열 초기화
// 2. 사회자가 부르는 숫자를 지워나가기. ( 지운 숫자는 0으로 표현 )
// 3. 숫자를 지우고, 현재 위치에서 가능한 빙고 확인하기
// 4. 빙고가 가능하다면 빙고 total개수를 늘린다.
// 5. 빙고 total == 3이 될 때까지 cnt를 센다. total==3이라면 cnt를 출력한다.

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n = 5;
    static int[][] arr = new int[n][n];
    static int total;
    static int cnt;
    static boolean[][] visited가로 = new boolean[n][n];
    static boolean[][] visited세로 = new boolean[n][n];
    static boolean[][] visited좌상우하 = new boolean[n][n];
    static boolean[][] visited우상좌하 = new boolean[n][n];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // 1. 배열 초기화
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2. 사회자가 부르는 숫자를 지워나가기. ( 지운 숫자는 0으로 표현 )
        boolean allStop = false;
        for(int i=0; i<n; i++){
            if(allStop) break;
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                if(allStop) break;
                int num = Integer.parseInt(st.nextToken());
                // 3. 숫자를 지우고, 현재 위치에서 가능한 빙고 확인하기
                int[] deleteIdx = deleteNum(num);
                cnt++;
                isPossibleBingo(deleteIdx[0],deleteIdx[1]); // 4. 빙고가능하면 total늘리기.

                // 5. 빙고 total >= 3이 될 때까지 cnt를 센다. total==3이라면 cnt를 출력한다.
                if(total>=3){
                    sb.append(cnt);
                    allStop = true;
                }

            }
        }




        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void isPossibleBingo(int y, int x) {
        //한 번 체크한 항목에 대해서는 다시체크해선 안된다.

        //가로 체크
        boolean isTrue가로 = true;
        int zeroCnt = 0;
        if(!visited가로[y][x]){
            for(int i=0; i<n; i++){
                if(arr[y][i] != 0){
                    isTrue가로 = false;
                    break;
                }else{
                    zeroCnt++;
                }
            }
        }
        if(zeroCnt != 5) isTrue가로 = false;

        if(isTrue가로) {
            //현재 가로를 방문처리.
            for(int i=0; i<n; i++){
                visited가로[y][i] = true;
            }
            total++;
        }


        //세로 체크
        boolean isTrue세로 = true;
        zeroCnt = 0;
        if(!visited세로[y][x]){
            for(int i=0; i<n; i++){
                if(arr[i][x] != 0){
                    isTrue세로 = false;
                    break;
                }else{
                    zeroCnt++;
                }
            }
        }
        if(zeroCnt != 5) isTrue세로 = false;
        if(isTrue세로) {
            //현재 세로를 방문처리.
            for(int i=0; i<n; i++){
                visited세로[i][x] = true;
            }
            total++;
        }

        //좌상우하 대각 체크
        boolean isTrue좌상우하 = true;
        zeroCnt = 0;
        if(!visited좌상우하[y][x]){
            //좌상
            int moveY = y;
            int moveX = x;
            while(isBoundary(moveY,moveX)){
                if(arr[moveY][moveX]!=0){
                    isTrue좌상우하 = false;
                    break;
                }else{
                    zeroCnt++;
                }
                moveY--;
                moveX--;
            }

            //우하
            moveY = y;
            moveX = x;
            while(isBoundary(moveY,moveX)){
                if(arr[moveY][moveX]!=0){
                    isTrue좌상우하 = false;
                    break;
                }else{
                    zeroCnt++;
                }
                moveY++;
                moveX++;
            }

            zeroCnt-=1; //중복으로더해진부분 제거
            if(zeroCnt!=5) isTrue좌상우하 = false;

            if(isTrue좌상우하) {
                //현재 좌상우하를 방문처리.
                //좌상
                moveY = y;
                moveX = x;
                while(isBoundary(moveY,moveX)){
                    visited좌상우하[moveY][moveX] = true;
                    moveY--;
                    moveX--;
                }

                //우하
                moveY = y;
                moveX = x;
                while(isBoundary(moveY,moveX)){
                    visited좌상우하[moveY][moveX] = true;
                    moveY++;
                    moveX++;
                }
                total++;
            }//좌상우하가 빙고라면 total++
        }//좌상우하 대각체크

        //우상좌하 대각 체크
        boolean isTrue우상좌하 = true;
        zeroCnt = 0;
        if(!visited우상좌하[y][x]){
            //우상
            int moveY = y;
            int moveX = x;
            while(isBoundary(moveY,moveX)){
                if(arr[moveY][moveX]!=0){
                    isTrue우상좌하 = false;
                    break;
                }else{
                    zeroCnt++;
                }
                moveY--;
                moveX++;
            }

            //좌하
            moveY = y;
            moveX = x;
            while(isBoundary(moveY,moveX)){
                if(arr[moveY][moveX]!=0){
                    isTrue우상좌하 = false;
                    break;
                }else{
                    zeroCnt++;
                }
                moveY++;
                moveX--;
            }
            zeroCnt-=1; //중복으로더해진부분 제거

            if(zeroCnt!=5) isTrue우상좌하 = false;
            if(isTrue우상좌하) {
                //현재 우상좌하를 방문처리.
                //좌상
                moveY = y;
                moveX = x;
                while(isBoundary(moveY,moveX)){
                    visited우상좌하[moveY][moveX] = true;
                    moveY--;
                    moveX++;
                }

                //우하
                moveY = y;
                moveX = x;
                while(isBoundary(moveY,moveX)){
                    visited우상좌하[moveY][moveX] = true;
                    moveY++;
                    moveX--;
                }
                total++;
            }
        }


    }

    private static boolean isBoundary(int y, int x) {
        return y>=0 && y<n && x>=0 && x<n;
    }

    private static int[] deleteNum(int num) {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(arr[i][j]==num) {
                    arr[i][j] = 0;
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

}
