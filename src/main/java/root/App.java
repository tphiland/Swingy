package root;

import globals.Globals;
import root.controller.*;
import root.model.*;
import root.view.Gui;

import javax.validation.*;
import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;

public class App {

    public static Gui gui = new Gui();

    public static void main( String[] args ) throws IOException, InterruptedException {
        Globals.gameMode = args[0];
        Globals.gameModeInitial = args[0];
        if (Globals.gameMode.equals("gui"))
            gui.setUpGUI();

        Hero hero;
        Scanner scanner = new Scanner(System.in);
        System.out.println("'1' to create new Hero, '*' to load Hero");
        String chooseHero;
        if (Globals.gameMode.equals("console"))
            chooseHero = scanner.next();
        else
            chooseHero = gui.getInput();
        if (chooseHero.equals("1")) {
            System.out.println("Choose hero class: 'Assassin', 'Barbarian' or 'Knight'");
            String heroClass;
            if (Globals.gameMode.equals("console"))
                heroClass = scanner.next();
            else
                heroClass = gui.getInput();
            System.out.println("Enter name:");
            if (Globals.gameMode.equals("console"))
                hero = new HeroGenerator().createNewHero(heroClass, scanner.next());
            else
                hero = new HeroGenerator().createNewHero(heroClass, gui.getInput());
        }
        else {
            hero = new HeroContinuation().loadHero();
            Globals.heroBaseHealth = (hero.getStats().getHealth() - hero.getEquipment().getHelm()) / hero.getLevel();
            Globals.heroBaseAttack = (hero.getStats().getAttack() - hero.getEquipment().getWeapon()) / hero.getLevel();
            Globals.heroBaseDefence = (hero.getStats().getDefense() - hero.getEquipment().getArmor()) / hero.getLevel();
        }

        validate(hero);

        ArrayList<Coordinates> map = new MapGenerator(hero).createMap();
        Battle battle = new Battle();
        Movement movement = new Movement();
        while (true) {
            System.out.println(hero.toString());
            movement.move(hero);
            for (Coordinates c : map) {
                if (c.getX() == hero.getX() && c.getY() == hero.getY())
                    if (c.getMonster() != null) {
                        int compareXp = hero.getExperience();
                        battle.startBattle(hero, c.getMonster());
                        if (hero.getExperience() != compareXp)
                            c.setMonster(null);
                    }
            }
        }
    }

    private static void validate(Hero hero) throws InterruptedException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Hero>> violations = validator.validate(hero);
        for (ConstraintViolation<Hero> violation : violations) {
            if (violation.getMessage() != null) {
                System.out.println(violation.getMessage());
                if (Globals.gameMode.equals("gui"))
                    sleep(5000);
                System.exit(0);
            }
        }
    }

}