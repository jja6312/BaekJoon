import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static char[][] arr;
    static char[][] arr2;
    static int commonCnt;
    static int commonCnt2;

    //이동할 수 있는 좌표
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        arr2 = new char[n][n];

        //초기화
        for (int i = 0; i < n; i++) {
            String A = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = A.charAt(j);
                arr2[i][j] = A.charAt(j)=='G' ? 'R' : A.charAt(j); //G면 R로저장하고, 그게아니면 그대로저장.
            }
        }

        //적록색맹이 '아닌'경우, 모든 영역을 카운팅.
        countCnt();
        bw.write(commonCnt+" ");


        commonCnt=0;//commonCnt 초기화
        arr = arr2;//적녹색맹으로 다시!
        countCnt();
        bw.write(""+commonCnt);

        bw.flush();
        bw.close();
        br.close();

    }

    private static void countCnt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'X') continue;
                else{
                    commonCnt++;
                    commonDfs(i, j, arr[i][j]);
                }//else
            }//for-2
        }//for-1
    }

    private static void commonDfs(int y, int x, int initialChar) {
        if(arr[y][x]=='X') return;
        if(arr[y][x]!=initialChar) return; //처음들어온 문자와 현재위치의 문자가 같지 않다면 return

        arr[y][x] = 'X';

        for (int i = 0; i < 4; i++) {
            int moveY = dy[i] + y;
            int moveX = dx[i] + x;
            if (!isValidPosition(moveY, moveX)) continue;//유효하지 않으면 넘어간다.
            //유효하다면 재귀호출
            commonDfs(moveY,moveX, initialChar); //처음들어온문자를 움직일 좌표와 계속해서 비교

        }
    }

    private static boolean isValidPosition(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < n) return true;
        else return false;
    }


}//Main Class
