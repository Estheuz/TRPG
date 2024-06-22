package org.example.view.dungeon;

import org.example.controller.DungeonController;
import org.example.controller.InventoryController;
import org.example.entity.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleView {
    public static void battleView(Hero hero, Round round){
        System.out.println("\nRound - " + round.getRound_number());

        System.out.println("*Hero status*\n" +
                "Hp: " + hero.getHp() + " | " + "Mp: "+ hero.getMp() + "\n");

        System.out.println("""
                1 - Attack
                2 - Special skill
                3 - Use potion
                """);
        System.out.print("Choose: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int heroAction = scanner.nextInt();
            switch (heroAction){

                case 1 -> normalAttack(hero, round);

                case 2 -> useSkill(hero, round);

                case 3 -> usePotion(hero, round);

                default -> battleView(hero, round);
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            battleView(hero, round);
        }
    }
    public static void normalAttack(Hero hero, Round round){
        System.out.println("0 - Back");
        listMonster(round);
        System.out.print("Choose: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                battleView(hero, round);
            }
            else {
                int monsterSelected = optionSelected - 1;
                DungeonController dungeonController = new DungeonController();
                dungeonController.attackMonsterRequest(hero, round, monsterSelected);
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            normalAttack(hero, round);
        }
    }
    public static void selectMonsterTarget(Hero hero, Round round, Skill skill){
        System.out.println("Choose the target to " + skill.getName());
        listMonster(round);
        try {
            Scanner scanner = new Scanner(System.in);
            int monsterSelected = scanner.nextInt() - 1;
            DungeonController dungeonController = new DungeonController();
            dungeonController.useTargetSkill(hero, skill, round, monsterSelected);
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            selectMonsterTarget(hero, round, skill);
        }
    }
    public static void useSkill(Hero hero, Round round){
        int count = 1;
        System.out.println("0 - Back");
        for (Skill skill: hero.getSkills()) {
            System.out.println(count + " - " + skill);
            count++;
        }
        System.out.print("Choose: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                battleView(hero, round);
            }
            else {
               int skillSelected = optionSelected-1;
                DungeonController dungeonController = new DungeonController();
                dungeonController.useSkill(hero, round, hero.getSkills().get(skillSelected));
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            useSkill(hero, round);
        }
    }
    public static void usePotion(Hero hero, Round round){
        int count = 1;
        for (Potion potion: hero.getPotionsInventory()) {
            System.out.println(count + " - " + potion);
            count++;
        }
        System.out.print("Choose: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                battleView(hero, round);
            }
            else {
                int potionSelected = optionSelected-1;
                InventoryController inventoryController = new InventoryController();
                inventoryController.usePotionInBattle(hero, hero.getPotionsInventory().get(potionSelected));
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            usePotion(hero, round);
        }
    }
    public static void listMonster(Round round){
        int count = 1;
        for (Monster monster : round.getMonsters()) {
            System.out.println(count + " - " + monster);
            count++;
        }
    }
    public static void monsterAttackTurn(Round round){
        for (Monster monster : round.getMonsters()) {
            System.out.println(monster.getRace() +
                    " - Has causade " + monster.getAttack()
                    + " of damage");
        }
    }
    public static void monsterDeadMessage(Monster monster){
        System.out.println(monster.getRace() + " has dead");
    }
    public static void attackInfoMessage(Hero hero, Monster monster){
        System.out.println(hero.getName() + " Has used the normal attack");
        System.out.println("The attack has caused " + hero.getAttack() + " of damage in " + monster.getRace() + "\n");
    }
}
