create database softgia;
use softgia;

create table agenda(
Cod_Agenda int auto_increment not null,
Data_Agenda date not null,
Hora_Agenda time not null,
Local_Servico varchar(40) not null,
Descricao_Servico text,
primary key (Cod_Agenda)
)default charset=utf8;

create table cliente(
Cod_Cliente int auto_increment not null,
Nome_Cliente varchar(40) not null,
Cpf_Cliente int,
Endereco_Cliente varchar(45),
Complemento_Cliente varchar(15) not null,
Telefone_Cliente int not null,
Rg_Cliente int,
primary key (Cod_Cliente)
)default charset=utf8;

create table pagamento(
Cod_Pagamento int auto_increment not null,
Tipo_Pagamento varchar(15) not null,
Situacao_Cliente varchar(15) not null,
Valor_Pagamento double not null,
primary key (Cod_Pagamento)
)default charset=utf8;

create table extra(
Cod_Servico int auto_increment not null,
Nome_Parceria varchar(45) not null,
Acordo_Servico varchar(45) not null,
Descricao_Servico text,
Valor_Servico double,
primary key (Cod_Servico)
)default charset=utf8;

select*from agenda;
select*from cliente;
select*from pagamento;
select*from extra;

alter table agenda
add column Cod_Cli int;

alter table agenda
add foreign key Cod_Cli
references cliente;

alter table agenda
add column Cod_Serv int;

alter table agenda
add foreign key Cod_Serv
references extra;

alter table pagamento
add column Cod_Age int;

alter table pagamento
add foreign key Cod_Age
references agenda;

alter table pagamento
add column Cod_Cli int;

alter table pagamento
add foreign key Cod_Cli
references cliente;