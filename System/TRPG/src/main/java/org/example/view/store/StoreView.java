package org.example.view.store;

import org.example.controller.StoreController;
import org.example.entity.Hero;
import org.example.entity.Potion;
import org.example.entity.Weapon;
import org.example.repository.StoreRepository;
import org.example.view.TavernerDialogueView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StoreView {

    public static void enterInStore(Hero hero){

        System.out.println("What do you want buy?");
        showTypesItems(hero);
    }
    public static void showTypesItems(Hero hero){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Actual gold: " + hero.getGold());
        System.out.println("""
                0 - back
                1 - Potions
                2 - Weapons
                """);
        try {
            System.out.print("choose: ");
            int dialogueOption = scanner.nextInt();

            switch (dialogueOption) {
                case 0 -> TavernerDialogueView.showDialogueOptions(hero);

                case 1 -> potionsStore(hero);

                case 2 -> weaponsStore(hero);

                default -> {
                    System.out.println("This option does not exist, try again");
                    showTypesItems(hero);
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("This option does not exist, try again");
            showTypesItems(hero);
        }
    }
    public static void weaponsStore(Hero hero){

        int count = 1;
        StoreRepository storeRepository = new StoreRepository();
        ArrayList<Weapon> weapons = storeRepository.getAllWeaponsByHero(hero);

        System.out.println("0 - back");
        for (Weapon weapon: weapons) {
            System.out.println(count + " - " + weapon);
            count++;
        }
        System.out.print("choose: ");
        try{
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                showTypesItems(hero);
            }
            else {
                int weaponSelected = optionSelected-1;
                StoreController storeController = new StoreController();
                storeController.buyOneWeaponRequest(hero, weapons.get(weaponSelected).getWeapon_id());
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            weaponsStore(hero);
        }
    }

    public static void potionsStore(Hero hero){
        int count = 1;
        StoreRepository storeRepository = new StoreRepository();
        ArrayList<Potion> potions = storeRepository.getAllPotion();

        System.out.println("0 - back");
        for (Potion potion: potions) {
            System.out.println(count + " - " + potion);
            count++;
        }
        System.out.print("choose: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                showTypesItems(hero);
            }
            else {
                int potionSelected = optionSelected-1;
                StoreController storeController = new StoreController();
                storeController.buyOnePotionRequest(hero, potions.get(potionSelected).getItem_id());
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            potionsStore(hero);
        }
    }
}
