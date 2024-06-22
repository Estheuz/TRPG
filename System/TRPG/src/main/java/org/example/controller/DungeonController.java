package org.example.controller;

import org.example.entity.*;
import org.example.model.DungeonService;
import org.example.view.dungeon.BattleView;
import org.example.view.dungeon.FinishDungeonView;
import org.example.view.dungeon.GameOverView;

import java.util.ArrayList;

public class DungeonController {
    int currentRound = 0;
    DungeonService dungeonService = new DungeonService();
    public void startBattle(Hero hero, Dungeon dungeon){
        ArrayList<Round> rounds = dungeon.getRounds();
        battleManager(hero, rounds);
    }
    public void battleManager(Hero hero, ArrayList<Round> rounds){
        while (true){
            if (rounds.get(currentRound).getMonsters().size() == 0){
                currentRound++;
            }
            if (currentRound > rounds.size()-2){
                break;
            }
            if (dungeonService.heroIsDead(hero)){
                break;
            }
            battleTurnHero(hero, rounds.get(currentRound));
            monsterAttackTurn(hero, rounds.get(currentRound));
        }
        if (dungeonService.heroIsDead(hero)){
            gameOver(hero);
        }
        else {
            finishDungeon(hero);
        }
    }
    public void battleTurnHero(Hero hero, Round round){
        BattleView.battleView(hero, round);
    }
    public void attackMonsterRequest(Hero hero, Round round, int monsterSelected){
        dungeonService.attackOneMonster(hero, round.getMonsters().get(monsterSelected));
        BattleView.attackInfoMessage(hero, round.getMonsters().get(monsterSelected));

        if (dungeonService.monsterIsDead(round.getMonsters().get(monsterSelected))){
            BattleView.monsterDeadMessage(round.getMonsters().get(monsterSelected));
            dungeonService.killMonster(round, monsterSelected);
        }
    }
    public void useSkill(Hero hero,Round round, Skill skill){
        if (skill.getDamage() == 0){
            dungeonService.useNoTargetSkill(hero, skill);
        }
        else {
            BattleView.selectMonsterTarget(hero, round, skill);

        }
    }
    public void useTargetSkill(Hero hero,  Skill skill, Round round, int monsterSelected){
        dungeonService.useTargetSkill(hero, skill, round.getMonsters().get(monsterSelected));

        if (dungeonService.monsterIsDead(round.getMonsters().get(monsterSelected))){
            BattleView.monsterDeadMessage(round.getMonsters().get(monsterSelected));
            dungeonService.killMonster(round, monsterSelected);
        }
    }
    public void gameOver(Hero hero){
        GameOverView.gameOverMessage(hero);
    }
    public void finishDungeon(Hero hero){
        FinishDungeonView.finishDungeonMessage(hero);
    }
    public void monsterAttackTurn(Hero hero, Round round){
        dungeonService.monsterTurnAttack(hero, round);
        BattleView.monsterAttackTurn(round);
    }
}
