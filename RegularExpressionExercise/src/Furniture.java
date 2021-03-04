import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = "^>+(?<name>[A-Za-z]+)[<]{2}(?<price>\\d+.\\d+)+!(?<quantity>\\d+)\\b";
        Pattern pattern = Pattern.compile(expression);
        List<String> names = new ArrayList<>();
        double totalSum = 0;
        String input = scanner.nextLine();
        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalSum += price * quantity;
                names.add(matcher.group("name"));
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
