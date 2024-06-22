package org.example.entity;

public class Potion {
    private int item_id;
    private String name_potion;
    private int hp_restore;
    private int mp_restore;
    private int price;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName_potion() {
        return name_potion;
    }

    public void setName_potion(String name_potion) {
        this.name_potion = name_potion;
    }

    public int getHp_restore() {
        return hp_restore;
    }

    public void setHp_restore(int hp_restore) {
        this.hp_restore = hp_restore;
    }

    public int getMp_restore() {
        return mp_restore;
    }

    public void setMp_restore(int mp_restore) {
        this.mp_restore = mp_restore;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "name: " + name_potion+
                " | hp restore: " + hp_restore +
                " | mp restore: " + mp_restore +
                " | price: " + price;
    }
}
