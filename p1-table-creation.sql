create schema ent_GGcritics;

set search_path to ent_GGCritics;

create table user_role (
    id int generated always as identity primary key,
    name varchar unique not null
);

create table app_user (
    id int generated always as identity primary key,
    first_name varchar not null,
    last_name varchar not null,
    email varchar unique not null,
    username varchar unique not null check(length(username) >= 4),
    password varchar not null,
    role_id int,

    constraint user_role_fk
    foreign key (role_id)
    references user_role(id)
);

create table game (
    id int generated always as identity primary key,
    title text not null,
    description text,
    average_score int,
    image varchar
);

create table review (
    id int generated always as identity primary key,
    title varchar not null,
    description text,
    average_score int check(average_score > 0 and average_score <= 10),
    image varchar,
    app_user_id int,
    game_id int,

    constraint app_user_fk
    foreign key (app_user_id)
    references app_user(id),

    constraint game_fk
    foreign key (game_id)
    references game(id)
);