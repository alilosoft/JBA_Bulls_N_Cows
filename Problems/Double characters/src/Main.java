import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        for (String ch : input.split("")) {
            System.out.print(ch + ch);
        }
    }
}