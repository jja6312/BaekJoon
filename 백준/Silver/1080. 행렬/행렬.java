import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[][] A;
    static int[][] B;
    static int cnt;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        A = new int[n][m];
        B = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                A[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                B[i][j] = str.charAt(j)-'0';
            }
        }

        if(isSameAB()) {
            System.out.println("0");
            return;
        }



        for(int i=0; i<=n-3; i++){
            for(int j=0; j<=m-3; j++){
                if(A[i][j]!=B[i][j]){
                    cnt++;
                    flip(i,j);
                }

            }
        }

        if(isSameAB()){
            bw.write(cnt+"");
        }else{
            bw.write("-1");
        }


        bw.flush();
        bw.close();
        br.close();


    }//main

    private static void flip(int y, int x) {
        for(int i=y; i<y+3; i++){
            for(int j=x; j<x+3; j++){
                if(A[i][j]==0) A[i][j] = 1;
                else if(A[i][j]==1) A[i][j] = 0;

            }
        }
    }


    private static boolean isSameAB() {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A[i][j]!=B[i][j]) return false;
            }
        }

        return true;
    }


}//Main
