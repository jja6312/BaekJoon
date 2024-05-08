import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int minCost;
    static int[][] cost;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        cost = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            // 1. 초기화
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1-2. DP의 첫 번째 값은 각 색상비용의 첫 번째 값으로 초기화
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            //마지막집이 빨,초,파 였을 경우 중 가장작은값 출력
            min = Math.min(min, calCost(n - 1, i));
        }
        bw.write(""+min);
        bw.flush();
        bw.close();
        br.close();

    }

    private static int calCost(int currentN, int color) {
        //만약 탐색하지 않은 배열이라면
        if (dp[currentN][color] == 0) {

            //color에 따라 이전 집의 서로 다른 색을 재귀 호출하여, 최솟값과 현재 집의 비용을 더해 DP에 저장
            if (color == 0) {
                dp[currentN][color] = Math.min(calCost(currentN - 1, 1), calCost(currentN - 1, 2)) + cost[currentN][color];
            } else if (color == 1) {
                dp[currentN][color] = Math.min(calCost(currentN - 1, 0), calCost(currentN - 1, 2)) + cost[currentN][color];
            } else if (color == 2) {
                dp[currentN][color] = Math.min(calCost(currentN - 1, 0), calCost(currentN - 1, 1)) + cost[currentN][color];
            }
        }


        return dp[currentN][color];
    }
}//Main Class
