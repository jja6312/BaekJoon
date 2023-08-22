import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String []arr;
    
        public static void main(String[]args) throws IOException{
            read();
            bw.flush();
            bw.close();
            br.close();
            
        }//main()
    
        public static void read() throws IOException{
            String A = br.readLine();
            arr= new String[A.length()];
            for(int i=0; i<arr.length; i++){
                arr[i]=A.substring(i);
            }
            Arrays.sort(arr);
            for(int i=0; i<arr.length; i++){
                bw.write(arr[i]+"\n");
            }
            
            
        }//read()
}//Main