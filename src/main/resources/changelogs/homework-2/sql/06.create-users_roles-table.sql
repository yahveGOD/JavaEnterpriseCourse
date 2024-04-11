create table users_roles(
    user_id bigint not null,
    role_id bigint not null,
    Primary key (user_id,role_id),
    foreign key(user_id) references "user"(id),
    foreign key(role_id) references role(id)
);