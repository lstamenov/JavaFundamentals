import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            products.add(product);
        }
        products = products.stream()
                .sorted(String::compareTo).collect(Collectors.toList());

        List<String> finalProducts = products;
        products.stream()
                .forEach(s -> {
                    System.out.printf("%d.%s%n", finalProducts.indexOf(s) + 1, s);
                });;
    }
}
