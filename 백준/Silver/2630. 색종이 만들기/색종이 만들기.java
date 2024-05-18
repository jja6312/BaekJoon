import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int white;//0
    static int blue;//1
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        //더이상 자를 수 없으면 카운트.

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        //입력값 초기화
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        inspectAllSame(arr);//현재 범위가 1 또는 0으로 획일화 되어 있는지.

        bw.write(white+"\n");
        bw.write(blue+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void inspectAllSame(int[][] currentArr) {
        int length = currentArr.length;
        int tmp= currentArr[0][0];

        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(tmp!=currentArr[i][j]){//획일화 되어 있지 않다면
                    //4사분면으로 잘라서 다시 계산
                    int[][] arr1 = splitArr(1,currentArr);
                    int[][] arr2 = splitArr(2,currentArr);
                    int[][] arr3 = splitArr(3,currentArr);
                    int[][] arr4 = splitArr(4,currentArr);
                    inspectAllSame(arr1);
                    inspectAllSame(arr2);
                    inspectAllSame(arr3);
                    inspectAllSame(arr4);
                    return;
                }
            }
        }

        //for문이 return되지 않았다면 모두 획일화된 숫자.
        //따라서, tmp의 값대로 결과를 결정한다.
        if(tmp==1) blue++;
        else white++;
    }

    private static int[][] splitArr(int range, int[][] currentArr) {

        //range는 사분면. 사분면 범위에 따라 arr할당.
        int length = currentArr.length;
        int halfLength = currentArr.length/2;
        int[][] splitArr = new int[halfLength][halfLength];

        if(range==1){//좌상단
            for(int i=0; i<halfLength; i++){
                for(int j=0; j<halfLength; j++){
                    splitArr[i][j] = currentArr[i][j];
                }
            }
        }else if(range==2){//우상단
            for(int i=0; i<halfLength; i++){
                for(int j=0; j<halfLength; j++){
                    splitArr[i][j] = currentArr[i+halfLength][j];
                }
            }
        }else if(range==3){
            for(int i=0; i<halfLength; i++){
                for(int j=0; j<halfLength; j++){
                    splitArr[i][j] = currentArr[i][j+halfLength];
                }
            }
        }else if(range==4){
            for(int i=0; i<halfLength; i++){
                for(int j=0; j<halfLength; j++){
                    splitArr[i][j] = currentArr[i+halfLength][j+halfLength];
                }
            }
        }

        return splitArr;
    }
}
