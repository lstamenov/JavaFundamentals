import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int asciiDecryptNumber = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            StringBuilder decryptedText = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                decryptedText.append((char)(input.charAt(i) - asciiDecryptNumber));
            }

            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behave>[G])!");
            Matcher matcher = pattern.matcher(decryptedText);

            while (matcher.find()){
                String name = matcher.group("name");
                String behavior = matcher.group("behave");

                if (behavior.equals("G")){
                    System.out.println(name);
                }
            }


            input = scanner.nextLine();
        }
    }
}
