package root.model;

public class Barbarian extends Hero {

    public Barbarian(String name) {
        super(name, 0, 0, new Stats(10, 3, 7), null);
    }

    public Barbarian(String name, int level, int experience, Stats stats, Equipment equipment) {
        super(name, level, experience, stats, equipment);
    }

}
