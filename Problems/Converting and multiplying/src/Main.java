import java.util.Scanner;
// inspired by: https://hyperskill.org/learn/step/2481#solutions-625173
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"0".equals(input = scanner.nextLine())) {
            try {
                System.out.println(Integer.parseInt(input) * 10);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}