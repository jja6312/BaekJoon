import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long N = Long.valueOf(br.readLine());
        
        //i가 한칸씩 갈때마다, 2^(i-1)만큼 지수의 밑을 더해주자.
        long x = 2;
        for(int i=1; i<=N; i++){
            x = 2*x-1;    
        }
        
        bw.write(""+x*x);
        bw.flush();
        bw.close();
        br.close();
           
    }
}


/*
무슨로직일까?

0 : 2^2  
1 : 3^2 
2 : 5^2 
3 : 10^2 
4 : 20^2 

인 것 같은데...

*/