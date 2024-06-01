import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 간격 계산
        int gcdVal = arr[1] - arr[0];
        for (int i = 1; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            gcdVal = gcd(gcdVal, diff);
        }

        int totalNewTrees = 0;
        for (int i = 0; i < n - 1; i++) {
            totalNewTrees += (arr[i + 1] - arr[i]) / gcdVal - 1;
        }

        bw.write(totalNewTrees + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
