import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        if(N<=99){
            bw.write(N+"");
            return;
        }else{
            //그냥 브루트 포스로 해결하자.
            int M = 100;
            int cnt = 99;
            while(M<=N){
                int a = M/100;
                int b = M/10 - a*10;
                int c = M-(M/10)*10;
                if(a-b == b-c){
                    cnt++;
                }
                M++;
            }
            bw.write(cnt+"");
            
            
            //int plus = plus(N);
            //int minus = minus(N);
            /*
            plus 등차수열을 계산하는 로직 필요
            1: 최대5
            2: 최대4
            111
            123
            135
            147
            159
            
            222
            234
            246
            258
            
            999
            */
            /*
            minus 등차수열을 계산하는 로직 필요
            1: 최대1
            2: 최대2
            111
            
            222
            210
            
            333
            321
            
            444
            432
            420
            
            999
            987
            975
            963
            951
            */
            
            
        }
        
    }//read()
    
  
}//Main