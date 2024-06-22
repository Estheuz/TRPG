package org.example.view.quest;

import org.example.controller.QuestController;
import org.example.entity.Hero;
import org.example.entity.Quest;
import org.example.repository.QuestRepository;
import org.example.view.TavernerDialogueView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GetQuestView {
    public static void getQuestMessage(Hero hero){
        int count = 1;
        if (hero.getCurrentQuest() != null){
            System.out.println("Hero current quest : " + hero.getCurrentQuest().getQuestName());
        }
        else {
            System.out.println("Hero current quest : null");
        }
        QuestRepository questRepository = new QuestRepository();
        ArrayList<Quest> quests = questRepository.getAllQuests();

        System.out.println("0 - Back");
        for (Quest quest: quests) {
            System.out.println(count + " - " + quest);
            count++;
        }

        System.out.print("Choose :");
        try {
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                TavernerDialogueView.showDialogueOptions(hero);
            }
            else {
                int questSelected = optionSelected-1;
                QuestController questController = new QuestController();
                questController.getQuestRequest(hero, quests.get(questSelected).getQuest_id());
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            getQuestMessage(hero);
        }
    }
}
