import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minHeight = 0;
        int maxHeight = 256;
        int minTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        for (int h = minHeight; h <= maxHeight; h++) {
            int currentTime = 0;
            int inventory = b;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = arr[i][j] - h;
                    if (diff > 0) {
                        currentTime += diff * 2; // 제거
                        inventory += diff;
                    } else if (diff < 0) {
                        currentTime -= diff; // 추가
                        inventory += diff;
                    }
                }
            }

            if (inventory >= 0 && currentTime <= minTime) {
                if (currentTime < minTime || (currentTime == minTime && h > bestHeight)) {
                    minTime = currentTime;
                    bestHeight = h;
                }
            }
        }

        bw.write(minTime + " " + bestHeight + "\n");
        bw.flush();
        bw.close();
        br.close();
    }//main
}//Main
