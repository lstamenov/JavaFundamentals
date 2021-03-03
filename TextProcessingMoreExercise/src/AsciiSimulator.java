import java.util.Scanner;

public class AsciiSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        String randomString = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < randomString.length(); i++) {
            if (isBetween(randomString.charAt(i), firstChar, secondChar)){
                sum += randomString.charAt(i);
            }
        }
        System.out.println(sum);
    }

    private static boolean isBetween(char charAt, char firstChar, char secondChar) {
        return charAt > firstChar && charAt < secondChar;
    }
}
