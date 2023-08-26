/*
3 3
1 7 11
*/
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[]agrs) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
        
    }
    public static void read() throws IOException{
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine, " ");
        int N = Integer.parseInt(st.nextToken()); // 동생의 수
        int S = Integer.parseInt(st.nextToken()); // 본인의 위치
        
        String secondLine = br.readLine();
        st = new StringTokenizer(secondLine, " ");
        
        int[] arrA = new int[N]; // 동생 위치값을 저장하는 배열생성
        for(int i=0; i<N; i++){//본인위치-동생위치의 절대값을 배열에 초기화.
            arrA[i]=(int)Math.abs(S-Integer.parseInt(st.nextToken()));
        }
        //배열에서 최대공약수를 구하자.
        int result=arrA[0];
        for(int i=1; i<N; i++){
            result = gcd(result,arrA[i]);
        }//for1
        bw.write(result+"");
        
    }//read()
    
    public static int gcd(int a, int b){
        while(b>0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}//Main()