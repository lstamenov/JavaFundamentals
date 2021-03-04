import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> participantsData = new LinkedHashMap<>();

        Pattern namePattern = Pattern.compile("[A-Za-z]");
        Pattern distancePattern = Pattern.compile("[0-9]");
        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            Matcher nameMatcher = namePattern.matcher(input);
            Matcher distanceMatcher = distancePattern.matcher(input);
            String name = "";
            int distance = 0;

            while (nameMatcher.find()){
                name += nameMatcher.group();
            }
            while (distanceMatcher.find()){
                distance += Integer.parseInt(distanceMatcher.group());
            }

            if (names.contains(name)){
                if (participantsData.containsKey(name)){
                    int newDistance = participantsData.get(name) + distance;
                    participantsData.put(name, newDistance);
                }else {
                    participantsData.put(name, distance);
                }
            }
            input = scanner.nextLine();
        }
        int[] i = {1};
        participantsData.entrySet().stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .limit(3)
                .forEach(p -> {
                    switch (i[0]){
                        case 1 :
                            System.out.printf("1st place: %s",p.getKey());
                            break;
                        case 2 :
                            System.out.printf("2nd place: %s",p.getKey());
                            break;
                        case 3 :
                            System.out.printf("3rd place: %s", p.getKey());
                            break;
                    }
                    System.out.println();
                    i[0]++;
                });
    }
}
