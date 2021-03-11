import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        Pattern patternVowels = Pattern.compile("[AaEeIiOoUu]");
        Matcher vowelsMatcher = patternVowels.matcher(word);

        int count = 0;
        while (vowelsMatcher.find()){
            count++;
        }
        System.out.println(count);
    }
}
