-- liquibase formatted sql

-- changeset facenac:1

create table usuario (
    id		integer 	not null	auto_increment,
    nome	varchar(50)	not null,
    email	varchar(50)	not null,
    senha	varchar(50)	not null,
    foto	blob 		null,
    primary key (id)
);

create table historia (
    id		integer 	not null	auto_increment,
    usuario	integer		not null,
    texto	varchar(3000)	null,
    foto	blob 		null,
    data	timestamp	not null	default now(),
    primary key (id),
    foreign key (usuario) references usuario (id)
);

create table amizade (
    usuario1    integer		not null,
    usuario2    integer         not null,
    aprovada	boolean         not null	default 0,
    primary key (usuario1, usuario2),
    foreign key (usuario1) references usuario (id),
    foreign key (usuario2) references usuario (id)
);

create table curtida (
    usuario	integer		not null,
    historico   integer		not null,
    primary key (usuario, historico),
    foreign key (usuario) references usuario (id),
    foreign key (historico) references historia (id)
);

create table comentario (
    id          integer 	not null    auto_increment,
    usuario	integer		not null,   -- original null?
    historico	integer		not null,   -- original null?
    texto       varchar(3000)	null,
    data	timestamp	not null    default now(),
    primary key (id),
    foreign key (usuario) references usuario (id),
    foreign key (historico) references historia (id)
);

-- rollback drop table comentario;
-- rollback drop table curtida;
-- rollback drop table historia;
-- rollback drop table amizade;
-- rollback drop table usuario;

-- changeset facenac:2 context:test

insert into usuario (id, nome, email, senha) values (1, 'Usuário 1', 'usuario1@facenac.com.br', password('senha1'));
insert into usuario (id, nome, email, senha) values (2, 'Usuário 2', 'usuario2@facenac.com.br', password('senha2'));
insert into usuario (id, nome, email, senha) values (3, 'Usuário 3', 'usuario3@facenac.com.br', password('senha3'));
insert into usuario (id, nome, email, senha) values (4, 'Usuário 4', 'usuario4@facenac.com.br', password('senha4'));
insert into usuario (nome, email, senha) values ('Usuário X', 'usuarioX@facenac.com.br', password('senhaX'));

insert into amizade values (1, 2, 1);
insert into amizade values (1, 3, 1);
insert into amizade values (2, 3, 0);
insert into amizade values (3, 4, 1);

