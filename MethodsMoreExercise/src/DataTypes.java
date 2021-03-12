import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String dataTypeAsString = scanner.nextLine();

        method(type, dataTypeAsString);
    }

    private static void method(String type, String dataTypeAsString) {
        switch (type) {
            case "int" -> System.out.println(Integer.parseInt(dataTypeAsString) * 2);
            case "real" -> System.out.printf("%.2f", Double.parseDouble(dataTypeAsString) * 1.5);
            case "string" -> {
                String newString = "$";
                for (int i = 0; i < dataTypeAsString.length(); i++) {
                    newString += dataTypeAsString.charAt(i);
                    if (i == dataTypeAsString.length() - 1) {
                        newString += "$";
                    }
                }
                System.out.println(newString);
            }
        }
    }
}
