import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long count=0;
        for (long i=1; i<=n-2; i++) {
        	count += (n-i)*(n-i-1);
        }
        System.out.println(count/2);
        System.out.println(3);
    }
}