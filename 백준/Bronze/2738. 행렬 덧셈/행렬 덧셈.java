import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        //M만큼 for문으로 배열생성
        //N줄만큼 반복
        
        Integer[][]arrSum = new Integer[N][M];
        
        //이제, arrSum은 N개의 방에 각각M개가들어갈수있는 배열이 있는것임.
        
        for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arrSum[i][j]=Integer.parseInt(st.nextToken());
            }
        }//for
        Integer[][]arrSum2 = new Integer[N][M];
        for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arrSum2[i][j]=Integer.parseInt(st.nextToken());
            }
        }//for
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arrSum[i][j] += arrSum2[i][j];
                bw.write(""+arrSum[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }//main()
}//Main class
