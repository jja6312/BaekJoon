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
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }
        
        Arrays.sort(arr, (a,b)->Integer.compare(a[0],b[0]));
        int max = 0;
        for(int i=0; i<N; i++){
            if(max<arr[i][1]-i){
                max = arr[i][1]-i;
            }
        }
        bw.write((max+1)+"");
        
    }//read()
}//Main