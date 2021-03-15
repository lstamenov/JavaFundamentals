package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] vehicleData = input.split("\\s+");
            String type = vehicleData[0];
            String model = vehicleData[1];
            String colour = vehicleData[2];
            int horsepower = Integer.parseInt(vehicleData[3]);

            if (type.equals("car")){
                if (vehicle.getCars() != null) {
                    List<Car> cars = vehicle.getCars();
                    Car car = new Car(model, colour, horsepower);
                    cars.add(car);
                    vehicle.setCars(cars);
                }else {
                    List<Car> cars = new ArrayList<>();
                    Car car = new Car(model, colour, horsepower);
                    cars.add(car);
                    vehicle.setCars(cars);
                }
            }else if (type.equals("truck")){
                if (vehicle.getTrucks() != null) {
                    Truck truck = new Truck(model, colour, horsepower);
                    List<Truck> trucks = vehicle.getTrucks();
                    trucks.add(truck);
                    vehicle.setTrucks(trucks);
                }else {
                    Truck truck = new Truck(model, colour, horsepower);
                    List<Truck> trucks = new ArrayList<>();
                    trucks.add(truck);
                    vehicle.setTrucks(trucks);
                }
            }

            input = scanner.nextLine();
        }

        String model = scanner.nextLine();
        List<Car> cars = vehicle.getCars();
        List<Truck> trucks = vehicle.getTrucks();

        while (!model.equals("Close the Catalogue")){

            for (Truck t : trucks) {
                if (t.getModel().equals(model)){
                    System.out.println(t.printModel());
                }
            }
            for (Car c : cars) {
                if (c.getModel().equals(model)){
                    System.out.println(c.printModel());
                }
            }
            model = scanner.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", vehicle.getCarAverage());
        System.out.printf("Trucks have average horsepower of: %.2f.%n", vehicle.getTruckAverage());
    }
}
