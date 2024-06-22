package org.example.repository;

import org.example.entity.Hero;
import org.example.entity.Skill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HeroRepository {
    private java.sql.Connection internConnection = Connection.startConnection();

    public ArrayList<Hero> getAllHeroes(){
        try{
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM heroes ORDER BY hero_id ASC ");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Hero> heroes = new ArrayList<>();
            while (resultSet.next()){
                Hero hero = new Hero();
                hero.setHero_id(resultSet.getInt(1));
                hero.setName(resultSet.getString(2));
                hero.setRace(resultSet.getString(3));
                hero.setClass_hero(resultSet.getString(4));
                hero.setHp(resultSet.getInt(5));
                hero.setMp(resultSet.getInt(6));
                hero.setGold(resultSet.getInt(7));
                hero.setAttack(resultSet.getInt(8));
                hero.setDefense(resultSet.getInt(9));
                heroes.add(hero);
            }
            return heroes;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Hero getOneHeroById(int id_hero){
        try{
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM heroes WHERE hero_id = ?");
            preparedStatement.setInt(1, id_hero);
            ResultSet resultSet = preparedStatement.executeQuery();

            Hero hero = new Hero();
            while (resultSet.next()){
                hero.setHero_id(resultSet.getInt(1));
                hero.setName(resultSet.getString(2));
                hero.setRace(resultSet.getString(3));
                hero.setClass_hero(resultSet.getString(4));
                hero.setHp(resultSet.getInt(5));
                hero.setMp(resultSet.getInt(6));
                hero.setGold(resultSet.getInt(7));
                hero.setAttack(resultSet.getInt(8));
                hero.setDefense(resultSet.getInt(9));
                hero.setSkills(getSkillsByHero(id_hero));
            }
            return hero;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Skill> getSkillsByHero(int id_hero){
        try{
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM skills WHERE heroes_hero_id = ?");
            preparedStatement.setInt(1, id_hero);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Skill> skills = new ArrayList<>();
            while (resultSet.next()){
                Skill skill = new Skill();
                skill.setName(resultSet.getString(2));
                skill.setDamage(resultSet.getInt(3));
                skill.setHp_consume(resultSet.getInt(4));
                skill.setHp_restore(resultSet.getInt(5));
                skill.setMp_consume(resultSet.getInt(6));
                skill.setMp_restore(resultSet.getInt(7));
                skills.add(skill);
            }
            return skills;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
