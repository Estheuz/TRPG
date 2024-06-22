package org.example.controller;

import org.example.entity.Dungeon;
import org.example.entity.Hero;
import org.example.entity.Quest;
import org.example.model.DungeonService;
import org.example.model.QuestService;
import org.example.view.dungeon.DungeonView;
import org.example.view.quest.GetQuestView;
import org.example.view.quest.RejectLeaveView;

public class QuestController {
    QuestService questService = new QuestService();
    DungeonService dungeonService = new DungeonService();
    public void getQuestRequest(Hero hero, int quest_id){
        questService.getOneQuest(hero,quest_id);
        GetQuestView.getQuestMessage(hero);
    }
    public void startQuestRequest(Hero hero, Quest quest){
        if (quest == null){
            RejectLeaveView.rejectLeaveMessage(hero);
        }
        else {
            Dungeon dungeon = dungeonService.getDungeonByQuest(quest);
            DungeonView.startDungeonMessage(hero, dungeon);
        }
    }
}
