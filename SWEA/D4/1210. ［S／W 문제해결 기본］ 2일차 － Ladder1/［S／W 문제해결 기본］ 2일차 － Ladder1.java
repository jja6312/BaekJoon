
import java.io.*;
import java.util.StringTokenizer;


// 사다리타기 게임!
// ============ 문제 사고 과정 ============
// 1. 배열의 첫 번째 줄을 탐색하고, 1이라면 goDown()을 통해 아래로 내려간다.
// 2. goDown() 함수는 현재 좌표에서 좌,우를 살피고 1인 것이 있다면 goLeftOrRight()을 호출한다.
// 3. goLeftOrRight를 수행하면서, 아래에 1이 있다면 goDown()을 수행한다.
// 4. x를 찾았다면 좌표를 전역변수에 저장시키고 goDown, goLeftOrRight()를 모두 종료시킨다.
// 5. 만약 끝점에 도달했는데 x를 못찾았다면 해당 goDown()을 종료시킨다.
public class Solution {
    static int answer;
    static int[][] arr = new int[100][100];
    static boolean allStop;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int test=1; test<=10; test++){
            br.readLine(); // 테스트번호는 사실상 무의미하기때문에 저장하지 않겠음.
            sb.append("#").append(test).append(" ");

            //
            answer = 0;
            allStop = false;
            //배열초기화
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //1. 첫번째줄 탐색 및 goDown()수행
            for(int i=0; i<100; i++){
                if(allStop) break;//정답을찾았다면 더이상 수행 X

                if(arr[0][i]==1) goDown(0,i,i);
            }
            sb.append(answer).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void goDown(int y, int x, int start) {
        if(allStop) return;//결과를 찾았다면 모든함수종료

        if(y==99){ // 가장 아래에 도달했다면
            if(arr[y][x]==2){ // 결과인지 확인
                allStop = true; //결과라면 모든함수종료 boolean 활성화
                answer = start;
            }
            return;//현재 함수 종료
        }

        //2. 좌,우,아래에 대한 위치 유효성검사 및 이동로직
        if(isBoundary(y,x-1) && arr[y][x-1]!=0){//왼쪽이 0이 아니면 왼쪽으로간다.
            goLeftOrRight(y,x-1, "왼쪽",start);
        }else if(isBoundary(y,x+1)  && arr[y][x+1]!=0){// 오른쪽에 0이 아니면 오른쪽으로 간다.
            goLeftOrRight(y,x+1,"오른쪽",start);
        }else if(isBoundary(y+1,x) && arr[y+1][x]!=0){//좌,우가 1이아니고 아래가 0이 아니면 아래로간다.
            goDown(y+1,x,start);
        }
    }

    //좌,우로 이동하는 함수
    private static void goLeftOrRight(int y, int x,String direction, int start) {
        if(allStop) return;//결과를 찾았다면 모든함수종료

        //3. 아래가 갈 수 있는 범위이고, 0이 아니면 goDown()을 수행한다.
        if(isBoundary(y+1,x) && arr[y+1][x]!=0){
            goDown(y+1,x,start);
        }//아래로 이동못한다면 한 방향으로 계속 이동
        else if(direction.equals("왼쪽") && isBoundary(y,x-1)){
            goLeftOrRight(y,x-1,"왼쪽",start);
        }else if(direction.equals("오른쪽") && isBoundary(y,x+1)){
            goLeftOrRight(y,x+1,"오른쪽",start);
        }

    }

    // 배열 좌표 유효성 검사
    private static boolean isBoundary(int y, int x) {
        return y>=0 && y<100 && x>=0 && x<100;
    }
}
