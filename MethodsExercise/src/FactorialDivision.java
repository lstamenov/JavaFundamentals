import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());

        double firstFactorial = factorial(firstNumber);
        double secondFactorial = factorial(secondNumber);

        System.out.printf("%.2f",firstFactorial / secondFactorial);
    }

    private static double factorial(double firstNumber) {
        int factorial = 1;
        for (int i = 1; i <= firstNumber; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
