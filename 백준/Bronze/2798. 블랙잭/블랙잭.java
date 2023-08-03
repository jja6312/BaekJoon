import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int l=j+1; l<N; l++){
                    int sum = arr[i] + arr[j] + arr[l];
                    if (sum <= M && sum > result) {
                        result = sum;
                    }
                }    
            }
        }

        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
    }
}
