create table statistics(
    id bigserial not null primary key,
    kills bigint not null CHECK (kills >= 0),
    deaths bigint not null CHECK (deaths >= 0),
    assists bigint not null CHECK (assists >= 0),
    networth bigint not null CHECK (networth >= 0)
);
