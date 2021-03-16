package TeamWorkProject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<User, Team> teamMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
                String[] createTeam = input.split("-");
                String creator = createTeam[0];
                String team = createTeam[1];


                if (!isExistingTeam(teamMap, team) && !isCreatorAlready(teamMap, creator)){
                    List<User> users = new ArrayList<>();
                    Team teamUsers = new Team(users, team);
                    User userCreator = new User(creator);
                    teamMap.put(userCreator, teamUsers);
                    System.out.printf("Team %s has been created by %s!%n",team, creator);
                }else {
                    if (isExistingTeam(teamMap, team)){
                        System.out.printf("Team %s was already created!%n",team);
                    }
                    if (isCreatorAlready(teamMap, creator)){
                        System.out.printf("%s cannot create another team!%n",creator);
                    }
                }
        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")){

            String[] joinTeam = input.split("->");

            String user = joinTeam[0];
            String team = joinTeam[1];

            if (isExistingTeam(teamMap, team) && !isCreatorAlready(teamMap, user)
                    && !isMemberAlready(teamMap, user)){
                User creator = getTeam(teamMap, team);
                Team teamCreatedByCreator = teamMap.get(creator);
                List<User> newAddedUsers = teamCreatedByCreator.getUsers();
                User newMember = new User(user);
                newAddedUsers.add(newMember);
                teamCreatedByCreator.setUsers(newAddedUsers);
                teamMap.put(creator, teamCreatedByCreator);
            }else {
                if (!isExistingTeam(teamMap, team)){
                    System.out.printf("Team %s does not exist!%n",team);
                }
                if (isCreatorAlready(teamMap, user) || isMemberAlready(teamMap, user)){
                    System.out.printf("Member %s cannot join team %s!%n",user, team);
                }
            }

            input = scanner.nextLine();
        }

        teamMap.entrySet().stream()
                .filter(userTeamEntry -> userTeamEntry.getValue().getUsers().size() > 0)
                .sorted(Comparator.comparing(e -> e.getKey().getName()))
                .forEach(userTeamEntry -> {
                    System.out.println(userTeamEntry.getValue().getName());
                    System.out.println("- " + userTeamEntry.getKey().getName());
                    for (User u : userTeamEntry.getValue().getUsers()) {
                        System.out.println("-- " + u.getName());
                    }
                });
        System.out.println("Teams to disband:");
        teamMap.entrySet().stream()
                .filter(userTeamEntry -> userTeamEntry.getValue().getUsers().size() < 1)
                .sorted(Comparator.comparing(e -> e.getKey().getName()))
                .forEach(userTeamEntry -> System.out.println(userTeamEntry.getValue().getName()));
    }

    private static User getTeam(Map<User, Team> teamMap, String team) {
        for (Map.Entry<User, Team> t : teamMap.entrySet()) {
            if (t.getValue().getName().equals(team)){
                return t.getKey();
            }
        }
        return null;
    }

    private static boolean isMemberAlready(Map<User, Team> teamMap, String user) {
        for (Map.Entry<User, Team> e: teamMap.entrySet()) {
            for (User u : e.getValue().getUsers()) {
                if (u.getName().equals(user)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCreatorAlready(Map<User, Team> teamMap, String creator) {
        for (Map.Entry<User, Team> e : teamMap.entrySet()) {
            if (e.getKey().getName().equals(creator)){
                return true;
            }
        }
        return false;
    }

    private static boolean isExistingTeam(Map<User, Team> teamMap, String team) {
        for (Map.Entry<User, Team> t : teamMap.entrySet()) {
            if (t.getValue().getName().equals(team)){
                return true;
            }
        }
        return false;
    }
}
