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

alter table users
    owner to postgres;

create unique index users_id_uindex
    on users (id);




create table likes
(
    id       serial not null
        constraint likes_pk
            primary key,
    userfrom integer
        constraint likesfrom_users_id_fk
            references users,
    userto   integer
        constraint likesto_users_id_fk
            references users
);

alter table likes
    owner to postgres;

create unique index likes_id_uindex
    on likes (id);



    create table dislikes
(
    id       serial not null
        constraint dislikes_pk
            primary key,
    userfrom integer
        constraint likesfrom_users_id_fk
            references users,
    userto   integer
        constraint likesto_users_id_fk
            references users
);

alter table dislikes
    owner to postgres;
