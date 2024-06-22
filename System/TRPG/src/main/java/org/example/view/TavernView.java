package org.example.view;

import org.example.entity.Hero;
import org.example.view.inventory.InventoryView;
import org.example.view.quest.PreStartQuestView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TavernView {
    public static void enterInTavern(Hero hero){
        System.out.print(hero.getName() + " has entered in the tavern\n\n");
        showTavernOptions(hero);
    }
    public static void showTavernOptions(Hero hero){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1 - Talk with the taverner
                2 - Open inventory
                3 - leave the tavern to quest""");
        try {
            System.out.print("Choose: ");
            int heroAction = scanner.nextInt();

            switch (heroAction) {
                case 1 -> TavernerDialogueView.dialogue(hero);

                case 2 -> InventoryView.enterInInventory(hero);

                case 3 -> PreStartQuestView.leaveConfirm(hero);

                default -> {
                    System.out.println("This option does not exist, try again");
                    showTavernOptions(hero);
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("This option does not exist, try again");
            showTavernOptions(hero);
        }
    }
}
