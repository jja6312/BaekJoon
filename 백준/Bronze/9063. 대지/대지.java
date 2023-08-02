import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        String list=br.readLine();
        long N =Long.valueOf(list);
        
        ArrayList<Long> arrX = new ArrayList<Long>();
        ArrayList<Long> arrY = new ArrayList<Long>();
        
        if(N==1){
        	st = new StringTokenizer(br.readLine(), " ");
            bw.write(""+0);
            bw.flush();
            bw.close();
            br.close();
        }else{  
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                long x = Integer.valueOf(st.nextToken());
                long y = Integer.valueOf(st.nextToken());
                arrX.add(x);
                arrY.add(y);
            }//for    
            Collections.sort(arrX);
            Collections.sort(arrY);
            
            long resultX=0;
            long resultY=0;
            
            resultX=arrX.get((int)N-1)-arrX.get(0);
            resultY=arrY.get((int)N-1)-arrY.get(0);
            
            bw.write(""+resultX*resultY);
            bw.flush();
            bw.close();
            br.close();
        }//else
    }//main()
}//Main