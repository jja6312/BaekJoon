import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();
            
    }
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        String B = br.readLine();
        StringTokenizer st = new StringTokenizer(B, " ");
        int result = 0;
        if(N==1){
            int numB = Integer.parseInt(B);
            result = numB*numB;
            
        }else{
            int[] arrNum = new int[N];
            for(int i=0; i<N; i++){
                arrNum[i]= Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrNum);
            result = arrNum[0]*arrNum[N-1];
        }
        bw.write(result+"");
    }
}