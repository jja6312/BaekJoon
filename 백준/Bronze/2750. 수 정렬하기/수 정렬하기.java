import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.valueOf(br.readLine());
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        for(int i=0; i<N; i++){
            int element = Integer.valueOf(br.readLine());
            arrList.add(element);
        }
        Collections.sort(arrList);
        
        
        for(int i=0; i<arrList.size(); i++){
        bw.write(arrList.get(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
       
        
    }//main()
}//Main