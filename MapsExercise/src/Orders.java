import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> products = new LinkedHashMap<>();
        Map<String, Double> oldProductsPrices = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")){
            String[] productData = input.split("\\s+");
            String product = productData[0];
            double price = Double.parseDouble(productData[1]);
            int quantity = Integer.parseInt(productData[2]);

            if (products.containsKey(product)){
                int oldQuantity = (int) (products.get(product) / oldProductsPrices.get(product));
                quantity += oldQuantity;
                double totalPrice =  quantity * price;
                products.put(product, totalPrice);
                oldProductsPrices.put(product, price);
            }else {
                double totalPrice = quantity * price;
                oldProductsPrices.put(product, price);
                products.put(product, totalPrice);
            }

            input = scanner.nextLine();
        }
        products.entrySet().forEach(e -> System.out.printf("%s -> %.2f%n",e.getKey() ,e.getValue()));
    }
}
