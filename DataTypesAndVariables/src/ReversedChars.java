import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char sym = scanner.next().charAt(0);
        char sym2 = scanner.next().charAt(0);
        char sym3 = scanner.next().charAt(0);

        System.out.printf("%c %c %c",sym3,sym2,sym);
    }
}
