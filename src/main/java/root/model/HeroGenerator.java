package root.model;

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

}
