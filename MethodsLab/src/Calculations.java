import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case "subtract" -> System.out.println(subtract(a, b));
            case "divide" -> System.out.println(divide(a, b));
            case "add" -> System.out.println(add(a, b));
            case "multiply" -> System.out.println(multiply(a, b));
        }
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int divide(int a, int b) {
        return a/b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }
}
