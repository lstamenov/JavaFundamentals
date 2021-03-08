import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new TreeMap<>();
        Map<String, Integer> userTotals = new TreeMap<>();
        Map<String, Map<String, Integer>> usersResults = new TreeMap<>();

        String contestInput = scanner.nextLine();

        while (!contestInput.equals("end of contests")){
            String[] contestData = contestInput.split(":");
            String contestName = contestData[0];
            String contestPassword = contestData[1];

            if (!contests.containsKey(contestName)){
                contests.put(contestName, contestPassword);
            }

            contestInput = scanner.nextLine();
        }

        String usersInput = scanner.nextLine();

        while (!usersInput.equals("end of submissions")){
            String[] userData = usersInput.split("=>");

            String contest = userData[0];
            String contestPassword = userData[1];
            String username = userData[2];
            int userPoints = Integer.parseInt(userData[3]);

            if (contests.containsKey(contest)){
                if (contests.get(contest).equals(contestPassword)){
                    userTotals.put(username, 0);
                    if (usersResults.get(username) != null) {
                        if (usersResults.get(username).containsKey(contest)) {
                            Map<String, Integer> currentUserResults = usersResults.get(username);
                            if (currentUserResults.get(contest) < userPoints) {
                                currentUserResults.put(contest, userPoints);
                                usersResults.put(username, currentUserResults);
                            }
                        } else {
                            Map<String, Integer> currentUserResults = usersResults.get(username);
                            currentUserResults.put(contest, userPoints);
                            usersResults.put(username, currentUserResults);
                        }
                    }else {
                        Map<String, Integer> currUserResults = new TreeMap<>();
                        currUserResults.put(contest, userPoints);
                        usersResults.put(username, currUserResults);
                    }
                }
            }
            usersInput = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> userTotal : userTotals.entrySet()) {
            int sum = getTotalPoints(usersResults.get(userTotal.getKey()));
            userTotals.put(userTotal.getKey(), sum);
        }
        userTotals.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(1)
                .forEach(e -> System.out.printf
                        ("Best candidate is %s with total %d points.%n",e.getKey(), e.getValue()));

        System.out.println("Ranking: ");
        usersResults.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey());
                    Map<String, Integer> userData = e.getValue();
                    userData.entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(eS -> System.out.printf("#  %s -> %d%n",eS.getKey(), eS.getValue()));
                });
    }

    private static int getTotalPoints(Map<String, Integer> map) {
        int sum = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            sum += e.getValue();
        }
        return sum;
    }
}
