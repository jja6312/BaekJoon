

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int[] rectangle = new int[10];
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t ++) {
            sb.append("#").append(t).append(" ");

            //arr초기화
            int[][] arr = new int[9][9];
            for(int i=0; i<9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean isGood = true;
            for(int i=0; i<9; i++){
                if(!isGood) break;
                for(int j=0; j<9; j++){
                    if(!isGood) break;
                    //현재 좌표에 대해,
                    // 1. 열을 탐색하며 9까지 온전한지 확인한다.
                    // 2. 행을 탐색하며 9까지 온전한지 확인한다.
                    // 3. 현재 사각형에 9까지 온전한지 확인한다.
                    boolean rowInspect = inspectRow(i,j,arr);
                    boolean colInspect = inspectCol(i,j,arr);

                    int currentRectangle = setCurrentRectangle(i,j,arr);
                    if(rectangle[currentRectangle] == 0){ // 0이 아니면 검사할 필요 없음.(검사통과)
                        boolean recInspect = inspectRectangle(i,j,arr,currentRectangle);
                        if(!recInspect){ // 검사가 실패했다면
                            isGood = false;//모든 탐색을 멈춘다.
                            break;
                        }
                    }

                    if(!rowInspect || !colInspect){//행열검사가 실패했다면 탐색중지
                        isGood = false;
                        break;
                    }

                }//for - 2
            }//for - 1

            if(isGood) sb.append("1").append("\n");
            else sb.append("0").append("\n");

        }//for - test

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static int setCurrentRectangle(int y, int x, int[][]arr){
        //rectangle 검사를 위해, 나만의 규칙 설정
        //rectangle[i]가 0이라면, 아직 초기화 되지 않은 것.
        //rectangle[i]가 1이라면, 초기화 되었고 검사 성공한 것.
        //rectangle[i]가 -1이라면, 초기화 되었지만 검사에 실패한 것.

        //현재 x,y 위치에 따라 1~9 rectangle인지 파악한다.
        int currentRectangle = 0;
        if(x>=0 && x<=2){//가장 왼쪽 사각형들
            if(y>=0 && y<=2){
                currentRectangle = 1;
            }else if(y>=3 && y<=5){
                currentRectangle = 4;
            }else if(y>=6 && y<=8){
                currentRectangle = 7;
            }
        }else if(x>=3 && x<=5){//중간 사각형들
            if(y>=0 && y<=2){
                currentRectangle = 2;
            }else if(y>=3 && y<=5){
                currentRectangle = 5;
            }else if(y>=6 && y<=8){
                currentRectangle = 8;
            }
        }else if(x>=6 && x<=8){//오른쪽 사각형들
            if(y>=0 && y<=2){
                currentRectangle = 3;
            }else if(y>=3 && y<=5){
                currentRectangle = 6;
            }else if(y>=6 && y<=8){
                currentRectangle = 9;
            }
        }
        return currentRectangle;
    }

    private static boolean inspectRectangle(int y, int x, int[][] arr, int currentRectangle) {
        int[]num = new int[10];
        if(currentRectangle == 1){
            for(int i=0; i<=2; i++){
                for(int j=0; j<=2; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 2){
            for(int i=0; i<=2; i++){
                for(int j=3; j<=5; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 3){
            for(int i=0; i<=2; i++){
                for(int j=6; j<=8; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 4){
            for(int i=3; i<=5; i++){
                for(int j=0; j<=2; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 5){
            for(int i=3; i<=5; i++){
                for(int j=3; j<=5; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 6){
            for(int i=3; i<=5; i++){
                for(int j=6; j<=8; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 7){
            for(int i=6; i<=8; i++){
                for(int j=0; j<=2; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 8){
            for(int i=6; i<=8; i++){
                for(int j=3; j<=5; j++){
                    num[arr[i][j]]++;
                }
            }
        }else if(currentRectangle == 9){
            for(int i=6; i<=8; i++){
                for(int j=6; j<=8; j++){
                    num[arr[i][j]]++;
                }
            }
        }

        if(isAllNumOne(num)) return true;

        return false;
    }

    private static boolean inspectCol(int y, int x, int[][] arr) {

        int[] num = new int[10];
        for(int i=0; i<9; i++){
            num[arr[y][i]]++;
        }
        if(isAllNumOne(num)) return true; //모든 숫자가 1개씩 있다면 검사결과 true

        return false;
    }

    private static boolean inspectRow(int y, int x, int[][] arr) {
        int[] num = new int[10];
        for(int i=0; i<9; i++){
            num[arr[i][x]]++;
        }
        if(isAllNumOne(num)) return true; //모든 숫자가 1개씩 있다면 검사결과 true


        return false;
    }

    private static boolean isAllNumOne(int[] num) {
        for(int i=1; i<=9; i++){
            if(num[i]!=1) return false; //하나라도 1개가 아닌 숫자가있으면 검사 false
        }
        return true;
    }


}
