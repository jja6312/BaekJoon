

import java.io.*;

public class Solution {
    static int n;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        for(int test=1; test<=t; test++){
            sb.append("#").append(test).append("\n");

            n = Integer.parseInt(br.readLine());
            arr= new int[n][n];
            visited = new boolean[n][n];
            visited[0][0] = true; //시작위치 방문처리
            arr[0][0] = 1; //시작 넘버는 1

            goByEnd(0,0,1,"오른쪽");//goByEnd(y인덱스,x인덱스,시작숫자,방향)

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void goByEnd(int y, int x, int num, String direction) {
        if(isAllVisit()) return; //모든 배열의 위치를 방문했다면 메서드종료

        //가장 최근 좌표를 확인하는 좌표.
        //왜냐하면, while 내부의 조건문을 통과하지 못하는 시점에 y,x의 값은 이미 배열범위를 벗어났기때문에 가장 마지막 유효했던 좌표를 저장해두어야한다.
        int lastY=y;
        int lastX=x;

        while(true){//방향의 끝까지 간다.
            //방향에 따라, 경계값을 벗어났는지 확인하고, 방문하지않았다면 조건문 로직 수행
            if(direction.equals("위") && isBoundary(y-1, x) && !visited[y-1][x]){
                //유효했던 좌표를 저장
                lastY = --y;
                lastX = x;
                arr[lastY][lastX] = ++num;
            }else if(direction.equals("오른쪽") && isBoundary(y, x+1) && !visited[y][x+1]){//중략...
                lastY = y;
                lastX = ++x;
                arr[lastY][lastX] = ++num;
            }else if(direction.equals("아래") && isBoundary(y+1, x) && !visited[y+1][x]){
                lastY = ++y;
                lastX = x;
                arr[lastY][lastX] = ++num;
            }else if(direction.equals("왼쪽") && isBoundary(y, x-1)&& !visited[y][x-1]){
                lastY = y;
                lastX = --x;
                arr[lastY][lastX] = ++num;
            }else{//범위를 벗어난다면
                break;
            }
            visited[lastY][lastX] = true;
        }

        if(direction.equals("위")){//소용돌이처럼!
            goByEnd(lastY,lastX,num,"오른쪽");//재귀호출
        }else if(direction.equals("오른쪽")){
            goByEnd(lastY,lastX,num,"아래");
        }else if(direction.equals("왼쪽")){
            goByEnd(lastY,lastX,num,"위");
        }else if(direction.equals("아래")){
            goByEnd(lastY,lastX,num,"왼쪽");
        }
    }

    private static boolean isAllVisit() {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) return false; //단 하나라도 방문하지 않은 배열이 있다면, false반환
            }
        }

        return true;
    }

    private static boolean isBoundary(int y, int x) {
        return y>=0 && y<n && x>=0 && x<n;
    }

}
