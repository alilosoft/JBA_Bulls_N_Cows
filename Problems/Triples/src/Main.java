import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        int triples = 0;
        for (int i = 0; i < length - 2; i++) {
            if (arr[i + 1] - arr[i] == 1 && arr[i + 2] - arr[i + 1] == 1) {
                triples++;
            }
        }
        System.out.println(triples);
    }
}