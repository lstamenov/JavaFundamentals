import java.util.*;
import java.util.stream.Collectors;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> sidesData = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")){
            List<String> data = Arrays.stream(input.split(" [|] | [\\-]> "))
                    .collect(Collectors.toList());

            if (input.contains("->")){
                String user = data.get(0);
                String side = data.get(data.size() - 1);

                if (removeIfContain(user, sidesData)){
                    List<String> users = sidesData.get(side);
                    users.add(user);
                    sidesData.put(side, users);
                    System.out.printf("%s joins the %s side!%n", user, side);
                }else {
                    System.out.printf("%s joins the %s side!%n", user, side);
                    List<String> users = sidesData.get(side);
                    if (users == null){
                        List<String> newUsersList = new ArrayList<>();
                        newUsersList.add(user);
                        sidesData.put(side, newUsersList);
                    }else {
                        users.add(user);
                        sidesData.put(side, users);
                    }
                }
            }else if (input.contains("|")){
                String side = data.get(0);
                String user = data.get(data.size() - 1);

                if (!containsUser(sidesData, user)) {
                    List<String> users = sidesData.get(side);
                    if (users != null) {
                        users.add(user);
                        sidesData.put(side, users);
                    }else {
                        List<String> newUsers = new ArrayList<>();
                        newUsers.add(user);
                        sidesData.put(side, newUsers);
                    }
                }
            }
            input = scanner.nextLine();
        }
        sidesData.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 0)
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n",e.getKey(), e.getValue().size());
                    Collections.sort(e.getValue());
                    for (String u : e.getValue()) {
                        System.out.println("! " + u);
                    }
                });
    }

    private static boolean removeIfContain(String user, Map<String, List<String>> sidesData) {
        for (Map.Entry<String, List<String>> e : sidesData.entrySet()) {
            for (int i = 0; i < e.getValue().size(); i++) {
                if (e.getValue().get(i).equals(user)){
                    e.getValue().remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsUser(Map<String, List<String>> sidesData, String user) {
        for (Map.Entry<String, List<String>> e : sidesData.entrySet()) {
            if (e.getValue().contains(user)){
                return true;
            }
        }
        return false;
    }
}
