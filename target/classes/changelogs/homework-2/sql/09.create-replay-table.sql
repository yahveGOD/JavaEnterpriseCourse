create table replay(
    id bigserial not null primary key,
    steam_api_match_replay_key bigint not null,
    match_id bigint not null,
    foreign key(match_id) references match(id)
);
