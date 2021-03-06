import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mine = new LinkedHashMap<>();

        String material = scanner.nextLine();
        while (!material.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!mine.containsKey(material)){
                mine.put(material, quantity);
            }else {
                mine.put(material, mine.get(material) + quantity);
            }
            material = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> e : mine.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
