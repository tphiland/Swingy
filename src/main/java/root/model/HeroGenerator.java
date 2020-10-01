package root.model;

import globals.Globals;

import static java.lang.Thread.sleep;

public class HeroGenerator {

    public Hero createNewHero(String type, String name) throws InterruptedException {
        switch (type) {
            case "Barbarian":
                return new Barbarian(name);
            case "Assassin":
                return new Assassin(name);
            case "Knight":
                return new Knight(name);
            default:
                System.out.println("incorrect hero class value");
                if (Globals.gameMode.equals("gui"))
                    sleep(5000);
                System.exit(0);
        }
        return null;
    }

}
