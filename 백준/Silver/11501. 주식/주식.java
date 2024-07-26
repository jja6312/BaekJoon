import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int test=0; test<t; test++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            long profit = 0;
            for(int i=n-1; i>=0; i--){
                if(arr[i]>max){
                    max = arr[i];
                }else{
                    profit += max-arr[i];
                }
            }

bw.write(profit+"\n");        }
        bw.flush();
        bw.close();
        br.close();
    }
}
