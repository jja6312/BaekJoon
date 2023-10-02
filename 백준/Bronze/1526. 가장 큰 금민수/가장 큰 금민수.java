import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = N; i >= 4; i--) {
            if (isGeumminNumber(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isGeumminNumber(int num) {
        while (num > 0) {
            if (num % 10 != 4 && num % 10 != 7) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
