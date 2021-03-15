package VehicleCatalogue;

public class Truck extends Vehicle{
    String model;
    String colour;
    int horsePower;

    Truck(String model, String colour, int horsePower){
        super();
        this.model = model;
        this.colour = colour;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String printModel(){
        return String.format("Type: Truck%n" +
                "Model: %s%n" +
                "Colour: %s%n" +
                "Horsepower: %d%n",getModel(), getColour(), getHorsePower());
    }
}
