create table if not exists ORDERS
(
    id           bigserial primary key,
    date         TIMESTAMP,
    customer_id  bigint references CUSTOMERS (id),
    product_name varchar(30),
    amount       bigint
);