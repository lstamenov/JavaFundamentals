package Songs;

public class Songs {
    String type;
    String name;
    String time;

    Songs(String type, String name, String time){
        this.type = type;
        this.name = name;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s%n",getName());
    }
}
