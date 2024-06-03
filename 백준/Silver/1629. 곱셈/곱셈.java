    import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        StringTokenizer  st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long answer = pow(a,b,c);
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();


    }//main

    private static long pow(int a, int b, int c) {
        if(b==0) return 1;

        long half = pow(a,b/2,c);
        half = (half*half) % c;

        if(b%2!=0) half = (half * a) % c;

        return half;
    }

}//Main
