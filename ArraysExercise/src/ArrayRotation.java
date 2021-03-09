import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int firstNum = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = firstNum;
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
