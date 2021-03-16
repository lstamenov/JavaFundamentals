package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire[] tires = getTires(tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String type = scanner.nextLine();

        if (type.equals("fragile")){
            for (Car car : cars) {
                if (isLow(car.getTires()) && car.getCargo().getType().equals("fragile")){
                    System.out.println(car.getModel());
                }
            }
        }else if (type.equals("flamable")){
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }

    private static boolean isLow(Tire[] tires) {
        for (Tire tire : tires) {
            if (tire.getPressure() < 1){
                return true;
            }
        }
        return false;
    }

    private static Tire[] getTires(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        Tire[] tires = new Tire[4];

        Tire tire1 = new Tire(tire1Pressure, tire1Age);
        Tire tire2 = new Tire(tire2Pressure, tire2Age);
        Tire tire3 = new Tire(tire3Pressure, tire3Age);
        Tire tire4 = new Tire(tire4Pressure, tire4Age);

        tires[0] = tire1;
        tires[1] = tire2;
        tires[2] = tire3;
        tires[3] = tire4;

        return tires;
    }
}
