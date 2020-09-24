package root.controller;

import globals.Globals;
import root.model.Hero;

import java.util.Scanner;

public class Movement {

    public void move(Hero hero) {
        Globals.heroPreviousX = hero.getX();
        Globals.heroPreviousY = hero.getY();
        System.out.println("North = 'w', East = 'd', South = 's', West = 'a'");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if (str.equals("w"))
            hero.setY(hero.getY() + 1);
        else if (str.equals("d"))
            hero.setX(hero.getX() + 1);
        else if (str.equals("s"))
            hero.setY(hero.getY() - 1);
        else if (str.equals("a"))
            hero.setX(hero.getX() - 1);

        if (hero.getX() == 0 || hero.getY() == 0 || hero.getX() == Globals.mapBorder || hero.getY() == Globals.mapBorder) {
            System.out.println("You win");
            new HeroContinuation().saveHero(hero);
            System.exit(0);
        }
    }

}
