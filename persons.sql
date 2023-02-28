CREATE TABLE IF NOT EXISTS persons
(
    name           varchar,
    surname        varchar,
    age            int,
    phone_number   varchar,
    city_of_living varchar,
    primary key (name, surname, age)
);

SELECT name, surname
FROM persons
WHERE city_of_living = 'Moscow';

SELECT *
FROM persons
WHERE age > 27
ORDER BY age DESC;
