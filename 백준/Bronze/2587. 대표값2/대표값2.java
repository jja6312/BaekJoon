import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer[] arr = new Integer[5];
        
        for(int i=0; i<5; i++){
            int element = Integer.valueOf(br.readLine());
            arr[i]=element;
        }
        Arrays.sort(arr);
        
        //평균구하기
        int sum=0;
        for(int i=0; i<5; i++){
            sum += arr[i];
        }
        bw.write(sum/5+"\n");
        
        //중간값구하기
        bw.write(""+arr[2]);
        bw.flush();
        bw.close();
        br.close();
        
       
        
    }//main()
}//Main