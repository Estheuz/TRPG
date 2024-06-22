package org.example.view.dungeon;

import org.example.controller.DungeonController;
import org.example.entity.Dungeon;
import org.example.entity.Hero;

public class DungeonView {
    public static void startDungeonMessage(Hero hero, Dungeon dungeon){
        System.out.println("The dungeon of the " + dungeon.getDungeonName() + " has started!\n");
        System.out.println(hero.getName() + " has found enemies!!");
        DungeonController dungeonController = new DungeonController();
        dungeonController.startBattle(hero, dungeon);
    }
}
