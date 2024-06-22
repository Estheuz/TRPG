package org.example.entity;

import java.util.ArrayList;

public class Dungeon {
    private int dungeon_id;
    private int quest_id;
    private String dungeonName;
    private ArrayList<Round> rounds;

    public int getDungeon_id() {
        return dungeon_id;
    }

    public void setDungeon_id(int dungeon_id) {
        this.dungeon_id = dungeon_id;
    }

    public String getDungeonName() {
        return dungeonName;
    }

    public void setDungeonName(String dungeonName) {
        this.dungeonName = dungeonName;
    }

    public int getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(int quest_id) {
        this.quest_id = quest_id;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }
}
