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
        int X = Integer.parseInt(br.readLine());
        int arr[] = new int[7];
        int cnt = 0;
        for(int i=6; i>=0; i--){
            int b = (int)Math.pow(2,i);
            
            if(b==X){
                cnt++;
               
                break;
            }else if (b<X){
                X = X-b;
                cnt++;
                i++;
            }//else if
        }//for
        bw.write(cnt+"");
        
        /*
        2의 몇승 몇개로 이루어져있는지 판독.
        */
    }//read()
}//Main