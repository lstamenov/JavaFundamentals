import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger bigInteger = BigInteger.ONE;
        int a = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= a; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigInteger);
    }
}
