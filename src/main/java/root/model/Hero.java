package root.model;

import globals.Globals;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class Hero implements Serializable {

    @Size(min = 2, max = 15, message = "Name length must be between 2 and 15")
    protected String name;
    protected int level;
    protected int experience;
    protected Stats stats;
    protected Equipment equipment;
    protected int x, y;

    public Hero(String name, int level, int experience, Stats stats, Equipment equipment) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.stats = stats;
        this.equipment = equipment;
        Globals.heroBaseHealth = stats.getHealth();
        Globals.heroBaseAttack = stats.getAttack();
        Globals.heroBaseDefence = stats.getDefense();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Stats getStats() {
        return stats;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", stats=" + stats +
                ", equipment=" + equipment +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

}
