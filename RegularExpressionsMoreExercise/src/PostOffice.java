import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] groups = input.split("\\|");

        String firstGroup = groups[0];
        String secondGroup = groups[1];
        String thirdGroup = groups[2];

        String capitalLetters = "";
        Pattern capitalLettersPattern = Pattern.compile("([#%$*&])(?<letters>[A-Z]+)\\1");
        Matcher capitalLettersMatcher = capitalLettersPattern.matcher(firstGroup);

        while (capitalLettersMatcher.find()){
            capitalLetters = capitalLettersMatcher.group("letters");
        }

        Map<Character, Integer> words = new LinkedHashMap<>();
        Pattern wordPattern = Pattern.compile("(?<char>\\d+):(?<length>[0-9]{2})");
        Matcher wordMatcher = wordPattern.matcher(secondGroup);

        while (wordMatcher.find()){
            int asciiCodeChar = Integer.parseInt((wordMatcher.group("char")));
            char c = (char) asciiCodeChar;
            int length = Integer.parseInt(wordMatcher.group("length"));
            if (contains(asciiCodeChar, capitalLetters)){
                words.put(c, length + 1);
            }
        }

        String[] wordsToCheck = thirdGroup.split("\\s+");

        for (String word : wordsToCheck) {
            for (Map.Entry<Character, Integer> e : words.entrySet()) {
                if (word.charAt(0) == e.getKey()){
                    if (word.length() == e.getValue()){
                        System.out.println(word);
                    }
                }
            }
        }
    }

    private static boolean contains(int asciiCodeChar, String capitalLetters) {
        for (int i = 0; i < capitalLetters.length(); i++) {
            if (capitalLetters.charAt(i) == (char) asciiCodeChar){
                return true;
            }
        }
        return false;
    }
}
