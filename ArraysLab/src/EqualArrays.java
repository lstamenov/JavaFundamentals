import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int indexDifference = -1;
        int sum = 0;

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]){
                indexDifference = i;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }else {
                sum += secondArray[i];
            }
        }
        if (indexDifference == -1){
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
