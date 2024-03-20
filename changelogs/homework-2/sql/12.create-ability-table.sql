create table ability(
    id bigserial not null primary key,
    hero_id bigint not null,
    name varchar(20) not null,
    description varchar(1000) not null,
    damage_type varchar(16) not null,
    fixed_damage bigint not null,
    is_passive boolean not null,
    foreign key(hero_id) references hero(id)

);