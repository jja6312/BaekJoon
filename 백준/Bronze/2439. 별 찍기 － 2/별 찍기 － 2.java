import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String N = br.readLine();
        int n = Integer.parseInt(N);
        
        
        for(int i=1; i<=n; i++){
            for(int j=n-i; j>0; j--){
                bw.write(" ");
            }
            for(int j=1; j<=i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}