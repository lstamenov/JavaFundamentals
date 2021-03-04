import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(?<user>[a-z]+[._-]*[a-z]+?[\\d+]*)@(?<host>[a-z]+[-]*[a-z]+\\.[a-z]+\\.*[a-z]+)";
        Pattern emailPattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher emailMatcher = emailPattern.matcher(input);

        while (emailMatcher.find()){
            System.out.println(emailMatcher.group());
        }

    }
}
