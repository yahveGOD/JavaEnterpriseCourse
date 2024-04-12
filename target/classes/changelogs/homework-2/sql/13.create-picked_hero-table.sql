create table picked_hero(
    hero_id bigint not null,
    user_id bigint not null,
    match_id bigint not null,
    statistics_id bigint not null,
    inventory_id bigint not null,
    primary key(hero_id,match_id),
    foreign key(hero_id) references hero(id),
    foreign key(user_id) references "user"(id),
    foreign key(match_id) references match(id),
    foreign key(statistics_id) references statistics(id),
    foreign key(inventory_id) references inventory(id)
);