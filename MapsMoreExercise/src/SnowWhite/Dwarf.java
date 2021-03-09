package SnowWhite;

public class Dwarf {
    String name;
    String hatColour;
    int physics;

    Dwarf(String name, String hatColour, int physics){
        this.name = name;
        this.hatColour = hatColour;
        this.physics = physics;
    }

    public String getName() {
        return name;
    }

    public String getHatColour() {
        return hatColour;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s <-> %d",getHatColour(), getName(), getPhysics());
    }
}
