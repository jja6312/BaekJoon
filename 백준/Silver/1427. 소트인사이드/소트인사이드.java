import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String a = N+"";
        int b = a.length();
        Integer [] arr = new Integer[b];
        
        int length=0;
        while(N>0) {
        	arr[length]= N%10;
        	N/=10;
        	length++;
        }
        Arrays.sort(arr);
        for(int j=b-1; j>=0; j--) {
        	bw.write(arr[j]+"");
        }
        bw.flush();
        bw.close();
        br.close();

    }//main()
}//Main