import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] distanceCityByCity;
    static final int INF = 10000000; // (무한대)

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        distanceCityByCity = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) distanceCityByCity[i][j] = 0;
                else distanceCityByCity[i][j] = INF;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            distanceCityByCity[s][e] = Math.min(distanceCityByCity[s][e], distance);
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (distanceCityByCity[s][k] != INF && distanceCityByCity[k][e] != INF) {
                        distanceCityByCity[s][e] = Math.min(distanceCityByCity[s][e], distanceCityByCity[s][k] + distanceCityByCity[k][e]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distanceCityByCity[i][j] == INF) bw.write("0 ");
                else bw.write(distanceCityByCity[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
