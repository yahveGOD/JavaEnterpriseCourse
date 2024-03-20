explain select * from talant_tree tt  join hero h  
on tt.hero_id = h.id
where h.id = 1

explain select * from ability a join hero h  
on a.hero_id = h.id
where h.id = 1

explain select * from items_in_inventory iii  join inventory i  
on iii.inventory_id = i.id
where i.id = 1


explain select * from items_in_inventory iii  join item i  
on iii.item_id = i.id
where i.id = 1


explain select * from users_roles ur  join "user" u 
on ur.user_id = u.id
where u.id = 1


explain select * from users_roles ur  join "role" r 
on ur.role_id = r.id
where r.id = 1


explain select * from matches_history mh  join "match" m 
on mh.match_id = m.id
where m.id = 1


explain select * from matches_history mh  join "user" u  
on mh.user_id = u.id
where u.id = 1


explain select * from replay r  join "match" m  
on r.match_id = m.id
where m.id = 1

explain select * from picked_hero ph  join hero h  
on ph.hero_id = h.id
where h.id = 1

explain select * from picked_hero ph  join "match" m  
on ph.match_id = m.id
where m.id = 1


explain select * from picked_hero ph  join "user" u  
on ph.user_id = u.id
where u.id = 1


explain select * from picked_hero ph  join "statistics" s  
on ph.statistics_id = s.id
where s.id = 1


explain select * from picked_hero ph  join inventory i  
on ph.inventory_id = i.id
where i.id = 1
