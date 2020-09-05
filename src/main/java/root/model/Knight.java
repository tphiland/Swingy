package root.model;

public class Knight extends Hero {

    public Knight(String name) {
        super(name, 0, 0, new Stats(7, 10, 3), null);
    }

    public Knight(String name, int level, int experience, Stats stats, Equipment equipment) {
        super(name, level, experience, stats, equipment);
    }

}
