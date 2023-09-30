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
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int answer = 4;
        
        
        for(int i=0; i<N-1; i++){
            int cnt = 1;
            for(int j=i+1; j<N && arr[j]<=arr[i]+4; j++){
                cnt++;
            }
           answer = Math.min(answer, 5-cnt);

        }//for
        bw.write(answer+"");
        
        
    }//read()
}//Main