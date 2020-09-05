package root.model;

public class Hero {

    protected String name;
    protected int level;
    protected int experience;
    protected Stats stats;
    protected Equipment equipment;

    public Hero(String name, int level, int experience, Stats stats, Equipment equipment) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.stats = stats;
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", stats=" + stats +
                ", equipment=" + equipment +
                '}';
    }
}
