import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	//삼각형의 성질1. 모든 변의 길이가 같다면, 그게 가장 길다.
        //삼각형의 성질2. 가장 긴변 - 나머지 두변 >0 이다.
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.valueOf(st.nextToken());
        long b = Long.valueOf(st.nextToken());
        long c = Long.valueOf(st.nextToken());
        
        long arr[] = new long[3];
        arr[0]= a;
        arr[1]= b;
        arr[2]= c;
        
        Arrays.sort(arr);
        
        
            if(arr[2]-(arr[1]+arr[0])>=0){        //가장 긴 변이 정도를 지나친다면,
                arr[2]=arr[1]+arr[0]-1;
                bw.write(""+(arr[0]+arr[1]+arr[2]));    
            }else{
                bw.write(""+(arr[0]+arr[1]+arr[2]));    
            }
        bw.flush();
        bw.close();
        br.close();
    }//main()
}//Main