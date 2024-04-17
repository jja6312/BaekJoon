import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];//n+1 까지의 피보나치수열을 만들어야한다.

        arr = pivo(n);
        int answer = arr[n];
        bw.write(""+answer);

        bw.flush();
        bw.close();
        br.close();

    }

    public static int[] pivo(int n){
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<n+1; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr;
    }

}
