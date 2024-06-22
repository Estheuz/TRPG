package org.example.controller;

import org.example.entity.Hero;
import org.example.entity.Potion;
import org.example.entity.Weapon;
import org.example.model.InventoryService;
import org.example.view.inventory.InventoryView;

public class InventoryController {
    InventoryService inventoryService = new InventoryService();
    public void equipWeaponRequest(Hero hero, Weapon weapon){
        inventoryService.equipWeapon(hero,weapon);
        InventoryView.enterInInventory(hero);
    }
    public void usePotion(Hero hero, Potion potion){
        inventoryService.usePotion(hero, potion);
        InventoryView.enterInInventory(hero);
    }
    public void usePotionInBattle(Hero hero, Potion potion){
        inventoryService.usePotion(hero, potion);
    }
}
