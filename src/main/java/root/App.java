package root;

import globals.Globals;
import root.controller.Battle;
import root.controller.HeroContinuation;
import root.controller.Movement;
import root.model.Coordinates;
import root.model.Hero;
import root.model.HeroGenerator;
import root.model.MapGenerator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main( String[] args ) {
        Hero hero;
        Scanner scanner = new Scanner(System.in);
        System.out.println("'1' to create new Hero, '*' to load Hero");
        String chooseHero;
        chooseHero = scanner.next();
        if (chooseHero.equals("1")) {
            System.out.println("Choose hero class: 'Assassin', 'Barbarian' or 'Knight'");
            String heroClass;
            heroClass = scanner.next();
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