
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String[] stringArray = string.split("\\|");
        List<Integer> finalList = new ArrayList<>();

        for (int i = stringArray.length - 1 ; i >= 0; i--) {
            int[] arrayIntegers = Arrays.stream(stringArray[i].trim().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int arrayInteger : arrayIntegers) {
                finalList.add(arrayInteger);
            }
        }

        for (int n : finalList) {
            System.out.print(n + " ");
        }
    }
}

