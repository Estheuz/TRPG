package org.example.view.store;

import org.example.entity.Hero;
import org.example.view.store.StoreView;

public class ItemNotFoundView {
    public static void weaponNotFoundMessage(Hero hero){
        System.out.println("Weapon not found");
        StoreView.weaponsStore(hero);
    }
    public static void potionNotFoundMessage(Hero hero){
        System.out.println("Potion not found");
        StoreView.potionsStore(hero);
    }
}
