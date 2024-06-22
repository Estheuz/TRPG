package org.example.model;

import org.example.entity.Hero;
import org.example.repository.HeroRepository;

public class HeroService {
    private HeroRepository heroRepository = new HeroRepository();

    public Hero createHero(int hero_id){
        Hero hero = heroRepository.getOneHeroById(hero_id);
        return hero;
    }
    public boolean heroNotExists(int hero_id){
        Hero hero = heroRepository.getOneHeroById(hero_id);
        return (hero.getName() == null);
    }
}
