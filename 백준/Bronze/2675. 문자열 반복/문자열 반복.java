import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.valueOf(br.readLine());
        
        StringTokenizer st;
        
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.valueOf(st.nextToken());
            String S = st.nextToken();
            for(int j=0; j<S.length(); j++){
                char s = S.charAt(j);
                String sPlus="";
                for(int x=0; x<R; x++){
                    sPlus+=Character.toString(s);
                }//for3, 한 글자(s)를 R번 반복해서 sPlus에 추가.
                bw.write(sPlus);
            }//for2, 문자열(S) 중 한 글자(s)씩 순서대로 선택.
            bw.write("\n");
        }//for1, 작업을 T번 반복해야한다.
        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main class