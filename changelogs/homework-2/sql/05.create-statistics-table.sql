create table statistics(
    id bigserial not null primary key,
    kills bigint not null,
    deaths bigint not null,
    assists bigint not null,
    networth bigint not null
);
