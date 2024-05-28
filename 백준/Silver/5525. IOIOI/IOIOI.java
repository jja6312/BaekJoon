import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n  = Integer.parseInt(br.readLine());
        int m  = Integer.parseInt(br.readLine());
        String S = br.readLine();
        

        int cnt=0;
        int patternCnt = 0;
        for(int i=0; i<m-2; i++){
            if(S.charAt(i)=='I' && S.charAt(i+1)=='O' && S.charAt(i+2)=='I'){
                cnt++;
                if(cnt==n){
                    patternCnt++;
                    cnt--;
                }
                i++;//다음위치로 이동
            }else{
                cnt = 0;
            }

        }




        bw.write(patternCnt+"");


        bw.flush();
        bw.close();
        br.close();


    }//main


}//Main
