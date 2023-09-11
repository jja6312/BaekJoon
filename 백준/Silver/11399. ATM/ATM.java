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
        String B = br.readLine();
        StringTokenizer st= new StringTokenizer(B," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum=0;
        int result=0;
        for(int i=0; i<N; i++){
            sum += arr[i];
            result += sum;
        }
        bw.write(result+"");
        
    }//read()
}//Main
