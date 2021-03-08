import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> usersResults = new TreeMap<>();
        Map<String, Integer> languagesStatistics = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")){
            String[] data = input.split("-");

            String user = data[0];
            if (data.length == 2){
                usersResults.remove(user);
            }else {
                String language = data[1];
                int userPoints = Integer.parseInt(data[2]);
                if (!languagesStatistics.containsKey(language)){
                    usersResults.put(user, userPoints);
                    languagesStatistics.put(language, 1);
                }else {
                    if (!usersResults.containsKey(user)) {
                        usersResults.put(user, userPoints);
                    }else {
                        if (userPoints > usersResults.get(user)){
                            usersResults.put(user, userPoints);
                        }
                    }
                    languagesStatistics.put(language, languagesStatistics.get(language) + 1);
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");

        usersResults.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s | %d%n",e.getKey(), e.getValue()));

        System.out.println("Submissions:");

        languagesStatistics.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n",e.getKey(), e.getValue()));
    }
}
