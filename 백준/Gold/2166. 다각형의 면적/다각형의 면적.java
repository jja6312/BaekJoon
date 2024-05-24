import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n+1];
        long[] y = new long[n+1];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        //신발끈 공식 적용
        x[n] = x[0];
        y[n] = y[0];

        long area = 0;
        for(int i=0; i<n; i++){
            area+= x[i] * y[i+1] - y[i] * x[i+1];
        }

        double result = Math.abs(area) /2.0;
        bw.write(String.format("%.1f\n",result));

        bw.flush();
        bw.close();
        br.close();
    }



}
