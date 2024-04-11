create table talant_tree(
    id bigserial not null primary key,
    hero_id bigint not null,
    level_required smallint not null,
    cells jsonb not null,
    foreign key(hero_id) references hero(id)
);
