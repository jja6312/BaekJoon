import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 책의 개수 N과 각 박스의 최대 무게 M을 입력받습니다.
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 만약 책의 개수가 0개이면 필요한 박스의 개수는 0입니다.
        if (N == 0) {
            System.out.println(0);
            return;
        }

        // 책의 무게를 입력받습니다.
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }

        // 필요한 박스의 수를 계산합니다.
        int boxCount = 1;  // 첫 번째 박스를 사용합니다.
        int currentBoxWeight = 0;

        for (int i = 0; i < N; i++) {
            if (currentBoxWeight + weights[i] > M) {
                // 현재 박스에 책을 넣을 수 없다면 새 박스를 사용합니다.
                boxCount++;
                currentBoxWeight = weights[i];
            } else {
                // 현재 박스에 책을 넣습니다.
                currentBoxWeight += weights[i];
            }
        }

        // 필요한 박스의 수를 출력합니다.
        System.out.println(boxCount);
    }
}
