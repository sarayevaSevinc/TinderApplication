create table messages
(
    id          serial not null,
    sender_id   integer,
    receiver_id integer,
    text        varchar,
    date        timestamp
);
