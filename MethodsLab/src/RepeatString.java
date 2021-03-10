import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        repeat(string, n);
    }

    private static void repeat(String string, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(string);
        }
    }
}
