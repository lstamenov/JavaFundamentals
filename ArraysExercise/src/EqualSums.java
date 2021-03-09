import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        boolean areEqual = false;

        if (array.length != 1) {
            for (int i = 1; i < array.length - 1; i++) {
                int leftSum = getSum(0, i - 1, array);
                int rightSum = getSum(i + 1, array.length - 1, array);
                if (leftSum == rightSum) {
                    System.out.println(i);
                    areEqual = true;
                    break;
                }
            }
        }else {
            System.out.println("0");
            areEqual = true;
        }
        if (!areEqual){
            System.out.println("no");
        }
    }

    private static int getSum(int i, int i1, int[] array) {
        int sum = 0;
        for (int j = i; j <= i1 ; j++) {
            sum += array[j];
        }
        return sum;
    }
}
