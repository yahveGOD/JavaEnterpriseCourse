create table match(
    id bigserial not null primary key,
    duration time not null,
    victory_side varchar(100) not null,
    game_mode_id bigint,
    radiant_kills bigint not null,
    dire_kills bigint not null,
    foreign key(game_mode_id) references game_mode(id)
);
