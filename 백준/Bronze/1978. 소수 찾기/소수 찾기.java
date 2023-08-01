import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String list = br.readLine();
        int N = Integer.valueOf(list);
        boolean bSwitch = false;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt=0;
        for(int i=0; i<N;i++){
            int a = Integer.valueOf(st.nextToken());
            if(a == 1) {
                continue;
            }
            if(a == 2) {
                cnt++;
                continue;
            }
            bSwitch = true;
            for(int j=2; j<a; j++){
                if(a%j==0) {
                    bSwitch=false;
                    break;
                }
                if(j==a-1 && bSwitch){
                    cnt++;
                }
            }//for2
        }//for1
        bw.write(""+cnt);
        bw.flush();
        bw.close();
        br.close();
    
    }
}
