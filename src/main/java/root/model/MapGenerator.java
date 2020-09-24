package root.model;

import globals.Globals;

import java.util.ArrayList;
import java.util.Random;

public class MapGenerator {

    private int monsterLevel;
    private int size;

    public MapGenerator(Hero hero) {
        this.monsterLevel = hero.getLevel();
        this.size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        Globals.mapBorder = this.size + 1;
        hero.setX(this.size / 2);
        hero.setY(this.size / 2);
    }

    public ArrayList<Coordinates> createMap() {
        ArrayList<Coordinates> map = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (new Random().nextInt(3) == 1)
                    map.add(new Coordinates(j, i,  new Monster(monsterLevel)));
                else
                    map.add(new Coordinates(j, i, null));
            }
        }
        return map;
    }

}

