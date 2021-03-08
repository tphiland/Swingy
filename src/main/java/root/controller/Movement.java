package root.controller;

import globals.Globals;
import root.model.Hero;

import java.util.Scanner;

public class Movement {

    public void move(Hero hero) {
        Globals.heroPreviousX = hero.getX();
        Globals.heroPreviousY = hero.getY();
        System.out.println("North = 'w', East = 'd', South = 's', West = 'a'");

        String str;
        str = new Scanner(System.in).next();

        switch (str) {
            case "w":
                hero.setY(hero.getY() + 1);
                break;
            case "d":
                hero.setX(hero.getX() + 1);
                break;
            case "s":
                hero.setY(hero.getY() - 1);
                break;
            case "a":
                hero.setX(hero.getX() - 1);
                break;
            default:
                System.out.println("incorrect value");
                System.exit(0);
        }

        if (hero.getX() == 0 || hero.getY() == 0 || hero.getX() == Globals.mapBorder || hero.getY() == Globals.mapBorder) {
            System.out.println("You win");
            new HeroContinuation().saveHero(hero);
            System.exit(0);
        }
    }

}
