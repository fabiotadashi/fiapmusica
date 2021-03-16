create table TB_USUARIO(
   id int not null auto_increment,
   nome varchar(20),
   senha varchar(20),
   data_criacao timestamp not null,
   data_atualizacao timestamp not null,
   primary key (id)
)