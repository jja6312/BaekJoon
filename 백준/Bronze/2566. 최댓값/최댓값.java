import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Integer[][] arr = new Integer[9][9];
        
        //배열생성
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //두번째 배열생성. 각 열의 최대값maxI, maxJ를 배열의 요소마다 넣어놓고 순회 할 예정.
       // Integer []arr2 = new Integer[9];
        
        //
        int maxI=0;
        int maxJ=0;
        int maxX=arr[0][0];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j] >= maxX){
                    maxI = i;
                    maxJ = j;
                    maxX = arr[i][j];
                }//if
            }//for2
        }
        bw.write(""+maxX+"\n");
        bw.write(""+(maxI+1)+" "+(maxJ+1));
        bw.flush();
        bw.close();
        br.close();
    }//main()
}//Main
    
    