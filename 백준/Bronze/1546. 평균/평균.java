import java.util.*;
import java.io.*;
import java.text.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer N = Integer.valueOf(br.readLine());
        
        Integer [] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);
        int max = arr[N-1];
        int sum=0;
        for(int i=0; i<N; i++){
            sum += arr[i];
        }
        double avg = (1.0*sum/N)/max*100;
        DecimalFormat df = new DecimalFormat("#.##");
        String avgS = df.format(avg);
        bw.write(avgS);
        bw.flush();
        bw.close();
        br.close();
    }
}