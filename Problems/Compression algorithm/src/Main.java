import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // inspired by: https://hyperskill.org/learn/daily/2292#solutions-603577
        char[] dna = new Scanner(System.in).nextLine().toCharArray();
        int count = 1;
        for (int i = 1; i < dna.length; i++) {
            if (dna[i] == dna[i - 1]) {
                count++;
                continue;
            }
            System.out.print(dna[i - 1] + "" + count);
            count = 1;
        }
        System.out.print(dna[dna.length - 1] + "" + count);
    }
}