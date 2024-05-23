import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[] fluid;
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        fluid = new long[n];
        for(int i = 0 ; i<n; i++){
            fluid[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(fluid);
        long min = INF;
        int ansFix=0;
        int ansLt=0;
        int ansRt=0;

        for(int fix = 0; fix<n-2; fix++){
            if(min==0) break;

            int lt = fix+1;
            int rt = n-1;
            while(lt<rt){
                long sum = fluid[fix] + fluid[lt] + fluid[rt];
                long sumAbs = Math.abs(sum);
                if(sumAbs<min){
                    ansFix = fix;
                    ansLt = lt;
                    ansRt = rt;
                    min = sumAbs;
                }

                if(sum<0) lt++;
                else if(sum==0) break;
                else if(sum>0) rt--;

            }
        }
        bw.write(fluid[ansFix] + " " + fluid[ansLt] + " " + fluid[ansRt]);
        bw.flush();
        bw.close();
        br.close();
    }//main()

}//Main Class
