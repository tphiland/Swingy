package root.model;

public class Stats {

    private int attack;
    private int defense;
    private int health;

    public Stats(int attack, int defense, int health) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                '}';
    }
}
