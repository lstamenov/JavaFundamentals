import java.util.Scanner;

public class ReverseStringsFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("end")) {
            System.out.print(input + " = ");
            StringBuilder word = new StringBuilder(input);
            while (count <= word.length() / 2) {
                char currFirst = word.charAt(count);
                char currSecond = word.charAt((word.length() - 1) - count);
                word.setCharAt(count, currSecond);
                word.setCharAt((word.length() - 1) - count, currFirst);

                count++;
            }
            count = 0;
            input = word.toString();
            System.out.println(input);
            input = scanner.nextLine();
        }
    }
}
