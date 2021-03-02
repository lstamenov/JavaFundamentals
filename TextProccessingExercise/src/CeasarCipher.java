import java.util.Scanner;

public class CeasarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder word = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            word.setCharAt(i, (char) (currentChar + 3));
        }

        System.out.println(word);
    }
}
