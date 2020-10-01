package root.controller;

import globals.Globals;
import root.App;
import root.model.Hero;
import root.view.Gui;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Movement {

    public void move(Hero hero) throws InterruptedException, IOException {
        Globals.heroPreviousX = hero.getX();
        Globals.heroPreviousY = hero.getY();
        System.out.println("North = 'w', East = 'd', South = 's', West = 'a' switch to gui = 'gui'");

        String str;
        if (Globals.gameMode.equals("console"))
            str = new Scanner(System.in).next();
        else
            str = App.gui.getInput();

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
            case "gui":
                Globals.gameMode = "gui";
                Gui.setOutput(Gui.myPrintStream);
                break;
            default:
                System.out.println("incorrect value");
                if (Globals.gameMode.equals("gui"))
                    sleep(5000);
                System.exit(0);
        }

        if (hero.getX() == 0 || hero.getY() == 0 || hero.getX() == Globals.mapBorder || hero.getY() == Globals.mapBorder) {
            System.out.println("You win");
            new HeroContinuation().saveHero(hero);
            if (Globals.gameMode.equals("gui"))
                sleep(5000);
            System.exit(0);
        }
    }

}
