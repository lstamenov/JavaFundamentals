import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        list = list.stream()
                .filter(integer -> integer >= 0)
                .collect(Collectors.toList());
        if (list.size() == 0){
            System.out.println("empty");
        }else {
            Collections.reverse(list);
            for (int n : list) {
                System.out.print(n + " ");
            }
        }
    }
}
