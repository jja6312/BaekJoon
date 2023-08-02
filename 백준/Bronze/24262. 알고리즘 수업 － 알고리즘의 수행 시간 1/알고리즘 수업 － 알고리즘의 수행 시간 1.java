import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.valueOf(br.readLine());
        bw.write(""+1+"\n"+"0");
        bw.flush();
        bw.close();
        br.close();
       
        
    }//main()
}//Main