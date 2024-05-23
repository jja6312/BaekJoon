import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(true){
            if(sum>=s){
                minLength = Math.min(minLength, end-start);
                sum -= arr[start++];
            }else if(end==n){
                break;
            }else {
                sum += arr[end++];
            }
        }

        if(minLength==Integer.MAX_VALUE) bw.write("0");
        else bw.write(minLength+"");

        bw.flush();
        bw.close();
        br.close();
    }//main()

}//Main Class
