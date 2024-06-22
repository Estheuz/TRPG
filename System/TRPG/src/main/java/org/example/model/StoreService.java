package org.example.model;

import org.example.entity.Hero;
import org.example.entity.Potion;
import org.example.entity.Weapon;
import org.example.repository.StoreRepository;

public class StoreService {
    StoreRepository storeRepository = new StoreRepository();
    public void buyWeapon(Hero hero, int weapon_id){
        Weapon weapon = storeRepository.getOneWeaponById(weapon_id);
        hero.setGold(hero.getGold() - weapon.getPrice());
        hero.addWeaponInInventory(weapon);
    }
    public boolean heroHasEnoughGoldToWeapon(Hero hero, int weapon_id){
        Weapon weapon = storeRepository.getOneWeaponById(weapon_id);
        if (hero.getGold() > weapon.getPrice()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean weaponExists(int weapon_id){
        return storeRepository.getOneWeaponById(weapon_id).getName() != null;
    }

    public void buyPotion(Hero hero, int potion_id){
        Potion potion = storeRepository.getOnePotionById(potion_id);
        hero.setGold(hero.getGold() - potion.getPrice());
        hero.addPotionInInventory(potion);
    }
    public boolean heroHasEnoughGoldToPotion(Hero hero, int potion_id){
        Potion potion = storeRepository.getOnePotionById(potion_id);
        if (hero.getGold() > potion.getPrice()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean potionExists(int potion_id){
        return storeRepository.getOnePotionById(potion_id).getName_potion() != null;
    }
}
