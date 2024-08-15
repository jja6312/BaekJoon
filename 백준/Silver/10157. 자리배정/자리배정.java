

import java.io.*;
import java.util.StringTokenizer;

// ================ 문제 접근 ================
// 그냥 달팽이문제인데?
// 달팽이 만들어놓고 숫자를 찾으면될듯?

//순서:
//아래
//오른쪽
//위
//왼쪽
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static final String DOWN = "DOWN";
    static final String RIGHT = "RIGHT";
    static final String UP = "UP";
    static final String LEFT = "LEFT";
    static int num = 2;
    static int total;
    static int n,m;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        total = n*m; // num이 total이 되면 멈춘다.
        int goal = Integer.parseInt(br.readLine());

        arr = new int[m][n];
        goSnail(0,0,DOWN);

        //탐색
        boolean isFound = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(goal==arr[i][j]){
                    isFound = true;
                    sb.append(j+1).append(" ").append(i+1);
                }
            }
        }

        if(!isFound) sb.append("0");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void goSnail(int y, int x, String direction) {
        if(num > total) return;
        num--;

        String next = "";
        if(direction.equals(DOWN)){//아래방향으로
            while(true){//경계가 끝날때까지 혹은 0이 아닌 수를 만날때까지 간다.
                //현위치에 숫자 초기화.
                arr[y][x] = num++;

                //만약 아래가 갈 수 있다면
                if(isBoundary(y+1,x) && arr[y+1][x]==0){
                    y++; // 좌표를 이동한다.
                }else{//갈 수 없다면
                    next = RIGHT; //다음 방향을 설정하고
                    break;//반복문을 멈춘다.
                }
            }
        }else if(direction.equals(RIGHT)){
            while(true){//경계가 끝날때까지 혹은 0이 아닌 수를 만날때까지 간다.
                //현위치에 숫자 초기화.
                arr[y][x] = num++;

                //만약 오른쪽으로 갈 수 있다면
                if(isBoundary(y,x+1) && arr[y][x+1]==0){
                    x++; // 좌표를 이동한다.
                }else{//갈 수 없다면
                    next = UP; //다음 방향을 설정하고
                    break;//반복문을 멈춘다.
                }
            }
        }else if(direction.equals(UP)){
            while(true){//경계가 끝날때까지 혹은 0이 아닌 수를 만날때까지 간다.
                //현위치에 숫자 초기화.
                arr[y][x] = num++;

                //만약 위로 갈 수 있다면
                if(isBoundary(y-1,x) && arr[y-1][x]==0){
                    y--; // 좌표를 이동한다.
                }else{//갈 수 없다면
                    next = LEFT; //다음 방향을 설정하고
                    break;//반복문을 멈춘다.
                }
            }

        }else if(direction.equals(LEFT)){
            while(true){//경계가 끝날때까지 혹은 0이 아닌 수를 만날때까지 간다.
                //현위치에 숫자 초기화.
                arr[y][x] = num++;

                //만약 위로 갈 수 있다면
                if(isBoundary(y,x-1) && arr[y][x-1]==0){
                    x--; // 좌표를 이동한다.
                }else{//갈 수 없다면
                    next = DOWN; //다음 방향을 설정하고
                    break;//반복문을 멈춘다.
                }
            }

        }

        goSnail(y,x,next); // 재귀
    }

    private static boolean isBoundary(int y, int x) {
        return y>=0 && y<m  && x>=0 && x<n;
    }

}
