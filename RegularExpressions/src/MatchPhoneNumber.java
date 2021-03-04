import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = "\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}\\b";
        String text = scanner.nextLine();
        List<String> listOfNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
           listOfNumbers.add(matcher.group());
        }
        System.out.println(String.join(", ", listOfNumbers));
    }
}
