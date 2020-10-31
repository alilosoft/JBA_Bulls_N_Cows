import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next(); // ignore size!
        int current = scanner.nextInt();
        boolean isAsc = true;
        while (scanner.hasNextInt() && isAsc) {
            int next = scanner.nextInt();
            isAsc = current <= next;
            current = next;
        }
        System.out.println(isAsc);
    }
}
