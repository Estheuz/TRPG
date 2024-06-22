package org.example.view.dungeon;

import org.example.entity.Hero;
import org.example.view.TavernView;

public class FinishDungeonView {
    public static void finishDungeonMessage(Hero hero){
        System.out.println("The dungeon has finished");
        System.out.println("The hero go back to the tavern");
        TavernView.enterInTavern(hero);
    }
}
