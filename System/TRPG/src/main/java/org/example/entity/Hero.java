package org.example.entity;

import java.util.ArrayList;

public class Hero {
    private int hero_id;
    private String name;
    private String race;
    private String class_hero;
    private int mp;
    private int hp;
    private int maxMp = 200;
    private int maxHp = 200;
    private int gold;
    private int attack;
    private int defense;
    private Quest currentQuest;
    private Weapon currentWeapon;
    private ArrayList<Weapon> weaponsInventory = new ArrayList<>();
    private ArrayList<Potion> potionsInventory = new ArrayList<>();
    private ArrayList<Skill> skills = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClass_hero() {
        return class_hero;
    }

    public void setClass_hero(String class_hero) {
        this.class_hero = class_hero;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public void addWeaponInInventory(Weapon weapon){
        weaponsInventory.add(weapon);
    }
    public void addPotionInInventory(Potion potion){
        potionsInventory.add(potion);
    }

    public Quest getCurrentQuest() {
        return currentQuest;
    }

    public void setCurrentQuest(Quest currentQuest) {
        this.currentQuest = currentQuest;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public ArrayList<Weapon> getWeaponsInventory() {
        return weaponsInventory;
    }

    public ArrayList<Potion> getPotionsInventory() {
        return potionsInventory;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public void attackMonster(Monster monster){
        monster.setHp(monster.getHp() - getAttack());
    }
    public void useNoTargetSkill(Skill skill){
        setHp(getHp() + skill.getHp_restore());
        setHp(getHp() - skill.getHp_consume());
        setMp(getMp() + skill.getMp_restore());
        setMp(getMp() - skill.getMp_consume());
    }
    public void useTargetSkill(Skill skill, Monster monster){
        setHp(getHp() + skill.getHp_restore());
        setHp(getHp() - skill.getHp_consume());
        setMp(getMp() + skill.getMp_restore());
        setMp(getMp() - skill.getMp_consume());
        monster.setHp(monster.getHp() - (skill.getDamage()));
    }
    @Override
    public String toString() {
        return  "\n"+hero_id + " - " + name;
    }
}
