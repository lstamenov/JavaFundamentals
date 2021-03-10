import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double b = Double.parseDouble(scanner.nextLine());
        switch (input) {
            case "-" -> System.out.println(subtract(a, b));
            case "/" -> System.out.println(divide(a, b));
            case "+" -> System.out.println(add(a, b));
            case "*" -> System.out.println(multiply(a, b));
        }
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double divide(double a, double b) {
        return a/b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }
}
