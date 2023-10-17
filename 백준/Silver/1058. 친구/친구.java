import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        read();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void read() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[] ABCDE = new int[N];

        for (int i = 0; i < N; i++) {
            String A = br.readLine();
            for (int j = 0; j < N; j++) {
                if (A.charAt(j) == 'Y') {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && (arr[i][j] == 1 || isTwoFriend(arr, i, j, N))) {
                    ABCDE[i]++;
                }
            }
        }

        Arrays.sort(ABCDE);
        bw.write(ABCDE[N - 1] + "");
    }

    public static boolean isTwoFriend(int[][] arr, int i, int j, int N) {
        for (int k = 0; k < N; k++) {
            if (arr[i][k] == 1 && arr[k][j] == 1) {
                return true;
            }
        }
        return false;
    }
}
