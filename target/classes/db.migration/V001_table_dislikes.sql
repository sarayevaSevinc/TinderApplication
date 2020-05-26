create table dislikes
(
    id            serial not null
        constraint dislikes_pk
            primary key,
    user_id       integer
        constraint likesfrom_users_id_fk
            references users,
    liked_user_id integer
        constraint likesto_users_id_fk
            references users
);