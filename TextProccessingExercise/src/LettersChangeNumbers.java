import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArray = scanner.nextLine().split("\\s+");
        double totalSum = 0;
        List<Character> upperAlphabet = new ArrayList<>();
        List<Character> lowerAlphabet = new ArrayList<>();

        for (int i = 65; i < 91; i++) {
            upperAlphabet.add((char) i);
        }
        for (int i = 97; i < 123; i++) {
            lowerAlphabet.add((char) i);
        }


        for (String word : wordsArray) {
            double subSum = 0;
            int number = getNumber(word);
            int count = 0;
            while (count < word.length()){
                if (count == 0){
                    if (upperAlphabet.contains(word.charAt(0))){
                        subSum += 1.0 * number / (upperAlphabet.indexOf(word.charAt(0)) + 1);
                    }else {
                        subSum += number * (lowerAlphabet.indexOf(word.charAt(0)) + 1);
                    }
                }else if (count == word.length() - 1){
                    if (upperAlphabet.contains(word.charAt(word.length() - 1))){
                        subSum -= (upperAlphabet.indexOf(word.charAt(word.length() - 1)) + 1);
                    }else {
                        subSum += (lowerAlphabet.indexOf(word.charAt(word.length() - 1)) + 1);
                    }
                }
                count++;
            }
            totalSum += subSum;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static int getNumber(String word) {
        String numberAsString = "";
        for (int i = 1; i < word.length() - 1; i++) {
            numberAsString += word.charAt(i);
        }
        return Integer.parseInt(numberAsString);
    }
}
