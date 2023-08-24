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
        long [] arr = new long[1000001];
        for(int i=0; i<arr.length; i++){//arr 초기화
            arr[i]=0;
        }
        //소수는어떻게찾더라?
        //본인숫자의 절반까지 계산해 봤을 때, 나누었을 때 0으로 떨어지는 것이 없으면 된다.
        //짝수는 소수의 합으로 이루어질 수 있다?
        //8 = 3 + 5 가 나오려면?
        //1. 읽은 8까지 읽어들인다. (소수니까 절반까지만 읽어도 된다.)
        //2.소수1 : 소수를 찾는다.
        //3.소수2 : 읽은 8에서 첫 소수1만큼 뺀 값
        
        for(int i=2; i<1000001; i++){//소수찾기
        	boolean trueSwitch = true;
        	
            for(int j=2; j<=(int)Math.sqrt(i); j++){
                if(i%j==0){
                    trueSwitch = false;
                    break;
                }
            }//for2
            if(trueSwitch==true){
            	arr[i]++;
            }
        }//for1
        
        //작은 소수부터, 나눠지는지 여부를 확인하고 안나눠진다면 값 출력.
        long A;
        StringBuilder sb = new StringBuilder();
        while((A=Long.parseLong(br.readLine()))!=0){
            sb.append(A + " = ");
            for(int i=3; i<A; i++){
                if(arr[i]==1){
                	if(arr[(int)A-i]==1) {
                		sb.append(i + " + ");
                		sb.append(A-i + "\n");
                		break;
                	}//if2
                }//if1
                
            }//for
        }//while
        bw.write(sb.toString());
        
    }//read()
}//Main