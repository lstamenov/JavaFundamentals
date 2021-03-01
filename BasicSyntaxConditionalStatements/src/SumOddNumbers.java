import java.util.Scanner;

public class SumOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int counter = 0;
        for (int i = 1; i <100; i+=2) {
            sum += i;

            counter++;
            System.out.printf("%d%n",i);
            if (counter==n){
                break;
            }

        }
        System.out.printf("Sum: %d%n", sum);

    }
}
