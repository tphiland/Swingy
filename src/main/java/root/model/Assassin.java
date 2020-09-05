package root.model;

public class Assassin extends Hero {

    public Assassin(String name) {
        super(name, 0, 0, new Stats(3, 7, 10), null);
    }

    public Assassin(String name, int level, int experience, Stats stats, Equipment equipment) {
        super(name, level, experience, stats, equipment);
    }

}
