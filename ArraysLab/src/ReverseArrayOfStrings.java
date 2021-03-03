import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayOfStrings = scanner.nextLine().split("\\s+");

        for (int i = 0; i < arrayOfStrings.length / 2; i++) {
            String oldString = arrayOfStrings[i];
            arrayOfStrings[i] = arrayOfStrings[(arrayOfStrings.length - 1) - i];
            arrayOfStrings[(arrayOfStrings.length - 1) - i] = oldString;
        }
        System.out.println(String.join(" ", arrayOfStrings));
    }
}
