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
        /*X를 구하자.
        X 는 , N번째가 속하는 배열의 순서이다.
        */
        int sum = 0; //sum은 N이속한 배열의 최고값의 순서.
        int X=0; //X는 몇번째 배열인지 판독하는것
        while(sum<N) {
        	X++;
        	sum+=X;
        }
        
        if(N==1){
        	bw.write("1/1");
        }else {
        	int min = sum - X;
        	
	        	
	        //index 번째 배열이라고 볼수있다.
	        int[] arr = new int[X];
	        for(int i=0; i<X; i++){
	            arr[i]=i+1;
	        }
	        int realIndex = N-min-1;
	        
	        if(N==min) {
	        	bw.write(arr[X-1]+"/1");
	        	return;
	        }
	        if(X%2==0){
	            //분자
	            bw.write(arr[realIndex]+"/");
	            //분모
	            bw.write(arr[(X-1)-realIndex]+"");
	        }else{
	            //분자
	            bw.write(arr[(X-1)-realIndex]+"/");
	            //분모
	            bw.write(arr[realIndex]+"");
	        }
        }
        
    }//read()
}//Main