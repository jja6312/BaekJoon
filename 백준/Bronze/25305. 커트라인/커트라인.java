/*
5 2
100 76 85 93 98

정렬했을 때 뒤에서 두번째를 구하라.
*/

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nString = br.readLine();
        
        String[] arr = nString.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        
        String secondString = br.readLine();
        
        String[] arr2 = secondString.split(" ");
        int[] result = new int[N];
        for(int i=0; i<N; i++){
            result[i] = Integer.parseInt(arr2[i]);
        }
        Arrays.sort(result);
        
        bw.write(""+result[N-M]);
        bw.flush();
        bw.close();
        br.close();
       
        
    }//main()
}//Main