import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{

        
        //문제 : 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
        //조건 : 10진법을 넘어가는 진법은 아래와 같이 표현할 수 있다.
        //표현식 : A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

        // *****1. 제시된 첫 번째 줄을 읽어오고, 토큰을 변수 N(10진법 수)과 B(표현할 진법의 수)로 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long N = Integer.valueOf(st.nextToken());
        Integer B = Integer.valueOf(st.nextToken());
  
        ArrayList<Character> arrList = new ArrayList<Character>();
        while(N>0){
            int mod = (int)N%B;
            if(mod<10){
                arrList.add((char)(mod+'0'));
            }else{
                arrList.add((char)(mod-10+'A'));
            }
            
            N /= B;
        }//while
        for(int i=arrList.size()-1; i>=0; i--){
            bw.write(""+arrList.get(i));    
        }//for
        

        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main