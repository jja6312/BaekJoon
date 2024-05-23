import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        // 1. n까지 배열을 만들고, 소수가 아닌 것들을 제거한다.
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) { // 소수라면
                for (int j = i * i; j <= n; j += i) { // 소수의 배수들을 없애버린다
                    isPrime[j] = false;
                }
            }
        }

        // 2. 소수를 List에 담는다.
        List<Integer> sosuList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) sosuList.add(i);
        }

        // 3. 투 포인터를 사용하여 연속된 소수의 합이 n이 되는 경우를 찾는다.
        int count = countPrimeSums(sosuList, n);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int countPrimeSums(List<Integer> sosuList, int target) {
        int count = 0;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < sosuList.size(); end++) {
            sum += sosuList.get(end);

            while (sum > target && start <= end) {
                sum -= sosuList.get(start++);
            }

            if (sum == target) {
                count++;
            }
        }

        return count;
    }
}
