import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        String regex = "[^@!:-]*@(?<name>[A-Za-z]+)[^@!:-]*:(?<population>\\d+)[^@!:-]*!(?<type>A|D)![^@!:-]*->(?<soldiers>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            int countStar = getCount(input);
            input = decreaseChars(input, countStar);

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                if (matcher.group("type").equals("A")){
                    attackedPlanets.add(matcher.group("name"));
                }else if (matcher.group("type").equals("D")){
                    destroyedPlanets.add(matcher.group("name"));
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.println("Attacked planets: " + attackedPlanets.size());
        for (String planet : attackedPlanets) {
            System.out.printf("-> %s%n", planet);
        }
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        for (String planet : destroyedPlanets) {
            System.out.printf("-> %s%n", planet);
        }
    }

    private static String decreaseChars(String input, int countStar) {
        StringBuilder stringBuilder = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {
            stringBuilder.setCharAt(i, (char) (input.charAt(i) - countStar));
        }
        return stringBuilder.toString();
    }

    private static int getCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A' || input.charAt(i) == 'a' || input.charAt(i) == 'S' ||
                    input.charAt(i) == 's' || input.charAt(i) == 'T' || input.charAt(i) == 't' ||
                    input.charAt(i) == 'R' || input.charAt(i) == 'r'){
                count++;
            }
        }
        return count;
    }
}
