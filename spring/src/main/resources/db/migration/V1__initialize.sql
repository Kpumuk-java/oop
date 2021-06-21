create table students (
    id                      bigserial primary key,
    name                    varchar(30) not null unique,
    age                     int,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);


insert into students (name, age)
values
('Josh', 20),
('Angel', 27),
('Jerry', 25);


