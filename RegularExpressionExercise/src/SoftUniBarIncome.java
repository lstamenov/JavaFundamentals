import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = "%(?<name>[A-Z][a-z]+)%[^|.%$]*<(?<product>[\\w]+)>[^|.%$]*\\|(?<quantity>[\\d]+)\\|[^|.%$]*?(?<price>\\d+\\.?\\d*)\\$";
        String input = scanner.nextLine();
        double totalSum = 0;
        Pattern pattern = Pattern.compile(expression);


        while (!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                totalSum += price * quantity;

                System.out.printf("%s: %s - %.2f%n",name, product, price * quantity);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalSum);
    }
}
