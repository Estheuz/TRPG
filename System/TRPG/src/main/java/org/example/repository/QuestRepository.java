package org.example.repository;

import org.example.entity.Quest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestRepository {
    private java.sql.Connection internConnection = Connection.startConnection();

    public ArrayList<Quest> getAllQuests(){
        try{
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM QUESTS");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Quest> quests = new ArrayList<>();
            while (resultSet.next()){
                Quest quest = new Quest();
                quest.setQuest_id(resultSet.getInt(1));
                quest.setQuestName(resultSet.getString(2));
                quest.setGold(resultSet.getInt(3));
                quests.add(quest);
            }
            return quests;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Quest getOneQuestById(int quest_id){
        try{
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM QUESTS WHERE quest_id = ?");
            preparedStatement.setInt(1, quest_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Quest quest = new Quest();
            while (resultSet.next()){
                quest.setQuest_id(resultSet.getInt(1));
                quest.setQuestName(resultSet.getString(2));
                quest.setGold(resultSet.getInt(3));
            }
            return quest;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
