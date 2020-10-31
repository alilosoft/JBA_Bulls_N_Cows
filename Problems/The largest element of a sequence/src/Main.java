import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        int next;
        while ((next = scanner.nextInt()) != 0) {
            if (next > max) {
                max = next;
            }
        }
        System.out.println(max);
    }
}