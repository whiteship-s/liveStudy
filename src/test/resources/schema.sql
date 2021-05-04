create table comment
(
    id             bigint not null,
    content        varchar(255),
    create_at      datetime,
    emoji_num      integer,
    heart_flag     bit    not null,
    leader_comment varchar(255),
    study_info_id  bigint,
    update_at      datetime,
    user_id        bigint,
    primary key (id)
) engine=InnoDB

create table rank
(
    id         bigint not null,
    created_at datetime,
    rank_col   varchar(255),
    updated_at datetime,
    primary key (id)
) engine=InnoDB

create table study_info
(
    id         bigint not null,
    created_at datetime,
    goal       varchar(255),
    learn      varchar(255),
    updated_at datetime,
    week       varchar(255),
    primary key (id)
) engine=InnoDB

create table user
(
    id        bigint not null,
    blog_type varchar(255),
    nickname  varchar(255),
    uri       varchar(255),
    primary key (id)
) engine=InnoDB
