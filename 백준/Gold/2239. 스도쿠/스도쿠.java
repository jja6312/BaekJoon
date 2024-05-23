import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<int[]> list = new ArrayList<>();
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String A = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = A.charAt(j)-'0';
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(arr[i][j]==0) list.add(new int[]{i,j});

            }
        }

        bt(0);
        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static boolean bt(int depth) throws IOException{
        if(list.size()==depth){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    bw.write(arr[i][j]+"");
                }//for-2
                bw.write("\n");
            }//for-1
            return true;

            //최초로 조합된 경우를 출력시키고, 종료한다.
        }//if

        int x = list.get(depth)[0];
        int y = list.get(depth)[1];

        //이미 있는 숫자인지 체크할 배열
        boolean [] check = new boolean[10];

        //가로체크
        for(int i=0; i<9; i++){
            if(arr[x][i] !=0 ) check[arr[x][i]] = true;
        }

        //세로체크
        for(int i=0; i<9; i++){
            if(arr[i][y]!=0) check[arr[i][y]] = true;
        }

        //작은 상자 체크
        int firstX = (x/3) * 3;
        int firstY = (y/3) * 3;
        for(int i=firstX; i<firstX+3; i++){
            for(int j=firstY; j<firstY+3; j++){
                if(arr[i][j]!=0) check[arr[i][j]] = true;
            }
        }
        //넣을 수 있는 숫자를 넣는다.
        for(int i=1; i<=9; i++){
            if(!check[i]){
                arr[x][y] = i;
                if(bt(depth+1)){
                    return true;
                }
                arr[x][y] = 0;
            }
        }

        return false;
    }

}//Main Class
