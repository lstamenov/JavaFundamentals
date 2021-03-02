import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        for (String word:words) {
            String newWord = repeat(word);
            System.out.print(newWord);
        }


    }
    static String repeat(String word){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }
}
