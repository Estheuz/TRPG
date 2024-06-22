package org.example.model;

import org.example.entity.Hero;
import org.example.repository.QuestRepository;

public class QuestService {
    public void getOneQuest(Hero hero, int quest_id){
        QuestRepository questRepository = new QuestRepository();
        hero.setCurrentQuest(questRepository.getOneQuestById(quest_id));

    }
}
