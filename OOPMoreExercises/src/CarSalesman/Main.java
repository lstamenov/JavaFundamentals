package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            switch (engineData.length){
                case 2:
                    Engine engine = new Engine(model, power);
                    engines.add(engine);
                    break;
                case 3:
                    if (Character.isDigit(engineData[2].charAt(0))){
                        engine = new Engine(model, power);
                        engine.setDisplacement(engineData[2]);
                        engines.add(engine);
                    }else {
                        engine = new Engine(model, power);
                        engine.setEfficiency(engineData[2]);
                        engines.add(engine);
                    }
                    break;
                case 4:
                    engine = new Engine(model, power);
                    engine.setDisplacement(engineData[2]);
                    engine.setEfficiency(engineData[3]);
                    engines.add(engine);
                    break;
            }
        }

        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String engineName = carData[1];
            Engine engine = getEngine(engineName, engines);

            switch (carData.length){
                case 2:
                    Car car = new Car(model, engine);
                    cars.add(car);
                    break;
                case 3:
                    if (Character.isDigit(carData[2].charAt(0))){
                        car = new Car(model, engine);
                        car.setWeight(carData[2]);
                        cars.add(car);
                    }else {
                        car = new Car(model, engine);
                        car.setColor(carData[2]);
                        cars.add(car);
                    }
                    break;
                case 4:
                    car = new Car(model, engine);
                    car.setWeight(carData[2]);
                    car.setColor(carData[3]);
                    cars.add(car);
                    break;
            }
        }
        cars.forEach(car -> {
                    System.out.println(car.getModel() + ":");
                    System.out.println(car.getEngine().toString());
                    System.out.println("    Weight: " + car.getWeight());
                    System.out.println("    Color: " + car.getColor());
                });
    }

    private static Engine getEngine(String engineName, List<Engine> engines) {
        for (Engine e : engines) {
            if (e.getModel().equals(engineName)){
                return e;
            }
        }
        return null;
    }
}
