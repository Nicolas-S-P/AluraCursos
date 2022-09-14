create table solicitacao(
    id serial PRIMARY KEY NOT NULL,
    titulo varchar(300) not null,
    data_solicitacao TIMESTAMP not null,
    extracao_id int REFERENCES extracao(id)
);

