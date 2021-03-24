package PlantDiscovery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Plant> plants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("<->");
            String name = data[0];
            int rarity = Integer.parseInt(data[1]);
            Plant plant = new Plant(name, rarity);
            if (isSuchPlant(name, plants) != -1){
                int index = isSuchPlant(name, plants);
                plants.get(index).setRarity(rarity);
            }else {
              plants.add(plant);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")){
            String[] commands = input.split(": ");
            String command = commands[0];
            String commandData = commands[1];

            switch (command){
                case "Rate":
                    String[] data = commandData.split(" - ");
                    String plantName = data[0];
                    int rating = Integer.parseInt(data[1]);
                    if (isSuchPlant(plantName, plants) != -1){
                        int index = isSuchPlant(plantName, plants);
                        plants.get(index).rate(rating);
                    }else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    data = commandData.split(" - ");
                    plantName = data[0];
                    int rarity = Integer.parseInt(data[1]);
                    if (isSuchPlant(plantName, plants) != -1){
                        int index = isSuchPlant(plantName, plants);
                        plants.get(index).update(rarity);
                    }else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    data = commandData.split(" - ");
                    plantName = data[0];
                    if (isSuchPlant(plantName, plants) != -1){
                        int index = isSuchPlant(plantName, plants);
                        plants.get(index).reset();
                    }else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.stream()
                .sorted(Comparator.comparing(Plant::getRarity).reversed().thenComparing((e1, e2) -> Double.compare(Plant.getAverage(e2.getRatings()), Plant.getAverage(e1.getRatings()))))
                .forEach(plant -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",plant.getName(),
                        plant.getRarity(), Plant.getAverage(plant.getRatings())));
    }

    private static int isSuchPlant(String plant, List<Plant> plants) {
        for (Plant p : plants) {
            if (p.getName().equals(plant)){
                return plants.indexOf(p);
            }
        }
        return -1;
    }
}
