-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-06-07 02:10:44.87

-- tables
-- Table: Dungeons
CREATE TABLE Dungeons (
    dungeon_id serial  NOT NULL,
    Quests_quest_id int  NOT NULL,
    dungeon_name varchar(20)  NOT NULL,
    CONSTRAINT Dungeons_pk PRIMARY KEY (dungeon_id)
);

-- Table: Heroes
CREATE TABLE Heroes (
    hero_id serial  NOT NULL,
    name_hero varchar(20)  NOT NULL,
    race_hero varchar(12)  NOT NULL,
    class_hero varchar(20)  NOT NULL,
    hp_hero int  NOT NULL,
    mp_hero int  NOT NULL,
    gold_hero int  NOT NULL,
    attack_hero int  NOT NULL,
    defense_hero int  NOT NULL,
    CONSTRAINT Heroes_pk PRIMARY KEY (hero_id)
);

-- Table: Monsters
CREATE TABLE Monsters (
    monster_id serial  NOT NULL,
    race_monster varchar(20)  NOT NULL,
    hp_monster int  NOT NULL,
    attack_monster int  NOT NULL,
    CONSTRAINT Monsters_pk PRIMARY KEY (monster_id)
);

-- Table: Potions
CREATE TABLE Potions (
    item_id serial  NOT NULL,
    name_potion varchar(20)  NOT NULL,
    hp_restore_potion int  NOT NULL,
    mp_restore_potion int  NOT NULL,
    price_potion int  NOT NULL,
    CONSTRAINT Potions_pk PRIMARY KEY (item_id)
);

-- Table: Quests
CREATE TABLE Quests (
    quest_id serial  NOT NULL,
    title_quest varchar(20)  NOT NULL,
    gold_quest int  NOT NULL,
    CONSTRAINT Quests_pk PRIMARY KEY (quest_id)
);

-- Table: Rounds
CREATE TABLE Rounds (
    round_id serial  NOT NULL,
    Dungeons_dungeon_id int  NOT NULL,
    Monsters_monster_id int  NOT NULL,
    monster_quantity int  NOT NULL,
    round_number int  NOT NULL,
    CONSTRAINT Rounds_pk PRIMARY KEY (round_id)
);

-- Table: Skills
CREATE TABLE Skills (
    skill_id serial  NOT NULL,
    name_skill varchar(30)  NOT NULL,
    damage_skill int  NOT NULL,
    hp_consume_skill int  NOT NULL,
    hp_restore_skill int  NOT NULL,
    mp_consume_skill int  NOT NULL,
    mp_restore_skill int  NOT NULL,
    Heroes_hero_id int  NOT NULL,
    CONSTRAINT Skills_pk PRIMARY KEY (skill_id)
);

-- Table: Weapons
CREATE TABLE Weapons (
    weapon_id serial  NOT NULL,
    name_weapon varchar(25)  NOT NULL,
    type_weapon varchar(20)  NOT NULL,
    attack_weapon int  NOT NULL,
    price_weapon int  NOT NULL,
    Heroes_hero_id int  NOT NULL,
    CONSTRAINT Weapons_pk PRIMARY KEY (weapon_id)
);

-- foreign keys
-- Reference: Dungeons_Quests (table: Dungeons)
ALTER TABLE Dungeons ADD CONSTRAINT Dungeons_Quests
    FOREIGN KEY (Quests_quest_id)
    REFERENCES Quests (quest_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Rounds_Dungeons (table: Rounds)
ALTER TABLE Rounds ADD CONSTRAINT Rounds_Dungeons
    FOREIGN KEY (Dungeons_dungeon_id)
    REFERENCES Dungeons (dungeon_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Rounds_Monsters (table: Rounds)
ALTER TABLE Rounds ADD CONSTRAINT Rounds_Monsters
    FOREIGN KEY (Monsters_monster_id)
    REFERENCES Monsters (monster_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Skills_Heroes (table: Skills)
ALTER TABLE Skills ADD CONSTRAINT Skills_Heroes
    FOREIGN KEY (Heroes_hero_id)
    REFERENCES Heroes (hero_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Weapons_Heroes (table: Weapons)
ALTER TABLE Weapons ADD CONSTRAINT Weapons_Heroes
    FOREIGN KEY (Heroes_hero_id)
    REFERENCES Heroes (hero_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

