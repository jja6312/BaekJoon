import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        //상대에게 2가 남게하면 이긴다.

        //1일 때, 1 가져가면 내가이긴다.
        //2일 때, 필연적으로 진다.
        //3일 때, 3 가져가면 내가 이긴다.
        //4일 때, 4 가져가면 내가 이긴다.
        //5일 때, 3 가져가면 내가 이긴다.(그다음 2가남기때문.)

        //6일 때, 상대가 2가 남게하기 위해 4를 가져간다.
        //7일 때, 3가져가면 상대가 이기므로. 1가져가야한다.
        //8일 때, 1가져가면 이길 수 있다.

        boolean dp[] = new boolean[n+1];

        dp[1] = true;
        if(n>=2) dp[2] = false;
        if(n>=3) dp[3] = true;
        if(n>=4) dp[4] = true;
        if(n>=5){
            for(int i=5; i<=n; i++){
                if(!dp[i-1] || !dp[i-3] || !dp[i-4]){//상대가 true가나오게하면안됨
                    dp[i] = true;
                }else{
                    dp[i] = false;
                }

            }
        }

        if(dp[n]){
            bw.write("SK");
        }else{
            bw.write("CY");
        }

        bw.flush();
        bw.close();
        br.close();
    }





}
