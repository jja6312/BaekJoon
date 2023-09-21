import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String []args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void read() throws IOException{
        long N = Integer.parseInt(br.readLine());
        long F = Integer.parseInt(br.readLine());
        
        long M = (N / 100) * 100; // N의 뒷자리를 0으로 만든다.
        long result = M;
        
        for(int i = 0; i < 100; i++) { // 0부터 99까지 시도
            if((result + i) % F == 0) { // 나누어 떨어지는 경우 찾음
                result = i;
                break;
            }
        }
        
        if(result < 10) {
            bw.write("0" + result);
        } else {
            bw.write(String.valueOf(result));
        }
    }
}
