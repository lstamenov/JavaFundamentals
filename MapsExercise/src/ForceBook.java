import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> sidesData = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")){
            String[] data = input.split(" ");
            String splitter = data[1];
            if (splitter.equals("->")){

            }else if (splitter.equals("|")){
                String side = data[0];
                String user = data[2];

                List<String> users = sidesData.get(side);

                if (!users.contains(user)){
                    users.add(user);
                    sidesData.put(side, users);
                }
            }
            //method for finding and removing user
            input = scanner.nextLine();
        }
    }
}
