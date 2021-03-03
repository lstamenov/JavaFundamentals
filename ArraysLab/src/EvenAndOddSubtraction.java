import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int even = 0;
        int odd = 0;

        for (int n : arrayOfNumbers) {
            if (n % 2 == 0){
                even += n;
            }else {
                odd += n;
            }
        }

        System.out.println(even - odd);
    }
}
