import java.util.Scanner;

public class ReverseStringSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        while (!word.equals("end")){
            String newWord = "";

            for (int i = word.length() - 1; i >= 0 ; i--) {
                newWord += word.charAt(i);
            }
            System.out.printf("%s = %s%n", word, newWord);
            word = scanner.nextLine();
        }
    }
}
