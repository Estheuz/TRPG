package org.example.model;

import org.example.entity.*;
import org.example.repository.DungeonRepository;

public class DungeonService {
    DungeonRepository dungeonRepository = new DungeonRepository();
    public Dungeon getDungeonByQuest(Quest quest){
        return dungeonRepository.prepareDungeon(quest);
    }

    public void attackOneMonster(Hero hero,Monster monster){
        hero.attackMonster(monster);
    }

    public void monsterTurnAttack(Hero hero, Round round){
        for (Monster monster: round.getMonsters()) {
            monster.attackHero(hero);
        }
    }
    public void useNoTargetSkill(Hero hero, Skill skill){
        hero.useNoTargetSkill(skill);
    }
    public void useTargetSkill(Hero hero, Skill skill, Monster monster){
        hero.useTargetSkill(skill, monster);
    }
    public boolean heroIsDead(Hero hero){
        if (hero.getHp() <= 0){
            return true;
        }
        else return false;
    }
    public boolean monsterIsDead(Monster monster){
        if (monster.getHp() <= 0){
            return true;
        }
        else return false;
    }
    public void killMonster(Round round, int monsterIndex){
        round.getMonsters().remove(monsterIndex);
    }
}
