import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       
        long a = Long.valueOf(st.nextToken());
        long b = Long.valueOf(st.nextToken());
        long c = Long.valueOf(st.nextToken());
        long d = Long.valueOf(st.nextToken());
        long e = Long.valueOf(st.nextToken());
        long f = Long.valueOf(st.nextToken());
        
        long x = 0; 
        long y = 0;

        for(x=-999; x<1000; x++) {
        	for(y=-999; y<1000; y++) {
        		if((a*x+b*y==c) && (d*x+e*y==f)) {
        			bw.write(""+x+" "+y);
        			break;
        		}
        	}
        }
       
        bw.flush();
        bw.close();
        br.close();
        

        
        
    }//main()
}//Main