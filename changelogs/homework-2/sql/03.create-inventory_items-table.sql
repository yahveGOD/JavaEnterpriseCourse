create table inventory_items(
    id bigserial not null,
    item_id bigint not null,
    inventory_id bigint not null,
    primary key(id),
    foreign key(item_id) references item(id),
    foreign key(inventory_id) references inventory(id)
);
