import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(isPalindrome(number));
    }

    private static boolean isPalindrome(int number) {
        int palindrome = 0;
        int n = number;

        while (number > 10){
            palindrome += number % 10;
            palindrome *= 10;
            number /= 10;
        }
        palindrome += number;
        return palindrome == n;
    }
}
