import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words1 = scanner.nextLine().split("\\s+");
        String[] words2 = scanner.nextLine().split("\\s+");

        for (String s : words2) {
            for (String value : words1) {
                if (s.equals(value)) {
                    System.out.print(s + " ");
                }
            }
        }
    }
}
