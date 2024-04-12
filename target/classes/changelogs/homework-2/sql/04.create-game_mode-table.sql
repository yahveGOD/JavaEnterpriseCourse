create table game_mode(
    id bigserial not null primary key,
    name varchar(20) not null,
    description varchar(1000) not null,
    is_event boolean,
    number_of_players smallint not null
);