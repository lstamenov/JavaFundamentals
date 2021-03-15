package CarSalesman;

public class Car {
    private final String model;
    private final Engine engine;
    private String weight = "n/a";
    private String color = "n/a";

    Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
