package org.example.view;

import org.example.entity.Hero;
import org.example.view.quest.GetQuestView;
import org.example.view.store.StoreView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TavernerDialogueView {
    public static void dialogue(Hero hero){
        System.out.println("Taverner - What do you want today, bro?");
        showDialogueOptions(hero);
    }
    public static void showDialogueOptions(Hero hero){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                0 - back
                1 - Get Quests
                2 - Buy items""");
        try {
            System.out.print("Choose: ");
            int dialogueOption = scanner.nextInt();

            switch (dialogueOption) {
                case 0 -> TavernView.showTavernOptions(hero);

                case 1 -> GetQuestView.getQuestMessage(hero);

                case 2 -> StoreView.enterInStore(hero);

                default -> {
                    System.out.println("This option does not exist, try again");
                    showDialogueOptions(hero);
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("This option does not exist, try again");
            showDialogueOptions(hero);
        }
    }
}
