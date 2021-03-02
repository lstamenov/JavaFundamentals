import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String word = scanner.nextLine();

        String wordToExtract = word;
        int nextKeyIndex = wordToExtract.indexOf(key, 0);
        while (nextKeyIndex != -1) {
            int currIndex = 0;
            List<String> substrings = new ArrayList<>();
            while (nextKeyIndex != -1) {
                String substr = wordToExtract.substring(currIndex, nextKeyIndex);
                substrings.add(substr);
                currIndex = nextKeyIndex + key.length();
                nextKeyIndex = wordToExtract.indexOf(key, currIndex);
            }
            substrings.add(wordToExtract.substring(currIndex));
            wordToExtract = String.join("", substrings);
            nextKeyIndex = wordToExtract.indexOf(key, 0);
        }
        System.out.println(wordToExtract);
    }
}
