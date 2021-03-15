import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sentence = scanner.nextLine().split("\\s+");
        Random random = new Random(sentence.length);

        for (int i = 0; i < sentence.length; i++) {
            int oldW = random.nextInt(sentence.length);
            int newW = random.nextInt(sentence.length);
            String oldWord = sentence[oldW];
            String newWord = sentence[newW];
            sentence[newW] = oldWord;
            sentence[oldW] = newWord;
        }
        for (String w : sentence) {
            System.out.println(w);
        }
    }
}
