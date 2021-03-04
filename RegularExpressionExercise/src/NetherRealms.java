import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> demonNames = Arrays.stream(scanner.nextLine().split("[,\\s]+"))
                .sorted().collect(Collectors.toList());

        for (int i = 0; i < demonNames.size(); i++) {
            String name = demonNames.get(i);
            int health = getHealth(name);
            double damage = getDamage(name);

            System.out.printf("%s - %d health, %.2f damage%n",name, health, damage);
        }

    }

    private static double getDamage(String name) {
        String regex = "-?\\d+\\.?[\\d+]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        double sum = 0;
        while (matcher.find()){
            sum += Double.parseDouble(matcher.group());
        }

        Pattern patternD = Pattern.compile("[/]");
        Pattern patternM = Pattern.compile("[*]");
        Matcher matcherD = patternD.matcher(name);
        Matcher matcherM = patternM.matcher(name);

        while (matcherD.find()){
            sum /= 2;
        }
        while (matcherM.find()){
            sum *= 2;
        }
        return sum;
    }

    private static int getHealth(String name) {
        String regex = "[^\\d.*+\\-/]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        int health = 0;
        String healthChars = "";
        while (matcher.find()){
            healthChars += matcher.group();
        }
        for (int i = 0; i < healthChars.length(); i++) {
            health += healthChars.charAt(i);
        }
        return health;
    }
}
