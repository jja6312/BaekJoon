import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        String A = br.readLine();
        Character arr[] = new Character[A.length()];
        for(int i=0; i<A.length(); i++){
            arr[i] = A.charAt(i);
        }
        for(int i=0; i<N-1; i++){
            String B = br.readLine();
            for(int j=0; j<A.length(); j++){
                if(arr[j]==B.charAt(j)) continue;
                else arr[j] = '?';
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<A.length(); i++){
            sb.append(arr[i]);
        }
        bw.write(sb.toString());
    }//read()
}//Main