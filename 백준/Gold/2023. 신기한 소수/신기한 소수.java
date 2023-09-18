import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[]args) throws IOException{
        read();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
        bw.flush();
        bw.close();
        br.close();
        
    }//main()

    public static void read() throws IOException{
        N = Integer.parseInt(br.readLine());
        /*
        
        DFS로 처리.
        
        N자리 소수판별
        0. N이주어지면, 10^N<= XXX <10^N+1 까지의 소수를 판별하는 메서드 필요.
        1.소수판별하는 메서드필요
        2. 오름차순으로 정렬해서 모두출력
        
        
        */
    }//read()
    
    public static void DFS(int number, int jarisu)throws IOException{
        if( jarisu == N ){
            if(sosu(number)){
                bw.write(number+"\n");
            }//if2
            return;
        }//if1
        for(int i=1; i<10; i++){
            if(i%2 == 0){
                continue;
            }//if
            if(sosu(number*10+i)){
                DFS(number*10+i, jarisu + 1);
            }
        }
    }//DFS
    
    
    public static boolean sosu(int n){
        if(n<=1) return false;
        
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}//Main