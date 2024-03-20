create table inventory(
    id bigserial not null primary key,
    build_effectivity float not null CHECK (build_effectivity >= 0 AND build_effectivity <= 100)
);