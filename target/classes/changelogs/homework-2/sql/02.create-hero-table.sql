create table hero(
    id bigserial not null,
    name varchar(20) not null,
    win_rate float not null CHECK (win_rate >= 0 AND win_rate <= 100),
    pick_rate float not null CHECK (pick_rate >= 0 AND pick_rate <= 100),
    picked_times bigint not null,
    strength bigint not null,
    agility bigint not null,
    intelligence bigint not null,
    PRIMARY KEY(id)
);
