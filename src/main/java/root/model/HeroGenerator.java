package root.model;

public class HeroGenerator {

    public Hero createNewHero(String type, String name) {
        switch (type) {
            case "Barbarian":
                return new Barbarian(name);
            case "Assassin":
                return new Assassin(name);
            case "Knight":
                return new Knight(name);
            default:
                System.out.println("incorrect hero class value");
                System.exit(0);
        }
        return null;
    }

}
