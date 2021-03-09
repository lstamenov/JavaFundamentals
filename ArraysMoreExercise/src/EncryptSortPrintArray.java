import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            int sum = encrypt(input);
            array[i] = sum;
        }
        Arrays.sort(array);

        for (int i = 0; i <= array.length - 1 ; i++) {
            System.out.println(array[i]);
        }
    }

    private static int encrypt(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input.charAt(i))){
                sum += input.charAt(i) * input.length();
            }else {
                sum += input.charAt(i) / input.length();
            }
        }
        return sum;
    }
    private static boolean isVowel(char input){
       return input == 'A' || input == 'a' || input == 'E' || input == 'e' ||
               input == 'I' || input == 'i' || input == 'O' || input == 'o' ||
               input == 'U' || input == 'u';
    }
}
