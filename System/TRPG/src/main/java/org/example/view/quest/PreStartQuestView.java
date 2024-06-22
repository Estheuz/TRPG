package org.example.view.quest;

import org.example.controller.QuestController;
import org.example.entity.Hero;
import org.example.view.TavernView;

import java.util.Scanner;

public class PreStartQuestView {
    public static void statusHeroMessage(Hero hero){
        System.out.println("\nHero: " + hero.getName());
        if (hero.getCurrentQuest() != null){
            System.out.println("Quest: " + hero.getCurrentQuest().getQuestName());
        }
        else {
            System.out.println("Quest: null");
        }
        System.out.println("Hp: " + hero.getHp() + "\n" +
                "Mp: " + hero.getMp());
        if (hero.getCurrentWeapon()!=null){
            System.out.println("Weapon: " + hero.getCurrentWeapon());
        }
        else {
            System.out.println("Weapon: null");
        }
    }
    public static void leaveConfirm(Hero hero){
        statusHeroMessage(hero);
        System.out.println("""
                
                0 - Back
                1 - Go to the Quest
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose: ");
        int option = scanner.nextInt();
        if (option == 0){
            TavernView.showTavernOptions(hero);
        }
        else {
            QuestController questController = new QuestController();
            questController.startQuestRequest(hero, hero.getCurrentQuest());
        }
    }
}
