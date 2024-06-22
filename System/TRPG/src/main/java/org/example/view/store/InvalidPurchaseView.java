package org.example.view.store;

import org.example.entity.Hero;
import org.example.view.store.StoreView;

public class InvalidPurchaseView {

    public static void invalidWeaponPurchaseMessage(Hero hero){

        System.out.println("You do not have enough money to buy this weapon");
        StoreView.weaponsStore(hero);
    }
    public static void invalidPotionPurchaseMessage(Hero hero){

        System.out.println("You do not have enough money to buy this potion");
        StoreView.potionsStore(hero);
    }
}
