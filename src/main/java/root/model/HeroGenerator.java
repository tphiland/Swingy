package root.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeroGenerator {

    public Hero createNewHero(String type, String name) {
        if (type.equals("Barbarian")) {
            return new Barbarian(name);
        }
        if (type.equals("Assassin")) {
            return new Assassin(name);
        }
        if (type.equals("Knight")) {
            return new Knight(name);
        }
        return null;
    }

    public Hero loadOldHero(String type, String name, int level, int experience, Stats stats, Equipment equipment) {
        if (type.equals("Barbarian")) {
            return new Barbarian(name, level, experience, stats, equipment);
        }
        if (type.equals("Assassin")) {
            return new Assassin(name, level, experience, stats, equipment);
        }
        if (type.equals("Knight")) {
            return new Knight(name, level, experience, stats, equipment);
        }
        return null;
    }
}
