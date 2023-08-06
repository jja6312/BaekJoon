import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[]args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	 int N = Integer.parseInt(br.readLine());
         boolean[] isNotPrime = new boolean[1000001];
         isNotPrime[0] = isNotPrime[1] = true;
         for (int i = 2; i <= Math.sqrt(1000000); i++) {
             if (!isNotPrime[i]) {
                 for (int j = i * i; j <= 1000000; j += i) {
                     isNotPrime[j] = true;
                 }
             }
         }
    	
    	for(int i=0; i<N; i++) {
        	int num = Integer.parseInt(br.readLine());
        	int count=0;
        	for(int j=2; j<=num/2; j++) {
        		if(!isNotPrime[j] &&!isNotPrime[num-j]) {
        			count++;
        		}
        	}
        	bw.write(count+"\n");
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    	
    }//main()

    
}//Main