import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int x = Integer.parseInt(scanner.nextLine());

        System.out.println(add(n, y) - x);
    }

    private static int add(int n, int y) {
        return n + y;
    }
}
