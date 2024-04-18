import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 팩토리얼(n)/(팩토리얼(n-k)*팩토리얼(k));
        bw.write(""+answer);


        bw.flush();
        bw.close();
        br.close();

    }

    public static int 팩토리얼(int num){
        int mul = num;
        int val = 1;

        while(mul>=1){
            val *= mul;
            mul--;
        }
        return val;
    }

}
