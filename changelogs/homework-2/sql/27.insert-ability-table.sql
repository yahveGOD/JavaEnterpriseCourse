INSERT INTO ability (hero_id,name,description,damage_type,fixed_damage,is_passive) VALUES (1,'MIST COIL','Abaddon releases a coil of deathly mist that can damage an enemy unit or heal a friendly unit at the cost of some of Abaddons health.','Magical',325,FALSE);

INSERT INTO ability (hero_id,name,description,damage_type,fixed_damage,is_passive) 
	VALUES (1,'APHOTIC SHIELD','Summons dark energies around an ally unit, creating an all damage barrier that absorbs a set amount of damage before expiring. When the barrier is destroyed it will burst and deal damage equal to the amount it could absorb to an area around it. Removes certain types of negative buffs and stuns on cast.','Magical',210,FALSE);

INSERT INTO ability (hero_id,name,description,damage_type,fixed_damage,is_passive) 
	VALUES (1,'CURSE OF AVERNUS','Abaddon strikes an enemy, slowing the target movement speed. If the target gets hit 4 times, they become affected by a chilling curse causing them to take damage over time, be silenced and slowed, and all attacks against them gain an attack speed boost.','Magical',50,TRUE);

INSERT INTO ability (hero_id,name,description,damage_type,fixed_damage,is_passive) 
	VALUES (1,'BORROWED TIME','When activated, all damage dealt to you will heal instead of harm. Most negative buffs will also be removed. If the ability is not on cooldown, it will automatically activate if your health falls below 400.','Magical',0,FALSE);

insert into ability ( hero_id, name, description, damage_type, fixed_damage, is_passive)
	values(2,'ACID SPRAY','Sprays high-pressure acid across a target area. Enemy units who step across the contaminated terrain take damage per second and have their armor reduced.', 'Physical',40, FALSE);

insert into ability ( hero_id, name, description, damage_type, fixed_damage, is_passive)
	values(2,'UNSTABLE CONCOCTION','Alchemist brews up an unstable concoction that he can throw at an enemy hero, to stun and deal damage in an area around the explosion. The longer the concoction brews, the more damage it deals and the longer the stun. Alchemist is faster while charging the concoction. After 5 seconds, the brew reaches its maximum damage and stun time. However, after 5.5 seconds, the concoction will explode on Alchemist himself if not thrown.', 'Physical',360, FALSE);

insert into ability ( hero_id, name, description, damage_type, fixed_damage, is_passive)
	values(2,'CORROSIVE WEAPONRY','Alchemist coats his weapons with an acid that applies a stacking slow and status resistance reduction to enemies hit. Slow and Status resistance increases when Alchemist is under the effect of Chemical Rage.', 'No',0, TRUE);

insert into ability ( hero_id, name, description, damage_type, fixed_damage, is_passive)
	values(2,'GREEVIL GREED','Alchemist synthesizes additional gold from his enemies and bounty runes. With each kill, Alchemist earns base bonus gold and extra bonus gold. If Alchemist kills another unit which yields gold within the next 36 seconds, an additional instance of Extra Bonus Gold is added to the total. Additionally, causes bounty runes to yield more gold.', 'No',0, TRUE);

insert into ability ( hero_id, name, description, damage_type, fixed_damage, is_passive)
	values(2,'CHEMICAL RAGE','Alchemist causes his Ogre to enter a chemically induced rage, reducing base attack cooldown and increasing movement speed and health regeneration.', 'No',0, FALSE);