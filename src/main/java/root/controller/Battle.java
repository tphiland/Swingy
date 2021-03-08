package root.controller;

import globals.Globals;
import root.model.Hero;
import root.model.Monster;
import root.model.Stats;

import java.util.Random;
import java.util.Scanner;

public class Battle {

    public void startBattle (Hero hero, Monster monster) {
        Stats monsterStats = monster.getStats();
        Stats heroStats = hero.getStats();
        System.out.println(hero.toString());
        System.out.println(monster.toString());
        if (flee(hero, monster)) {
            while (heroStats.getHealth() > 0) {
                if (heroStats.getAttack() > monsterStats.getDefense())
                    monsterStats.setHealth(monsterStats.getHealth() - heroStats.getAttack() / 2);
                else
                    monsterStats.setHealth(monsterStats.getHealth() - heroStats.getAttack() / 4);
                System.out.println("Hero turn: Monster remaining health " + monsterStats.getHealth());
                if (monsterStats.getHealth() <= 0) {
                    System.out.println("Hero Wins");
                    gainExperience(hero, monster);
                    dropArtifact(hero);
                    System.out.println();
                    return;
                }
                if (monsterStats.getAttack() > heroStats.getDefense())
                    heroStats.setHealth(heroStats.getHealth() - monsterStats.getAttack() / 2);
                else
                    heroStats.setHealth(heroStats.getHealth() - monsterStats.getAttack() / 4);
                System.out.println("Monster turn: Hero remaining health " + heroStats.getHealth());

            }
            System.out.println("Monster Wins");
            System.exit(0);
        }
    }

    private void gainExperience (Hero hero, Monster monster) {
        int experience = (monster.getStats().getAttack() + monster.getStats().getDefense()) * 15;
        System.out.println("Experience gained: " + experience);
        hero.setExperience(hero.getExperience() + experience);
        if (hero.getExperience() >= hero.getLevel() * 1000 + (hero.getLevel() - 1) * (hero.getLevel() - 1) * 450) {
            System.out.println("Lv up!");
            hero.setLevel(hero.getLevel() + 1);
            hero.getStats().setAttack(Globals.heroBaseAttack * hero.getLevel() + hero.getEquipment().getWeapon());
            hero.getStats().setDefense(Globals.heroBaseDefence * hero.getLevel() + hero.getEquipment().getArmor());
            hero.getStats().setHealth(Globals.heroBaseHealth * hero.getLevel() + hero.getEquipment().getHelm());
            hero.setExperience(0);
        }
    }

    private void dropArtifact(Hero hero) {
        Random random = new Random();
        if (random.nextInt(7) == 1) {
            Scanner scanner = new Scanner(System.in);
            int artifactStrength = random.nextInt(hero.getLevel() * 20) + 1;
            int i = random.nextInt(3);
            if (i == 0) {
                System.out.println("Weapon(" + artifactStrength + ") dropped.\n'y' to equip");
                String str;
                str = scanner.next();
                if (str.equals("y")) {
                    hero.getStats().setAttack(hero.getStats().getAttack() - hero.getEquipment().getWeapon());
                    hero.getEquipment().setWeapon(artifactStrength);
                    hero.getStats().setAttack(hero.getStats().getAttack() + hero.getEquipment().getWeapon());
                }
            }
            if (i == 1) {
                System.out.println("Helm(" + artifactStrength + ") dropped.\n'y' to equip");
                String str;
                str = scanner.next();
                if (str.equals("y")) {
                    hero.getStats().setHealth(hero.getStats().getHealth() - hero.getEquipment().getHelm());
                    hero.getEquipment().setHelm(artifactStrength);
                    hero.getStats().setHealth(hero.getStats().getHealth() + hero.getEquipment().getHelm());
                }
            }
            if (i == 2) {
                System.out.println("Armour(" + artifactStrength + ") dropped.\n'y' to equip");
                String str;
                str = scanner.next();
                if (str.equals("y")) {
                    hero.getStats().setDefense(hero.getStats().getDefense() - hero.getEquipment().getArmor());
                    hero.getEquipment().setArmor(artifactStrength);
                    hero.getStats().setDefense(hero.getStats().getDefense() + hero.getEquipment().getArmor());                }
            }
        }
    }

    private boolean flee (Hero hero, Monster monster) {
        System.out.println("'y' to fight, '*' to try and flee.");
        Scanner scanner = new Scanner(System.in);
        String answer;
        answer = scanner.next();
        if (answer.equals("y")) {
            return true;
        }
        else {
            if (new Random().nextInt(2) == 1) {
                System.out.println("flee success, returning to previous coordinates");
                hero.setX(Globals.heroPreviousX);
                hero.setY(Globals.heroPreviousY);
                return false;
            }
            else {
                System.out.println("flee unsuccessful, monster attacks first");
                if (monster.getStats().getAttack() > hero.getStats().getDefense())
                    hero.getStats().setHealth(hero.getStats().getHealth() - monster.getStats().getAttack() / 2);
                else
                    hero.getStats().setHealth(hero.getStats().getHealth() - monster.getStats().getAttack() / 4);
                System.out.println("Monster turn: Hero remaining health " + hero.getStats().getHealth());
                return true;
            }
        }
    }

}
