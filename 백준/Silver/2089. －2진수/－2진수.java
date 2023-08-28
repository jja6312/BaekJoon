import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder answer = new StringBuilder();
        
        if (n == 0) {
            System.out.print(0);
            return;
        }
        
        while (n != 0) {
            int remainder = n % -2;
            if (remainder < 0) {
                remainder += 2;
            }
            answer.insert(0, remainder);
            
            n = (n - remainder) / -2;
        }
        
        System.out.print(answer);
    }
}
