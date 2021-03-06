import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (isElementObtained(keyMaterials)){
            String input = scanner.nextLine();
            String[] materialsData = input.split("\\s+");
            int count  = 0;
            while (count < materialsData.length){
                int quantity = Integer.parseInt(materialsData[count]);
                String material = materialsData[count + 1];

                material = material.toLowerCase();
                if (material.equals("shards") || material.equals("motes")
                        || material.equals("fragments")){
                    if (keyMaterials.containsKey(material)){
                        keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    }else {
                        keyMaterials.put(material, quantity);
                    }
                    if (!isElementObtained(keyMaterials)){
                        break;
                    }
                }else {
                    if (junkMaterials.containsKey(material)){
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                    }else {
                        junkMaterials.put(material, quantity);
                    }
                }
                count += 2;
            }

        }
        System.out.println(getObtainedElement(keyMaterials) + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMaterials.forEach((key, value) -> System.out.println(key + ": " + value));

    }
    static boolean isElementObtained(Map<String, Integer> keyMaterials){
        for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
            if (entry.getValue() >= 250){
                return false;
            }
        }
        return true;
    }
    private static String getObtainedElement(Map<String, Integer> keyMaterials){
        String element = "";
        for (Map.Entry<String, Integer> e : keyMaterials.entrySet()) {
            if (e.getValue() >= 250 && e.getKey().equals("motes")){
                element = "Dragonwrath";
                keyMaterials.put(e.getKey(), e.getValue() - 250);
                break;
            }else if (e.getValue() >= 250 && e.getKey().equals("shards")){
                element = "Shadowmourne";
                keyMaterials.put(e.getKey(), e.getValue() - 250);
                break;
            }else if (e.getValue() >= 250 && e.getKey().equals("fragments")){
                element = "Valanyr";
                keyMaterials.put(e.getKey(), e.getValue() - 250);
                break;
            }
        }
        return element;
    }

}
