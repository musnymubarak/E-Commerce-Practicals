import java.util.Scanner;

public class Ex5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int half = n / 2;

        for (int i = 1; i <= n; i++) {
            if (i <= half) {
                System.out.print((half - i + 1) + " "); 
            } else {
                System.out.print((n - (i - half)) + " "); 
            }
        }
    }
}
