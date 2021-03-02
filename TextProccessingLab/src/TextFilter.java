import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsToBeBanned = scanner.nextLine().split(", ");
        String sentence = scanner.nextLine();

        for ( String wordToBeBanned : wordsToBeBanned) {
            sentence = sentence.replace(wordToBeBanned, asteriks(wordToBeBanned));
        }
        System.out.println(sentence);
    }

    private static String asteriks(String wordToBeBanned) {
        String newString = "";
        for (int i = 0; i < wordToBeBanned.length(); i++) {
            newString += "*";
        }
        return newString;
    }
}
