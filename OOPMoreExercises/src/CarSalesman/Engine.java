package CarSalesman;

public class Engine {
    private final String model;
    private final int power;
    private String displacement = "n/a";
    private String efficiency = "n/a";

    Engine(String model, int power){
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("  %s:%n" +
                "       Power: %d%n" +
                "       Displacement: %s%n" +
                "       Efficiency: %s",getModel(), getPower(), getDisplacement(), getEfficiency());
    }
}
