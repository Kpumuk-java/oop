
create table films (
                       id                      bigserial primary key,
                       name                    varchar(256) not null,
                       time                    int not null
);

create table time_session (
                              id                      bigserial primary key,
                              film_id                 bigint not null references films (id),
                              begin_film              timestamp
);

create table tickets (
                         id                      bigserial primary key,
                         session_id              bigint not null references time_session(id),
                         cost                    int
);

insert into films (name, time)
values
('Назад в будущее', 120),
('Мстители', 120),
('Еда атакует', 90),
('Последний герой', 600),
('Том и Джери', 120);

insert into time_session (film_id, begin_film)
values
(1, '2021-06-07 09:00:00'),
(1, '2021-06-07 18:00:00'),
(2, '2021-06-07 12:00:00'),
(2, '2021-06-07 15:00:00'),
(3, '2021-06-08 09:00:00'),
(3, '2021-06-08 18:00:00'),
(4, '2021-06-08 12:00:00'),
(4, '2021-06-08 15:00:00'),
(5, '2021-06-09 09:00:00'),
(5, '2021-06-09 12:00:00'),
(5, '2021-06-09 15:00:00'),
(5, '2021-06-09 18:00:00');

insert into tickets (session_id, cost)
values
(1, 150), (3, 200), (3, 200), (3, 200), (4, 250), (4, 250), (4, 250), (4, 250), (5, 200), (5, 200), (5, 200),
(1, 150), (6, 250), (6, 250), (6, 250), (7, 200), (7, 200), (7, 200), (7, 200), (8, 250), (8, 250), (8, 250),
(1, 150), (9, 200), (9, 200), (9, 200), (9, 200), (9, 200), (10, 200), (10, 200), (11, 300), (11, 300), (11, 300), (11, 300),
(2, 250),  (11, 300), (11, 300), (11, 300), (11, 300),  (12, 300), (12, 300), (12, 300), (12, 300), (12, 300),
(2, 250);

WITH interval as (
    select A.film_id,
           A.id as session_id,
           B.name,
           A.begin_film,
           DATEADD('MINUTE', + B.time, A.begin_film) as end_time
    from time_session A
    inner join films B on A.film_id = B.id)
select I1.name, I1.begin_film, I1.end_time,
       I2.name, I2.begin_film, I2.end_time
from interval I1
inner join interval I2 on I1.begin_film < I2.end_time AND I1.end_time > I2.begin_film
    AND I1.session_id != I2.session_id;


