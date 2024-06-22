package org.example.view.dungeon;

import org.example.entity.Hero;

public class GameOverView {
    public static void gameOverMessage(Hero hero){
        System.out.println(hero.getName() + " Has dead...");
        System.out.println("GAME OVER");
    }
}
