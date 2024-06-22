package org.example.repository;

import org.example.entity.Hero;
import org.example.entity.Potion;
import org.example.entity.Weapon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreRepository {
    private java.sql.Connection internConnection = Connection.startConnection();

    public ArrayList<Weapon> getAllWeaponsByHero(Hero hero){
        try{
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM WEAPONS WHERE heroes_hero_id = ?");
            preparedStatement.setInt(1,hero.getHero_id());
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Weapon> weapons = new ArrayList<>();
            while (resultSet.next()){
                Weapon weapon = new Weapon();
                weapon.setWeapon_id(resultSet.getInt(1));
                weapon.setName(resultSet.getString(2));
                weapon.setType(resultSet.getString(3));
                weapon.setAttack(resultSet.getInt(4));
                weapon.setPrice(resultSet.getInt(5));
                weapons.add(weapon);
            }
            return weapons;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Weapon getOneWeaponById(int weapon_id){
        try {
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM WEAPONS WHERE weapon_id = ?");
            preparedStatement.setInt(1,weapon_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Weapon weapon = new Weapon();
            while (resultSet.next()){
                weapon.setWeapon_id(resultSet.getInt(1));
                weapon.setName(resultSet.getString(2));
                weapon.setType(resultSet.getString(3));
                weapon.setAttack(resultSet.getInt(4));
                weapon.setPrice(resultSet.getInt(5));
            }
            return weapon;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Potion> getAllPotion(){
      try {
          PreparedStatement preparedStatement = internConnection
                  .prepareStatement("SELECT * FROM POTIONS");
          ResultSet resultSet = preparedStatement.executeQuery();

          ArrayList<Potion> potions = new ArrayList<>();
          while (resultSet.next()){
              Potion potion = new Potion();
              potion.setItem_id(resultSet.getInt(1));
              potion.setName_potion(resultSet.getString(2));
              potion.setHp_restore(resultSet.getInt(3));
              potion.setMp_restore(resultSet.getInt(4));
              potion.setPrice(5);
              potions.add(potion);
          }
          return potions;
      }
      catch (SQLException e) {
          throw new RuntimeException(e);
      }
    }

    public Potion getOnePotionById(int potion_id){
        try {
            PreparedStatement preparedStatement = internConnection
                    .prepareStatement("SELECT * FROM POTIONS WHERE item_id = ?");
            preparedStatement.setInt(1,potion_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Potion potion = new Potion();
            while (resultSet.next()){
                potion.setItem_id(resultSet.getInt(1));
                potion.setName_potion(resultSet.getString(2));
                potion.setHp_restore(resultSet.getInt(3));
                potion.setMp_restore(resultSet.getInt(4));
                potion.setPrice(5);
            }
            return potion;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
