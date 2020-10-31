import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).next();
        // inspired by : https://hyperskill.org/learn/daily/2295#solutions-603636
        int middle = input.length() / 2;
        String left = input.substring(0, middle - 1 + input.length() % 2);
        String right = input.substring(middle + 1);
        System.out.println(left + right);
    }
}