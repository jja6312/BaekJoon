import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
            }

            if (n > 32) { // MBTI 조합이 32개 이상이면 무조건 0
                bw.write("0\n");
                continue;
            }

            int minSum = Integer.MAX_VALUE;
            
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int sum = compareAB(arr[j], arr[k]) + compareAB(arr[k], arr[l]) + compareAB(arr[l], arr[j]);
                        if (sum < minSum) {
                            minSum = sum;
                        }
                    }
                }
            }

            bw.write(minSum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int compareAB(String A, String B) {
        int equalVal = 0;
        for (int i = 0; i < 4; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                equalVal++;
            }
        }
        return equalVal;
    }
}
