import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int biggestCount = 0;
        int number = 0;

        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (count != 0 && j == array.length - 1 && array[i] == array[j]){
                    count++;
                    if (count > biggestCount){
                        biggestCount = count;
                        number = array[i];
                    }
                    break;
                }
                if (array[i] == array[j]){
                    count++;
                }else {
                    if (count > biggestCount){
                        biggestCount = count;
                        number = array[i];
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < biggestCount; i++) {
            System.out.print(number + " ");
        }
    }
}
