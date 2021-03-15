package VehicleCatalogue;

public class Car extends Vehicle{
    String model;
    String colour;
    int horsePower;

    Car(String model, String colour, int horsePower){
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
        return String.format("Type: Car%n" +
                "Model: %s%n" +
                "Colour: %s%n" +
                "Horsepower: %d%n",getModel(), getColour(), getHorsePower());
    }
}
