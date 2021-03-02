import java.util.Scanner;

public class CharacterMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        String firstWord = words[0];
        String secondWord = words[1];

        if (firstWord.length() > secondWord.length()){
            int sum = multiply(firstWord, secondWord);
            System.out.println(sum);
        }else if (firstWord.length() < secondWord.length()){
            int sum = multiply(secondWord, firstWord);
            System.out.println(sum);
        }else {
            int sum = 0;
            for (int i = 0; i < secondWord.length(); i++) {
                sum += firstWord.charAt(i) * secondWord.charAt(i);
            }
            System.out.println(sum);
        }
    }

    private static int multiply(String firstWord, String secondWord) {
        int sum = 0;
        for (int i = 0; i < secondWord.length(); i++) {
            sum += firstWord.charAt(i) * secondWord.charAt(i);
        }
        for (int i = secondWord.length(); i < firstWord.length(); i++) {
            sum += firstWord.charAt(i);
        }
        return sum;
    }
}
