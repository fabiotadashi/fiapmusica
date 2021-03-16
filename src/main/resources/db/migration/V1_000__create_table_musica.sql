create table TB_MUSICA(
    id int not null auto_increment,
    titulo varchar(100),
    duracao int,
    autor varchar(50),
    data_criacao timestamp not null,
    data_atualizacao timestamp not null,
    primary key (id)
)