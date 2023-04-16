-- H2 데이터 베이스 코드

drop table if exists menu CASCADE;
create table menu (
    id bigint generated by default as identity,
    cafeteria varchar(10) not null,
    date date  not null,
    day varchar(5) not null,
    price varchar(10) not null,
    lunch_Or_Dinner varchar(5) not null,
    menu01 varchar(20) not null,
    menu02 varchar(20) not null,
    menu03 varchar(20) not null,
    menu04 varchar(20) not null,
    menu05 varchar(20) not null,
    menu06 varchar(20) not null,

    primary key (id)
);

------------------------------------------------------------
-- MYSQL 데이터 베이스 코드

DROP TABLE IF EXISTS menu;
CREATE TABLE menu (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cafeteria VARCHAR(10) NOT NULL,
    date DATE NOT NULL,
    day VARCHAR(5) NOT NULL,
    price VARCHAR(10) NOT NULL,
    lunch_or_dinner VARCHAR(5) NOT NULL,
    menu01 VARCHAR(20) NOT NULL,
    menu02 VARCHAR(20) NOT NULL,
    menu03 VARCHAR(20) NOT NULL,
    menu04 VARCHAR(20) NOT NULL,
    menu05 VARCHAR(20) NOT NULL,
    menu06 VARCHAR(20) NOT NULL,

    PRIMARY KEY (id)
);