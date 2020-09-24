package root.model;

import java.io.Serializable;

public class Equipment implements Serializable {

    private int weapon;
    private int armor;
    private int helm;

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHelm() {
        return helm;
    }

    public void setHelm(int helm) {
        this.helm = helm;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "weapon=" + weapon +
                ", armor=" + armor +
                ", helm=" + helm +
                '}';
    }

}
