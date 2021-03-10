import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int evens = getEvenSum(input);
        int odds = getOddsSum(input);

        System.out.println(evens * odds);
    }

    private static int getOddsSum(int input) {
        int sum = 0;
        while (input > 10) {
            int n = input % 10;
            if (n % 2 != 0) {
                sum += n;
            }
            input /= 10;
        }
        if (input % 2 != 0){
            sum += input;
        }
        return sum;
    }

    private static int getEvenSum(int input) {
        int sum = 0;
        while (input > 10){
            int n  = input % 10;
            if (n % 2 == 0){
                sum += n;
            }
            input /= 10;
        }
        if (input % 2 == 0){
            sum += input;
        }
        return sum;
    }
}
