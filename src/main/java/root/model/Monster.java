package root.model;

import java.util.Random;

public class Monster {

    private Stats stats;

    public Monster(int level) {
        int attack = new Random().nextInt((level * 20) - 2) + 1;
        int defense = new Random().nextInt((level * 20) - attack - 1) + 1;
        int health = (level * 20) - attack - defense;
        this.stats = new Stats(attack, defense, health);
    }

    public Stats getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "stats=" + stats +
                '}';
    }

}
