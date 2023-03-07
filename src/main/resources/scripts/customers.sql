create table if not exists CUSTOMERS
(
    id           bigserial primary key,
    name         varchar(30),
    surname      varchar(30),
    age          int,
    phone_number varchar(11)
);