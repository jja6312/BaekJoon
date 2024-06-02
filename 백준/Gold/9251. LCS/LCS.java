    import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        String A = br.readLine();
        String B = br.readLine();

        int[][]dp = new int[A.length()+1][B.length()+1];
        for(int i=1; i<=A.length(); i++){
            for(int j=1; j<=B.length(); j++){
                if(A.charAt(i-1)==B.charAt(j-1)) dp[i][j] = dp[i-1][j-1] +1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);


            }
        }

        bw.write(dp[A.length()][B.length()]+"");
        bw.flush();
        bw.close();
        br.close();


    }//main

    private static boolean isValidBoundary(int lt, int rt, String B) {
        return lt>=0 && lt<B.length() && rt>=0 && rt<B.length();
    }


}//Main
