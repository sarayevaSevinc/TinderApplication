create table users
(
    id       serial not null
        constraint users_pk
            primary key,
    username varchar,
    gender   varchar,
    password varchar,
    email    varchar,
    photo    varchar,
    position varchar
);