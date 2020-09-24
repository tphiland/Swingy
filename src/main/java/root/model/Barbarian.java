package root.model;

public class Barbarian extends Hero {

    public Barbarian(String name) {
        super(name, 1, 0, new Stats(20, 6, 14), new Equipment());
    }

}
