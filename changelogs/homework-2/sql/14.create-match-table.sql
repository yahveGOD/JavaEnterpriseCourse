create table match(
    id bigserial not null primary key,
    duration time not null,
    victory_side varchar(20) not null,
    game_mode_id bigint not null,
    radiant_kills bigint not null,
    dire_kills bigint not null,
    foreign key(game_mode_id) references game_mode(id)
);