insert into historia (id, usuario, texto, data) values (1, 1, 'Texto 1 do usuário 1', '2018-01-01 20:45:00');
insert into historia (id, usuario, texto, data) values (2, 1, 'Texto 2 do usuário 1', '2018-01-02 20:45:00');
insert into historia (id, usuario, texto, data) values (3, 1, 'Texto 3 do usuário 1', '2018-01-03 20:45:00');
insert into historia (id, usuario, texto, data) values (4, 2, 'Texto 1 do usuário 2', '2018-02-01 20:45:00');
insert into historia (id, usuario, texto, data) values (5, 2, 'Texto 2 do usuário 2', '2018-02-02 20:45:00');
insert into historia (id, usuario, texto, data) values (6, 2, 'Texto 3 do usuário 2', '2018-02-03 20:45:00');
insert into historia (id, usuario, texto, data) values (7, 3, 'Texto 1 do usuário 3', '2018-03-01 20:45:00');
insert into historia (id, usuario, texto, data) values (8, 3, 'Texto 2 do usuário 3', '2018-03-02 20:45:00');
insert into historia (id, usuario, texto, data) values (9, 3, 'Texto 3 do usuário 3', '2018-03-03 20:45:00');
insert into historia (id, usuario, texto, data) values (10, 4, 'Texto 1 do usuário 4', '2018-04-01 20:45:00');
insert into historia (id, usuario, texto, data) values (11, 4, 'Texto 2 do usuário 4', '2018-04-02 20:45:00');
insert into historia (id, usuario, texto, data) values (12, 4, 'Texto 3 do usuário 4', '2018-04-03 20:45:00');
insert into historia (id, usuario, texto, data) values (13, 1, 'Texto 4 do usuário 1', '2018-01-04 20:45:00');
insert into historia (id, usuario, texto, data) values (14, 1, 'Texto 5 do usuário 1', '2018-01-05 20:45:00');
insert into historia (id, usuario, texto, data) values (15, 1, 'Texto 6 do usuário 1', '2018-01-06 20:45:00');
insert into historia (id, usuario, texto, data) values (16, 1, 'Texto 7 do usuário 1', '2018-01-07 20:45:00');
insert into historia (id, usuario, texto, data) values (17, 1, 'Texto 8 do usuário 1', '2018-01-08 20:45:00');
insert into historia (id, usuario, texto, data) values (18, 1, 'Texto 9 do usuário 1', '2018-01-09 20:45:00');
insert into historia (id, usuario, texto, data) values (19, 1, 'Texto 10 do usuário 1', '2018-01-10 20:45:00');
insert into historia (id, usuario, texto, data) values (20, 1, 'Texto 11 do usuário 1', '2018-01-11 20:45:00');
insert into historia (id, usuario, texto, data) values (21, 1, 'Texto 12 do usuário 1', '2018-01-12 20:45:00');
insert into historia (id, usuario, texto, data) values (22, 1, 'Texto 13 do usuário 1', '2018-01-13 20:45:00');
insert into historia (id, usuario, texto, data) values (23, 1, 'Texto 14 do usuário 1', '2018-01-14 20:45:00');
insert into historia (id, usuario, texto, data) values (24, 1, 'Texto 15 do usuário 1', '2018-01-15 20:45:00');
insert into historia (id, usuario, texto, data) values (25, 1, 'Texto 16 do usuário 1', '2018-01-16 20:45:00');
insert into historia (id, usuario, texto, data) values (26, 1, 'Texto 17 do usuário 1', '2018-01-17 20:45:00');
insert into historia (id, usuario, texto, data) values (27, 1, 'Texto 18 do usuário 1', '2018-01-18 20:45:00');
insert into historia (id, usuario, texto, data) values (28, 1, 'Texto 19 do usuário 1', '2018-01-19 20:45:00');
insert into historia (id, usuario, texto, data) values (29, 1, 'Texto 20 do usuário 1', '2018-01-20 20:45:00');
insert into historia (id, usuario, texto, data) values (30, 1, 'Texto 21 do usuário 1', '2018-01-21 20:45:00');
insert into historia (id, usuario, texto, data) values (31, 1, 'Texto 22 do usuário 1', '2018-01-22 20:45:00');
insert into historia (id, usuario, texto, data) values (32, 1, 'Texto 23 do usuário 1', '2018-01-23 20:45:00');
insert into historia (id, usuario, texto, data) values (33, 1, 'Texto 24 do usuário 1', '2018-01-24 20:45:00');
insert into historia (id, usuario, texto, data) values (34, 1, 'Texto 25 do usuário 1', '2018-01-25 20:45:00');
insert into historia (id, usuario, texto, data) values (35, 1, 'Texto 26 do usuário 1', '2018-01-26 20:45:00');
insert into historia (id, usuario, texto, data) values (36, 1, 'Texto 27 do usuário 1', '2018-01-27 20:45:00');
insert into historia (id, usuario, texto, data) values (37, 1, 'Texto 28 do usuário 1', '2018-01-28 20:45:00');
insert into historia (id, usuario, texto, data) values (38, 1, 'Texto 29 do usuário 1', '2018-01-29 20:45:00');

insert into curtida values (1, 4);
insert into curtida values (1, 5);
insert into curtida values (3, 10);
insert into curtida values (3, 11);

insert into comentario values (1, 1, 4, 'Comentário 1 do usuário 1 no histórico 1 do usuário 2', '2018-05-01 20:45:00');
insert into comentario values (2, 1, 6, 'Comentário 2 do usuário 1 no histórico 3 do usuário 2', '2018-05-01 21:45:00');
insert into comentario values (3, 3, 11, 'Comentário 1 do usuário 3 no histórico 2 do usuário 4', '2018-05-01 22:45:00');

-- rollback delete from comentario;
-- rollback delete from curtida;
-- rollback delete from historia;
-- rollback delete from amizade;
-- rollback delete from usuario;
