create table matches_history(
    id bigserial not null primary key,
    match_id bigint not null,
    user_id bigint not null,
    foreign key(match_id) references match(id),
    foreign key(user_id) references "user"(id)

);
