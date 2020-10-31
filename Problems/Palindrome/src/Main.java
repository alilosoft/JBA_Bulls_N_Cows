import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        String word = new Scanner(System.in).nextLine();
        boolean palindrome = true;
        for (int i = 0; i < word.length() / 2; i++) {
            palindrome &= word.charAt(i) == word.charAt(word.length() - 1 - i);
        }
        System.out.println(palindrome ? "yes" : "no");
        for (int i = 0; i < 10; i++);
    }

}