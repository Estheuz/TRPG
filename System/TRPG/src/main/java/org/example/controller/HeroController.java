package org.example.controller;

import org.example.entity.Hero;
import org.example.model.HeroService;
import org.example.view.hero.HeroSelectionView;
import org.example.view.TavernView;

public class HeroController {
    HeroService heroService = new HeroService();
    public void createHeroRequest(int hero_id){

        if (heroService.heroNotExists(hero_id)){
            HeroSelectionView.errorHeroDoesNotExist();
        }
        else {
            Hero hero = heroService.createHero(hero_id);
            TavernView.enterInTavern(hero);
        }
    }
}
