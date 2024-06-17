import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = new int[n];
        int[] dec = new int[n];

        // 증가하는 부분 수열의 길이를 계산
        for (int i = 0; i < n; i++) {
            inc[i] = 1; // 기본적으로 각 위치에서의 증가 수열 길이는 1
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && inc[i] < inc[j] + 1) {
                    inc[i] = inc[j] + 1;
                }
            }
        }

        // 감소하는 부분 수열의 길이를 계산
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1; // 기본적으로 각 위치에서의 감소 수열 길이는 1
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dec[i] < dec[j] + 1) {
                    dec[i] = dec[j] + 1;
                }
            }
        }

        // 가장 긴 바이토닉 부분 수열의 길이 계산
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
        }

        bw.write(maxLen + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
