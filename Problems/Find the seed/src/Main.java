import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int minOfMax = Integer.MAX_VALUE;
        int seedOfMin = Integer.MAX_VALUE;
        for (int seed = a; seed <= b; seed++) {
            int maxOfRandom = 0;
            Random generator = new Random(seed);
            for (int count = 0; count < n; count++) {
                maxOfRandom = Math.max(maxOfRandom, generator.nextInt(k));
            }
            if (maxOfRandom < minOfMax) {
                minOfMax = maxOfRandom;
                seedOfMin = seed;
            }
        }
        System.out.println(seedOfMin);
        System.out.println(minOfMax);
    }
}