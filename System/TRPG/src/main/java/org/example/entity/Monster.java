package org.example.entity;

public class Monster {
    private int monster_id;
    private String race;
    private int attack;
    private int hp;

    public int getMonster_id() {
        return monster_id;
    }

    public void setMonster_id(int monster_id) {
        this.monster_id = monster_id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return  "race: " + race + " | "+
                "hp: " + hp;
    }

    public void attackHero(Hero hero){
        hero.setHp(hero.getHp() - getAttack());
    }
}
