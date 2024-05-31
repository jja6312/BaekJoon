import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cnt = find(m,n,x,y);

            bw.write(cnt+"\n");
        }




        bw.flush();
        bw.close();
        br.close();


    }//main

    private static int find(int m, int n, int x, int y) {
        int k = x;
        while(k<= m*n){
            if((k-1)%n +1 == y){
                return k;
            }

            k+=m;
        }
        return -1;
    }

}//Main
