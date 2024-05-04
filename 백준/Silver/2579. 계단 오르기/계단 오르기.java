import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static Integer[] memo;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        memo = new Integer[n+1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 초기 상태 설정
        memo[0] = 0; // 0번째 계단은 없음, 시작점
        if (n > 0) memo[1] = arr[1];
        if (n > 1) memo[2] = arr[1] + arr[2];

        // 결과 출력
        bw.write(maxSum(n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static int maxSum(int index) {
        if (index <= 0) return 0;
        if (memo[index] != null) return memo[index];

        // 계산
        int oneStep = maxSum(index-2) + arr[index];
        int twoStep = maxSum(index-3) + arr[index-1] + arr[index];
        memo[index] = Math.max(oneStep, twoStep);
        
        return memo[index];
    }
}
