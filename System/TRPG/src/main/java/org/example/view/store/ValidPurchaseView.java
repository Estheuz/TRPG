package org.example.view.store;

import org.example.entity.Hero;
import org.example.view.store.StoreView;

public class ValidPurchaseView {
    public static void validWeaponPurchaseMessage(Hero hero){
        System.out.println("Bought");
        StoreView.weaponsStore(hero);
    }
    public static void validPotionPurchaseMessage(Hero hero){
        System.out.println("Bought");
        StoreView.potionsStore(hero);
    }
}
