import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        Arrays.fill(arr, 1);

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int brokenBtn = Integer.parseInt(st.nextToken());
                arr[brokenBtn] = 0; // 부서진 버튼은 0 처리
            }
        }

        // +, -로 이동하는 경우
        int minPress = Math.abs(n - 100);

        // 브루트포스
        for (int i = 0; i <= 999999; i++) {
            int len = isPossible(i);
            if (len > 0) {
                int press = Math.abs(n - i) + len;
                minPress = Math.min(minPress, press);
            }
        }
        bw.write(minPress + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int isPossible(int channel) {
        String str = String.valueOf(channel);
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (arr[str.charAt(i) - '0'] == 0) return 0; // 유효하지 않은 채널이면 0 리턴
        }
        return len; // 유효한 채널은 len 리턴
    }
}
