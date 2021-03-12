import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (thereIsEqualNumbers(integerList)){
            for (int i = 0; i < integerList.size() -1; i++) {
                if (integerList.get(i).equals(integerList.get(i + 1))){
                    integerList.set(i, integerList.get(i) * 2);
                    integerList.remove(i + 1);

                }
            }
        }
        for (int n : integerList) {
            System.out.print(n + " ");
        }
    }

    private static boolean thereIsEqualNumbers(List<Integer> integerList) {
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i).equals(integerList.get(i + 1))){
                return true;
            }
        }
        return false;
    }
}
