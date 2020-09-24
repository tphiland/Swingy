package root;

import globals.Globals;
import root.controller.*;
import root.model.*;
import root.view.gui;

import javax.validation.*;
import java.util.*;

public class App {

    public static void main( String[] args ) {
        new gui().setUpGUI();

        Scanner scanner = new Scanner(System.in);
        Hero hero;
        System.out.println("'1' to create new Hero, '2' to load Hero");
        if (scanner.nextInt() == 1) {
            System.out.println("Choose hero class: 'Assassin', 'Barbarian' or 'Knight'");
            String heroClass = scanner.next();
            System.out.println("Enter name:");
            hero = new HeroGenerator().createNewHero(heroClass, scanner.next());
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

    private static void validate(Hero hero) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Hero>> violations = validator.validate(hero);
        for (ConstraintViolation<Hero> violation : violations) {
            if (violation.getMessage() != null) {
                System.out.println(violation.getMessage());
                System.exit(0);
            }
        }
    }

}