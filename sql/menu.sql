create table menu (
    cafeteria varchar(10) not null,
    date date  not null,
    day varchar(5) not null,
    price varchar(10) not null,
    lunchOrDinner varchar(5) not null,
    menu01 varchar(20) not null,
    menu02 varchar(20) not null,
    menu03 varchar(20) not null,
    menu04 varchar(20) not null,
    menu05 varchar(20) not null,
    menu06 varchar(20) not null,

    primary key (date, lunchOrDinner)MENU
);