create table likes
(
    id            serial not null,
    user_id       integer,
    liked_user_id integer
);
