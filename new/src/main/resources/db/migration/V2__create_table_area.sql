create table area(
    id SERIAL PRIMARY KEY NOT NULL,
    nome varchar(50) not null,
    endereco varchar(50) not null
);

insert into area values(1,'Area3', 'BR155');