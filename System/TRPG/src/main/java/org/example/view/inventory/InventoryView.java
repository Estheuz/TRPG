package org.example.view.inventory;

import org.example.controller.InventoryController;
import org.example.entity.Hero;
import org.example.entity.Potion;
import org.example.entity.Weapon;
import org.example.view.TavernView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryView {

    public static void enterInInventory(Hero hero){
        System.out.println("Hero's inventory");
        System.out.println(
                "\nHp: "+ hero.getHp()
                + "\nMp: " + hero.getMp());
        if (hero.getCurrentWeapon()!= null){
            System.out.println("Current weapon: " + hero.getCurrentWeapon().getName());
        }
        else {
            System.out.println("Current weapon: null");
        }

        System.out.println("""
                0 - Back
                1 - Use potion
                2 - Equip weapon
                """);
        System.out.print("Choose: ");
        Scanner scanner = new Scanner(System.in);
        int heroOption = scanner.nextInt();

        switch (heroOption) {
            case 0 -> TavernView.showTavernOptions(hero);

            case 1 -> usePotion(hero);

            case 2 -> equipWeapon(hero);

            default -> {
                System.out.println("This option does not exist, try again");
                enterInInventory(hero);
            }
        }
    }

    public static void equipWeapon(Hero hero){ // Verificar se esse método não tá pegando função além da view
        int count = 1;

        System.out.println("0 - Back");
        for (Weapon weapon: hero.getWeaponsInventory()){
            System.out.println(count + " - " +
                    weapon.getName() + " | " +
                    "Type: " + weapon.getType() + " | " +
                    "Attack: " + weapon.getAttack());
            count++;
        }

        System.out.print("Choose: ");
        try{
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                enterInInventory(hero);
            }
            else { // Essa parte aqui especificamente, revisar depois.
                int weaponSelected = optionSelected-1;
                Weapon weapon = hero.getWeaponsInventory().get(weaponSelected);
                InventoryController inventoryController = new InventoryController();
                inventoryController.equipWeaponRequest(hero, weapon);
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            enterInInventory(hero);
        }

    }
    public static void usePotion(Hero hero){
        int count = 1;

        System.out.println("0 - Back");
        for (Potion potion: hero.getPotionsInventory()){
            System.out.println(count + " - "
                    + potion.getName_potion() + "|"
                    + "hp: " + potion.getHp_restore() + " | "
                    + "mp: " + potion.getMp_restore());
            count++;
        }
        System.out.print("Choose: ");
        try{
            Scanner scanner = new Scanner(System.in);
            int optionSelected = scanner.nextInt();
            if (optionSelected == 0){
                enterInInventory(hero);
            }
            else {
                int potionSelected = optionSelected-1;
                InventoryController inventoryController = new InventoryController();
                inventoryController.usePotion(hero, hero.getPotionsInventory().get(potionSelected));
            }
        }
        catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("This option does not exist, try again");
            enterInInventory(hero);
        }
    }
}
