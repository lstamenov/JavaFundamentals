package DragonArmy;

public class Dragon {
    String type;
    String name;
    int damage = 45;
    int health = 250;
    int armor = 10;

    Dragon(String type, String name){
        this.type = type;
        this.name = name;
    }

    Dragon(String type, String name, int damage, int health, int armor){
        this.type = type;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }


    @Override
    public String toString() {
        return String.format("-%s -> damage: %d, health: %d, armor: %d",getName(), getDamage(), getHealth(), getArmor());
    }
}
