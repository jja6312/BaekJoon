import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        for(int i=0 ; i< N; i++){
            int n = Integer.parseInt(br.readLine());
            arrList.add(n);
        }
        Collections.sort(arrList);
        
        for(int i=0 ; i< N; i++){
            bw.write(arrList.get(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
       
        
    }//main()
}//Main