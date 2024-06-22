package org.example.view.quest;

import org.example.entity.Hero;
import org.example.view.TavernView;

public class RejectLeaveView {
    public static void rejectLeaveMessage(Hero hero){
        System.out.println("You do not have any quest to start, get one before leave the tavern");
        TavernView.showTavernOptions(hero);
    }
}
