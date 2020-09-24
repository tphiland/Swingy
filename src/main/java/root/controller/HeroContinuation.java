package root.controller;

import root.model.Hero;

import java.io.*;

public class HeroContinuation {

    public void saveHero(Hero hero) {
         try {
             FileOutputStream fileOut = new FileOutputStream("savedHero.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(hero);
             out.close();
             fileOut.close();
             System.out.println("Serialized data is saved in savedHero.txt");
         } catch (IOException i) {
             i.printStackTrace();
         }
    }

    public Hero loadHero() {
        try {
            FileInputStream fileIn = new FileInputStream("savedHero.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Hero myHero = (Hero) in.readObject();
            in.close();
            fileIn.close();
            return myHero;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Hero class not found");
            c.printStackTrace();
            return null;
        }
    }

}
