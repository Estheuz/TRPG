package org.example.controller;

import org.example.entity.Hero;
import org.example.model.StoreService;
import org.example.view.store.InvalidPurchaseView;
import org.example.view.store.ItemNotFoundView;
import org.example.view.store.ValidPurchaseView;

public class StoreController {
    StoreService storeService = new StoreService();
    public void buyOneWeaponRequest(Hero hero, int weapon_id){
        if (storeService.weaponExists(weapon_id)){
            if (storeService.heroHasEnoughGoldToWeapon(hero, weapon_id)){
                storeService.buyWeapon(hero, weapon_id);
                ValidPurchaseView.validWeaponPurchaseMessage(hero);
            }
            else {
                InvalidPurchaseView.invalidWeaponPurchaseMessage(hero);
            }
        }
        else {
            ItemNotFoundView.weaponNotFoundMessage(hero);
        }
    }
    public void buyOnePotionRequest(Hero hero, int potion_id){
        if (storeService.potionExists(potion_id)){
            if (storeService.heroHasEnoughGoldToPotion(hero, potion_id)){
                storeService.buyPotion(hero, potion_id);
                ValidPurchaseView.validPotionPurchaseMessage(hero);
            }
            else {
                InvalidPurchaseView.invalidPotionPurchaseMessage(hero);
            }
        }
        else {
            ItemNotFoundView.potionNotFoundMessage(hero);
        }
    }
}
