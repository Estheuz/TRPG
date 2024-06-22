package org.example.entity;

public class Quest {
    private int quest_id;
    private int gold;
    private String questName;

    public int getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(int quest_id) {
        this.quest_id = quest_id;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    @Override
    public String toString() {
        return "Quest name: " + questName+ " | "+
                " Recompense: " + gold + " Gold";
    }
}
