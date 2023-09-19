import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int X = 0;
        while (sum < N) {
            X++;
            sum += X;
        }

        if (N == 1) {
            bw.write("1/1");
        } else {
            int min = sum - X;  // 여기를 수정했습니다.
            int realIndex = N - (min + 1);

            int[] arr = new int[X];
            for (int i = 0; i < X; i++) {
                arr[i] = i + 1;
            }

            if (X % 2 == 0) {
                bw.write(arr[realIndex] + "/");
                bw.write(arr[(X - 1) - realIndex] + "");
            } else {
                bw.write(arr[(X - 1) - realIndex] + "/");
                bw.write(arr[realIndex] + "");
            }
        }
    }
}//Main