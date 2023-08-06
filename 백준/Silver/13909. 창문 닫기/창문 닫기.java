import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    
    public static void main(String[]args) throws IOException{
    	bw.write(""+read());
        bw.flush();
        bw.close();
        br.close();
    }//main()
    
    public static int read() throws IOException{
        N = Integer.parseInt(br.readLine());

        int count = 0;
    	for(int i=1; i*i<=N; i++){
        	count++;
        }//for 
    	return count;
    }//read()
}//Main