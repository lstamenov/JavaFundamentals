import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            if (getSum(i) != 0){
                System.out.println(i);
            }
        }
    }
    private static int getSum(int num) {
        boolean isOdd = false;
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
            if (sum % 2 != 0){
                isOdd = true;
            }
        }
        if (isOdd && sum % 8 == 0){
            return sum;
        }else {
            return 0;
        }
    }

}
