create table item(
    id bigserial not null primary key,
    name varchar(60) not null,
    win_rate float not null CHECK (win_rate >= 0 AND win_rate <= 100),
    use_rate float not null CHECK (use_rate >= 0 AND use_rate <= 100),
    bought_times bigint not null,
    description varchar(1000) not null,
    ability_description varchar(1000) not null
);

