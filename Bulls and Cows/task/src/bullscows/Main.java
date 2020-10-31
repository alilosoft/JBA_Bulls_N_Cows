package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int requiredLength = maxSecretLength();
        if (requiredLength == -1) return;

        int possibleSymbols = maxPossibleSymbols(requiredLength);
        if (possibleSymbols == -1) return;

        String secret = generateSecret(requiredLength, possibleSymbols);
        play(secret);
    }

    private static int maxSecretLength() {
        System.out.println("Please! enter the length of the secret code:");
        String input = new Scanner(System.in).nextLine();
        if (input.matches("[0-9]+")) {
            int length = Integer.parseInt(input);
            if (length < 1 || length > 36) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d!\n", length);
                return -1;
            }
            return length;
        } else {
            System.out.printf("Error: %s isn't a valid number!\n", input);
            return -1;
        }
    }

    private static int maxPossibleSymbols(int secretLength) {
        System.out.println("Input the number of possible symbols in the code:");
        String input = new Scanner(System.in).nextLine();
        if (input.matches("[0-9]+")) {
            int possibleSymbols = Integer.parseInt(input);
            if (possibleSymbols < secretLength) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols!\n", secretLength, possibleSymbols);
                return -1;
            }
            if (possibleSymbols > 36) {
                System.out.println("Error: The maximum number of possible symbols in the code is 36 (0-9, a-z)!");
                return -1;
            }
            return possibleSymbols;
        } else {
            System.out.printf("Error: %s isn't a valid number!\n", input);
            return -1;
        }
    }

    private static String generateSecret(int requiredLength, int symbolsCount) {
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder secret = new StringBuilder();
        Random generator = new Random();
        do {
            int symbolIndex = generator.nextInt(symbolsCount);
            String symbol = String.valueOf(symbols.charAt(symbolIndex));
            if (secret.indexOf(symbol) == -1) {
                secret.append(symbol);
            }
        } while (secret.length() != requiredLength);
        String stars = "*".repeat(requiredLength);
        String digitsRange = symbolsCount >= 10 ? "0-9" : String.format("0-%d", symbolsCount - 1);
        String alphabetsRange = symbolsCount <= 10 ? "" : String.format(", a-%c", symbols.charAt(symbolsCount - 1));
        System.out.printf("The secret is prepared: %s (%s%s).\n", stars, digitsRange, alphabetsRange);
        return secret.toString();
    }

    private static boolean checkGuess(String guess, String secret) {
        int cows = 0;
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (secret.indexOf(guess.charAt(i)) >= 0) {
                    cows++;
                }
            }
        }
        String bullsStr = bulls == 0 ? "" : bulls + " bull(s)";
        String andStr = bulls > 0 && cows > 0 ? " and " : "";
        String cowsStr = cows == 0 ? "" : cows + " cow(s)";
        String result = cows == 0 && bulls == 0 ? "None" : bullsStr + andStr + cowsStr;
        System.out.println(String.format("Grade: %s", result));
        return bulls == secret.length();
    }

    private static void play(String secret) {
        System.out.println("Okay, let's start a game!");
        Scanner scanner = new Scanner(System.in);
        boolean correct;
        int turn = 1;
        do {
            System.out.printf("Turn %d: ", turn++);
            String guess = scanner.next().trim();
            if (guess.length() != secret.length()) {
                System.out.println("Error: Your guess contains incorrect number of symbols!");
                break;
            }
            if (!guess.matches("[0-9,a-z]+")) {
                System.out.println("Error: Your guess contains invalid symbols!");
                break;
            }
            correct = checkGuess(guess, secret);
        } while (!correct);
        System.out.println("Congratulations! You guessed the secret code.");
    }
}

class Tests {
    public static void main(String[] args) {
        assert "123456".matches("[0-9]+");
        assert !"123abc".matches("[0-9]+");
        assert "123abc".matches("[0-9,a-z]+");
        assert !"123 abc".matches("[0-9,a-z]+");
        assert !"123-abc".matches("[0-9]+[a-z]+");
        assert !"$123abc".matches("[0-9]+[a-z]+");
    }
}
