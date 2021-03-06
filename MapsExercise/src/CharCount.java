import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (!charCount.containsKey(text.charAt(i))&& text.charAt(i) != ' '){
                charCount.put(text.charAt(i), 1);
            }else if (charCount.containsKey(text.charAt(i)) && text.charAt(i) != ' '){
                charCount.put(text.charAt(i), charCount.get(text.charAt(i)) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() +" -> "+ entry.getValue());
        }
    }
}
