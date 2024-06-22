package org.example.repository;

import org.example.entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DungeonRepository {
    private java.sql.Connection internConnection = Connection.startConnection();

    public Dungeon prepareDungeon(Quest quest) {
        try {
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM DUNGEONS WHERE quests_quest_id = ?");
            preparedStatement.setInt(1, quest.getQuest_id());
            ResultSet resultSet = preparedStatement.executeQuery();

            Dungeon dungeon = new Dungeon();
            while (resultSet.next()) {
                dungeon.setDungeon_id(resultSet.getInt(1));
                dungeon.setQuest_id(resultSet.getInt(2));
                dungeon.setDungeonName(resultSet.getString(3));
                dungeon.setRounds(allRoundsByDungeon(dungeon.getDungeon_id()));
            }
            return dungeon;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Round> allRoundsByDungeon(int dungeon_id) {
        try {
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM ROUNDS WHERE dungeons_dungeon_id = ?");
            preparedStatement.setInt(1, dungeon_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Round> rounds = new ArrayList<>();
            while (resultSet.next()) {
                Round round = new Round();
                round.setRound_number(resultSet.getInt(5));
                round.setMonsters(allMonsterByRound(round.getRound_number(), dungeon_id));
                rounds.add(round);
            }
            return rounds;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Monster> allMonsterByRound(int round_number, int dungeon_id) {
        try {
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT monsters.*, rounds.monster_quantity\n" +
                            "FROM monsters \n" +
                            "INNER JOIN rounds ON monsters.monster_id = rounds.monsters_monster_id\n" +
                            "INNER JOIN dungeons ON dungeons.dungeon_id = rounds.dungeons_dungeon_id\n" +
                            "WHERE rounds.round_number = ? AND dungeons.dungeon_id = ?");
            preparedStatement.setInt(1, round_number);
            preparedStatement.setInt(2, dungeon_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Monster> monsters = new ArrayList<>();
            while (resultSet.next()) {
                for (int i = 0; i< resultSet.getInt("monster_quantity"); i++){
                    Monster monster = new Monster();
                    monster.setRace(resultSet.getString(2));
                    monster.setHp(resultSet.getInt(3));
                    monster.setAttack(resultSet.getInt(4));
                    monsters.add(monster);
                }
            }
            return monsters;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
