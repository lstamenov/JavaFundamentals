import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int longestCount = 0;
        int[] winningArray = new int[1];

        while (count < array.length){
            int[] array1 = new int[2];
            for (int i = count; i < array.length; i++) {
                int counter = 0;
                for (int j = count + 1; j < array.length; j++) {
                    if (array[i] < array[j]){
                        if (counter == 0){
                            array1[0] = array[i];
                            array1[1] = array[j];
                            counter++;
                        }else {
                            int[] newArr = new int[array1.length + 1];
                            for (int k = 0; k < array1.length; k++) {
                                newArr[k] = array1[k];
                            }
                            newArr[newArr.length - 1] = array[j];
                            array1 = newArr;
                            i = j;
                        }
                    }else if (counter == array.length){
                        break;
                    }
                }
            }
            count++;
        }
    }
}
