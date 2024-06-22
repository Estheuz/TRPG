-- Conseguindo todos os monstros do round 
SELECT monsters.*, rounds.monster_quantity
FROM monsters 
INNER JOIN rounds ON monsters.monster_id = rounds.monsters_monster_id
INNER JOIN dungeons ON dungeons.dungeon_id = rounds.dungeons_dungeon_id
WHERE rounds.round_number = 3 AND dungeons.dungeon_id = 1 -- O número do round e o nome da dungeons são variáveis, obviamente. 


-- Fazer uma classe repository que organiza todas as consultas, talvez deixar ela separada por entidade
