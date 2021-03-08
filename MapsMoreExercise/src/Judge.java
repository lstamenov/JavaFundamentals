import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contestResults = new LinkedHashMap<>();
        Map<String, Integer> usersTotalPoints = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("no more time")){
            String[] data = input.split(" *-> *");

            String username = data[0];
            String contest = data[1];
            int points = Integer.parseInt(data[2]);

            if (contestResults.containsKey(contest)){
                Map<String, Integer> currentContest = contestResults.get(contest);
                if (currentContest.containsKey(username)){
                    if (currentContest.get(username) < points){
                        currentContest.put(username, points);
                        contestResults.put(contest, currentContest);
                    }
                }else {
                    currentContest.put(username, points);
                    contestResults.put(contest, currentContest);
                }
            }else {
                Map<String, Integer> userResult = new LinkedHashMap<>();
                userResult.put(username, points);
                contestResults.put(contest, userResult);
            }
            usersTotalPoints.put(username, 0);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> totalEntry : usersTotalPoints.entrySet()) {
            int sum = getTotalPoint(totalEntry.getKey(), contestResults);
            usersTotalPoints.put(totalEntry.getKey(), sum);
        }

        int[] count = {1};
        contestResults.entrySet().stream()
                .sorted((e2, e1) -> {
                    int sort = Integer.compare(e1.getValue().size(), e2.getValue().size());
                    if (sort == 0){
                        sort = e2.getKey().compareTo(e1.getKey());
                    }
                    return sort;
                })
                .forEach(e -> {
                    System.out.printf("%s: %d participants%n",e.getKey(), e.getValue().size());
                    Map<String, Integer> usersDetails = e.getValue();

                    usersDetails.entrySet().stream()
                            .sorted((e1, e2) -> {
                                int sort = e2.getValue().compareTo(e1.getValue());
                                if (sort == 0){
                                    sort = e2.getKey().compareTo(e1.getKey());
                                }
                                return sort;
                            })
                            .forEach(e3 -> {
                                System.out.printf("%d. %s <::> %d%n",count[0],e3.getKey(), e3.getValue());
                                count[0]++;
                            });
                    count[0] = 1;
                });

        System.out.println("Individual standings:");
        usersTotalPoints.entrySet().stream()
                .sorted((e2, e1) -> {
                    int sort = Integer.compare(e1.getValue(),e2.getValue());
                    if (sort == 0){
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(e -> {
                    System.out.printf("%d. %s -> %d%n",count[0] ,e.getKey(), e.getValue());
                    count[0]++;
                });

    }

    private static int getTotalPoint(String key, Map<String, Map<String, Integer>> contestResults) {
        int sum = 0;
        for (Map.Entry<String, Map<String, Integer>> e : contestResults.entrySet()) {
            Map<String, Integer> contest = contestResults.get(e.getKey());
            for (Map.Entry<String, Integer> e1 : contest.entrySet()) {
                if (e1.getKey().equals(key)){
                    sum += e1.getValue();
                }
            }
        }
        return sum;
    }
}
