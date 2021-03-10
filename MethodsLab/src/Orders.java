import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case "coffee" -> System.out.println(sum(count, 1.50));
            case "water" -> System.out.println(sum(count, 1.00));
            case "coke" -> System.out.println(sum(count, 1.40));
            case "snacks" -> System.out.println(sum(count, 2.00));
        }
    }

    private static double sum(int count, double v) {
        return count * v;
    }
}
