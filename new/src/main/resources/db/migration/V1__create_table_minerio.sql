create table minerio(
    id SERIAL PRIMARY KEY NOT NULL,
    nome varchar(50) not null,
    tipo varchar(50) not null
);

insert into minerio values(1,'pedra', 'lisa');
insert into minerio values(2,'pedregulho', 'sujo');