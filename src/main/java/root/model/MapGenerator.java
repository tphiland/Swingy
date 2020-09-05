package root.model;

import java.util.ArrayList;
import java.util.Random;

public class MapGenerator {

    private int size;

    public MapGenerator(int level) {
        this.size = (level - 1) * 5 + 10 - (level % 2);
    }

    public ArrayList<Coordinates> createMap() {
        ArrayList<Coordinates> map = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (new Random().nextInt(2) == 1)
                    map.add(new Coordinates(j, i, true));
                else
                    map.add(new Coordinates(j, i, false));
            }
        }
        return map;
    }

}

