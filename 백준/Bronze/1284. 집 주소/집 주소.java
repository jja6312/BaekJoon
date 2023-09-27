import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();
            if (s.equals("0")) {  // 종료 조건
                break;
            }

            int width = s.length() + 1;  // 각 숫자 사이와 맨 앞에는 1cm의 간격이 필요합니다.

            for (int i = 0; i < s.length(); i++) {
                char num = s.charAt(i);
                switch (num) {
                    case '1':
                        width += 2;
                        break;
                    case '0':
                        width += 4;
                        break;
                    default:
                        width += 3;
                        break;
                }
            }
            System.out.println(width);
        }

        sc.close();
    }
}
