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
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        //약수구하기
        //두자연수니까, 둘중에 큰녀석을 배열로 만들고
        //count 해서 2인 수를 찾자.
        int N;
        if(a>=b){
            N = a;  
        }else{
            N = b;
        }
        
        Integer [] arr = new Integer[N+1]; //i번째 방이 해당자연수를 가리킨다.
        for(int i=0; i<N+1; i++){//arr초기화
            arr[i]=0;
        }
        
        
        for(int i=2; i<=a; i++){
            if(a%i==0){
                arr[i]++;
            }
        }//for
        
        for(int i=2; i<=b; i++){
            if(b%i==0){
                arr[i]++;
            }
        }//for
        
        //2가 된 것 중 가장 큰 수가 최대공약수.
        
        int maxYaksoo =1;
        for(int i=N; i>=0; i--){
            if(arr[i]==2){
                maxYaksoo=i;
                break;
            }//if
        }//for
        
        int minBaesoo = 1;
        //최소공배수는 두수의곱을 최대공약수로 나눈 것.
        minBaesoo  = a*b/maxYaksoo;
        
        bw.write(maxYaksoo+"\n");
        bw.write(minBaesoo+"");
    }//read()
}//Main
