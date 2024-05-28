import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n  = Integer.parseInt(br.readLine());
        int m  = Integer.parseInt(br.readLine());
        String S = br.readLine();
        String p = "";

        StringBuilder sb = new StringBuilder();
        sb.append("IOI");
        if(n!=1){
            for(int i=1; i<n; i++){
                sb.append("OI");
            }
        }
        p = sb.toString();

        //만약 p가 S에 포함되어 있다면
        //S = p의 시작위치 +2, 문자열끝까지 subString

        int cnt=0;
        while(S.indexOf(p)!=-1){
            int idx = S.indexOf(p);
            S = S.substring(idx+2,S.length());
            cnt++;
        }
        bw.write(cnt+"");


        bw.flush();
        bw.close();
        br.close();


    }//main


}//Main
