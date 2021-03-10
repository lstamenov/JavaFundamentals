import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();
        Pattern pattern = Pattern.compile("(?<string>[^0-9]+)(?<number>[0-9]+)");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            int numberOfRepeats = Integer.parseInt(matcher.group("number"));
            String sequenceToRepeat = matcher.group("string").toUpperCase();

            for (int i = 0; i < numberOfRepeats; i++) {
                text.append(sequenceToRepeat);
            }
        }
        int uniqueSymbols = getUniqueSymbols(text);
        System.out.println("Unique symbols used: " + uniqueSymbols);
        System.out.println(text);
    }

    private static int getUniqueSymbols(StringBuilder text) {
        List<Character> unique = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (!unique.contains(text.charAt(i))){
                unique.add(text.charAt(i));
            }
        }
        return unique.size();
    }
}
