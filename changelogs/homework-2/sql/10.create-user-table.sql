create table "user"(
    id bigserial not null primary key,
    name varchar(30) not null,
    password varchar(64) not null,
    steam_api_key varchar(255) not null,
    description varchar(64) not null,
    mmr smallint not null
);