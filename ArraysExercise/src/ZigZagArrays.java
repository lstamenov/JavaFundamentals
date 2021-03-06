import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            if (i % 2 == 0){
                firstArray[i] = nums[0];
                secondArray[i] = nums[1];
            }else {
                secondArray[i] = nums[0];
                firstArray[i] = nums[1];
            }
        }

        for (int number : firstArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : secondArray) {
            System.out.print(number + " ");
        }
    }
}
