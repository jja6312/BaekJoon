import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String result="";
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            if(a==0 && b==0) break;
            if(a%b!=0 && b%a!=0){
                result="neither";
                bw.write(result+"\n");
                continue;
            }
            if(a%b==0){
                result="multiple";
                bw.write(result+"\n");
                continue;
            }
            if(b%a==0){
                result="factor";
                bw.write(result+"\n");
                continue;
            }
        }//while
        
        bw.flush();
        bw.close();
        br.close();
            
    }
}