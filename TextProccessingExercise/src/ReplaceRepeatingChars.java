import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sentence = new StringBuilder(scanner.nextLine());

        int count = 0;
        while (count < sentence.length()){
            if (isRepeated(sentence.charAt(count), sentence, count)){
                int counterEquals = count + 1;
                String subString = "";
                while (sentence.charAt(count) == sentence.charAt(counterEquals)){
                    subString += sentence.charAt(counterEquals);
                    counterEquals++;
                }
                sentence.replace(count + 1, counterEquals, "");
            }
            count++;
        }
        System.out.println(sentence.toString());
    }
    static boolean isRepeated(char charAt, StringBuilder sentence, int count){
        return charAt == sentence.charAt(count + 1);
    }
}
