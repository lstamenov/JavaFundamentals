import java.util.*;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> playersPool = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Season end")){
            String[] data = input.split(" -> | vs ");
            if (input.contains("->")){
                String user = data[0];
                String userSkill = data[1];
                int skillPoints = Integer.parseInt(data[2]);

                if (playersPool.containsKey(user)){
                    Map<String, Integer> playerSkills = playersPool.get(user);
                    if (!playerSkills.containsKey(userSkill)){
                        playerSkills.put(userSkill, skillPoints);
                        playersPool.put(user, playerSkills);
                    }else {
                        if (playerSkills.get(userSkill) < skillPoints){
                            playerSkills.put(userSkill, skillPoints);
                            playersPool.put(user, playerSkills);
                        }
                    }
                }else {
                    Map<String, Integer> playerSkills = new TreeMap<>();
                    playerSkills.put(userSkill, skillPoints);
                    playersPool.put(user, playerSkills);
                }
            }else if (input.contains("vs")){
                String player1 = data[0];
                String player2 = data[1];

                if (playersPool.containsKey(player1) && playersPool.containsKey(player2)){
                    if (haveSkillsInCommon(player1, player2, playersPool).size() != 0){
                        if (getTotalCommonPoints(player1, playersPool, player2) > getTotalCommonPoints(player2, playersPool, player1)){
                            playersPool.remove(player2);
                        }else if (getTotalCommonPoints(player1, playersPool, player2) < getTotalCommonPoints(player2, playersPool, player1)){
                            playersPool.remove(player1);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        playersPool.entrySet().stream()
                .sorted((p1, p2) -> {
                    int totalPointsP1 = getTotalPoints(p1);
                    int totalPointsP2 = getTotalPoints(p2);

                    return Integer.compare(totalPointsP2, totalPointsP1);
                }).forEach(e -> {
            System.out.println(e.getKey() + ": " + getTotalPoints(e) + " skill");
            Map<String, Integer> skills = e.getValue();
            skills.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> System.out.printf("- %s <::> %d%n",entry.getKey(), entry.getValue()));
        });
    }

    private static int getTotalPoints(Map.Entry<String, Map<String, Integer>> p1) {
        int total = 0;
        Map<String, Integer> map = p1.getValue();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            total += e.getValue();
        }
        return total;
    }

    private static int getTotalCommonPoints(String player1, Map<String, Map<String, Integer>> playersPool, String player2) {
        int total = 0;
        List<Integer> listOfPoints = haveSkillsInCommon(player1, player2, playersPool);
        for (int p : listOfPoints) {
            total += p;
        }
        return total;
    }

    private static List<Integer> haveSkillsInCommon(String player1, String player2, Map<String, Map<String, Integer>> playersPool) {
        Map<String, Integer> player1Skills = playersPool.get(player1);
        Map<String, Integer> player2Skills = playersPool.get(player2);
        List<Integer> totalPoints = new ArrayList<>();
        for (Map.Entry<String, Integer> p1 : player1Skills.entrySet()) {
            for (Map.Entry<String, Integer> p2 : player2Skills.entrySet()) {
                if (p1.getKey().equals(p2.getKey())){
                    totalPoints.add(p1.getValue());
                }
            }
        }
        return totalPoints;
    }
}
