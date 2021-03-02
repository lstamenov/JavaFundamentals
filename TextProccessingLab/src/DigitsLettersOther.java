import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        List<String> chars = new ArrayList<>();

        String symbols = scanner.nextLine();

        for (int i = 0; i < symbols.length(); i++) {
            if (Character.isDigit(symbols.charAt(i))){
                digits.add(String.valueOf(symbols.charAt(i)));
            }else if (isCapitalLetter(symbols.charAt(i)) || isSmallLetter(symbols.charAt(i))){
                letters.add(String.valueOf(symbols.charAt(i)));
            }else {
                chars.add(String.valueOf(symbols.charAt(i)));
            }
        }
        System.out.println(String.join("", digits));
        System.out.println(String.join("", letters));
        System.out.println(String.join("", chars));
    }

    private static boolean isSmallLetter(char charAt) {
        return charAt > 96 && charAt < 123;
    }

    private static boolean isCapitalLetter(char charAt) {
        return charAt > 64 && charAt < 91;
    }
}
