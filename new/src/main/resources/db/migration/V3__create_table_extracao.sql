create table extracao(
    id SERIAL PRIMARY KEY NOT NULL,
    titulo varchar(50) not null,
    descricao varchar(300) not null,
    data_solicitacao timestamp not null,
    status varchar(20) not null,
    minerio_id int REFERENCES minerio(id),
    area_id int REFERENCES area(id)
);
