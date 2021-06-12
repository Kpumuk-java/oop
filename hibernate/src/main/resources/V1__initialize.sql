create table student (
     id                      bigserial primary key not null,
     name                    varchar(512) not null,
     mark                    int not null
);

insert into student (name, mark)
values
('John', 5),
('Tom', 3);
