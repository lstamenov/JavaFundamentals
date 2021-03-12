import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> gaussList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < gaussList.size() / 2; i++) {
            gaussList.set(i, gaussList.get(i) + gaussList.get((gaussList.size() - 1)));
            gaussList.remove((gaussList.size() - 1));
        }
        for (int n : gaussList) {
            System.out.print(n + " ");
        }
    }
}
