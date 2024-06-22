-- Heroes population
INSERT INTO Heroes (name_hero, race_hero, class_hero, hp_hero, mp_hero, attack_hero, defense_hero, gold_hero)
VALUES ('The Traveler', 'Dwarf', 'Wizard', 110, 140, 50, 60, 0),
       ('The Master', 'Orc', 'Monk', 200, 50, 40, 70, 0),
       ('The Blessed', 'Human', 'Paladin', 125, 125,55, 55, 0);
       
INSERT INTO Skills (name_skill, damage_skill, hp_consume_skill, hp_restore_skill, mp_consume_skill, mp_restore_skill, Heroes_hero_id)
VALUES ('Rest', 0, 0, 15, 0, 20, 1),  
       ('Mystical thunder', 25, 0, 0, 5, 0, 1),  
       ('Fire ball', 50 , 0, 0, 15, 0, 1),
       ('Final Storm', 20, 0, 0, 15, 0, 1),
       
       ('Punch combination', 15, 0, 0, 0, 0, 2),  
       ('Axe hand', 20, 0, 0, 0, 0, 2),  
       ('Half moon kick', 30, 0, 0, 0, 0, 2),
       ('Palm of Buddha', 45, 5, 0, 5, 0, 2),
       
       ('Glory cure', 0, 0, 25, 5, 0, 3),  
       ('Sword attack', 15, 0, 0, 0, 0, 3),  
       ('Rage of god', 50, 0, 0, 15, 0, 3),
       ('Blessed shine', 15, 15, 0, 10, 0, 3);       

INSERT INTO Weapons (name_weapon, type_weapon, attack_weapon, price_weapon, Heroes_hero_id)
VALUES ('Poor Stick', 'Wand', 0, 10, 1), 
       ('Guardian of knowledge', 'Staff', 10, 20, 1), 
       ('Sanctuary of souls', 'Orb', 50, 30, 1),
       
       ('Iron hand', 'Gloves', 15, 10, 2), 
       ('Buddha statue', 'Totem', 20, 20, 2), 
       ('Demoniac eyes', 'Tattoo', 40, 30, 2),
       
       ('Simple sword', 'Short sword', 15, 10, 3), 
       ('Final judgment', 'Long sword', 40, 20, 3), 
       ('Tear of god', 'Two hand sword', 40, 30, 3);
       
INSERT INTO Potions (name_potion, hp_restore_potion, mp_restore_potion, price_potion)
VALUES ('Cure potion', 25, 0, 10), 
       ('Mana potion', 0, 25, 10), 
       ('Large cure potion', 50, 0, 10), 
       ('Large mana potion', 0, 50, 10);

--Quest population
INSERT INTO Quests (title_quest, gold_quest)
VALUES ('Florest of goblins', 200), 
       ('Cursed cemetery', 300);
       
INSERT INTO Dungeons (dungeon_name, Quests_quest_id)
VALUES ('Goblin king', 1), 
       ('Necromancer', 2);
       
INSERT INTO Monsters (race_monster, hp_monster, attack_monster)
VALUES ('Goblin', 15,5), 
       ('Goblin king', 100, 10),
       ('Undead', 20, 5), 
       ('Necromancer', 50, 15);
       
INSERT INTO Rounds (Dungeons_dungeon_id, Monsters_monster_id, monster_quantity, round_number)
VALUES (1,1,3,1),
       (1,1,2,2),
       (1,1,2,3),
       (1,2,1,3),
       
       (2,3,3,1),
       (2,3,2,2),
       (2,4,1,2),
       (2,3,2,3),
       (2,4,1,3);

