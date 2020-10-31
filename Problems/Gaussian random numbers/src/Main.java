import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        boolean found = false;
        do {
            Random generator = new Random(k++);
            for (int i = 1; i <= n; i++) {
                if (generator.nextGaussian() > m) {
                    break;
                }
                found = i == n;
            }
        } while (!found);
        System.out.println(k - 1);
    }
}