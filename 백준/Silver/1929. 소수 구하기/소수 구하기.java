
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int m,n;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        isPrime = new boolean[n+1];
        for(int i=2; i<=n; i++){
            isPrime[i] = true;
        }

        // m 이상 n 이하 소수구하기.
        for(int i=2; i<=Math.sqrt(n); i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=m; i<=n; i++){
            if(isPrime[i]){
                bw.write(i+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
