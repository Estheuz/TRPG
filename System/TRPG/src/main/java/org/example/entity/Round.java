package org.example.entity;

import java.util.ArrayList;

public class Round {
    private ArrayList<Monster> monsters = new ArrayList<>();
    private int round_number;
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public int getRound_number() {
        return round_number;
    }

    public void setRound_number(int round_number) {
        this.round_number = round_number;
    }
}
