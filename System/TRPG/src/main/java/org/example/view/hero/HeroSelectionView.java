package org.example.view.hero;

import org.example.controller.HeroController;
import org.example.entity.Hero;
import org.example.repository.HeroRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HeroSelectionView {

    public static void heroSelection(){
        HeroRepository heroRepository = new HeroRepository();
        ArrayList<Hero> heroes = heroRepository.getAllHeroes();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select your hero");

        for (Hero hero: heroes){
            System.out.print(hero);
        }

        System.out.print("\nChoose: ");
        try {
            HeroController heroController = new HeroController();
            int heroSelected = scanner.nextInt();
            heroController.createHeroRequest(heroSelected);
            scanner.close();
        }
        catch (InputMismatchException e){
            errorHeroDoesNotExist();
        }
    }

    public static void errorHeroDoesNotExist(){
        System.out.println("\nSorry, this hero does not exist, try again");
        heroSelection();
    }
}
