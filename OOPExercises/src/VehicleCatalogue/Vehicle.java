package VehicleCatalogue;

import java.util.List;

public class Vehicle {
    String type;
    List<Car> cars;
    List<Truck> trucks;

    public String getType() {
        return type;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public double getCarAverage() {
        return averageHPCars(cars);
    }

    public double getTruckAverage() {
        return averageHPTrucks(trucks);
    }

    public static double averageHPCars(List<Car> cars){
        double sum = 0;
        for (Car c : cars) {
            sum += c.getHorsePower();
        }
        return sum / cars.size();
    }

    public static double averageHPTrucks(List<Truck> trucks){
        double sum = 0;
        for (Truck c : trucks) {
            sum += c.getHorsePower();
        }
        return sum / trucks.size();
    }
}
