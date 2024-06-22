package org.example.model;

import org.example.entity.Hero;
import org.example.entity.Potion;
import org.example.entity.Weapon;

public class InventoryService {
    public void equipWeapon(Hero hero, Weapon weapon){
        hero.setCurrentWeapon(weapon);
    }

    public void usePotion(Hero hero, Potion potion){
        hero.setHp(Math.min((hero.getHp() + potion.getHp_restore()), hero.getMaxHp()));
        hero.setMp(Math.min((hero.getMp() + potion.getMp_restore()), hero.getMaxMp()));
        hero.getPotionsInventory().remove(potion);
    }
}
