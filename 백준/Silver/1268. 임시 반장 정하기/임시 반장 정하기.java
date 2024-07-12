import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] students = new int[n][5];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                students[i][j] = scanner.nextInt();
            }
        }
        
        int maxCount = 0;
        int president = 0;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                for (int k = 0; k < 5; k++) {
                    if (students[i][k] == students[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            
            if (count > maxCount) {
                maxCount = count;
                president = i;
            }
        }
        
        System.out.println(president + 1);
    }
}
