import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        char []arr = new char[A.length()];
        
        //----문자열을 배열로 초기화
        for(int i=0; i<A.length(); i++){
            arr[i]= A.charAt(i);
        }//for
        
        
        int result=1;
        for(int i=0; i<(A.length()/2); i++){
            if (arr[i]!=arr[A.length()-1-i]){
                result=0;
            }
        }
        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main class