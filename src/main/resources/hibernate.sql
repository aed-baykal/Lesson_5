drop table if exists student CASCADE;
create table if not exists student
(
    id                 bigserial primary key,
    name               varchar(255),
    mark              int
);

insert into student (name, mark)
values  ('Андрей', 2),
        ('Антон', 3),
        ('Иван', 4),
        ('Дмитрий', 3),
        ('Сергей', 4),
        ('Семен', 3),
        ('Анна', 4),
        ('Елена', 3),
        ('Мария', 4),
        ('Ирина', 3);