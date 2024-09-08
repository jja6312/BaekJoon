import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();  // 전체 카드 수
        int M = sc.nextInt();  // O가 적힌 카드 수
        int K = sc.nextInt();  // 뽑을 카드 중 O가 적힌 카드 수

        // 맞출 수 있는 O 카드의 수는 최소값으로 결정됨
        int oMatch = Math.min(M, K);
        // 맞출 수 있는 X 카드의 수는 최소값으로 결정됨
        int xMatch = Math.min(N - M, N - K);

        // 맞춘 카드의 총합
        int result = oMatch + xMatch;

        // 결과 출력
        System.out.println(result);
    }
}
