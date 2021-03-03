import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int[] condensedArray = new int[(array.length - 1)];
            for (int j = 0; j < condensedArray.length; j++) {
                condensedArray[j] = array[j] + array[j + 1];
            }
            array = condensedArray;
        }
        System.out.println(array[0]);
    }
}
