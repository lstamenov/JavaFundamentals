import java.util.*;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
       List<Map<String, String>> listOfTreasures = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("find")){
            StringBuilder decrypted = new StringBuilder(input);
            int keyCounter = 0;
            int messageCounter = 0;

            while (messageCounter < decrypted.length()){
                decrypted.setCharAt(messageCounter,
                        (char) (decrypted.charAt(messageCounter) - key[keyCounter]));
                keyCounter++;
                messageCounter++;
                if (keyCounter == key.length){
                    keyCounter = 0;
                }
            }

            String treasure = getTreasure(decrypted);
            String coordinates = getCoordinates(decrypted);
            Map<String, String> treasures = new LinkedHashMap<>();
            treasures.put(treasure, coordinates);
            listOfTreasures.add(treasures);

            input = scanner.nextLine();
        }
        for (Map<String, String> entry : listOfTreasures) {
            for (Map.Entry<String, String> entry1 : entry.entrySet()) {
                System.out.printf("Found %s at %s%n",entry1.getKey(), entry1.getValue());
            }
        }
    }

    private static String getCoordinates(StringBuilder decrypted) {
        StringBuilder coordinates = new StringBuilder();

        for (int i = 0; i < decrypted.length(); i++) {
            if (decrypted.charAt(i) == '<'){
                int count = i + 1;
                while (decrypted.charAt(count) != '>'){
                    coordinates.append(decrypted.charAt(count));
                    count++;
                }
            }
        }
        return coordinates.toString();
    }

    private static String getTreasure(StringBuilder decrypted) {
        StringBuilder treasure = new StringBuilder();

        for (int i = 0; i < decrypted.length(); i++) {
            if (decrypted.charAt(i) == '&'){
                int count = i + 1;
                while (decrypted.charAt(count) != '&'){
                    treasure.append(decrypted.charAt(count));
                    count++;
                }
                break;
            }
        }
        return treasure.toString();
    }
}
