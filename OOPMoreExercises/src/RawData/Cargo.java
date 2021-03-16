package RawData;

public class Cargo {

    private int weight;
    String type;

    Cargo(int weight, String type){
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
