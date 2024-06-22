package org.example.entity;

public class Skill {
    private String name;
    private int hp_consume;
    private int hp_restore;
    private int mp_consume;
    private int mp_restore;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp_consume() {
        return hp_consume;
    }

    public void setHp_consume(int hp_consume) {
        this.hp_consume = hp_consume;
    }

    public int getHp_restore() {
        return hp_restore;
    }

    public void setHp_restore(int hp_restore) {
        this.hp_restore = hp_restore;
    }

    public int getMp_consume() {
        return mp_consume;
    }

    public void setMp_consume(int mp_consume) {
        this.mp_consume = mp_consume;
    }

    public int getMp_restore() {
        return mp_restore;
    }

    public void setMp_restore(int mp_restore) {
        this.mp_restore = mp_restore;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return  name + " | "+
                " hp consume/restore: " + hp_consume + "/" + hp_restore + " | "+
                " mp consume/restore: " + mp_consume + "/" + mp_restore + " | "+
                " damage: " + damage;
    }
}
