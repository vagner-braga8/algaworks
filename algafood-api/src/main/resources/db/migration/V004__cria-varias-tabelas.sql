create table forma_pagamento (
	id bigint not null auto_increment,
 	nome varchar(80) not null,
  	primary key (id)
) engine=InnoDB default charset=utf8;

create table grupo (
	id bigint not null auto_increment,
 	nome varchar(80) not null,
  	primary key (id)
) engine=InnoDB default charset=utf8;

create table permissao (
	id bigint not null auto_increment, 
	descricao varchar(80) not null, 
	nome varchar(80) not null, 
	primary key (id)
) engine=InnoDB default charset=utf8;

create table grupo_permissao (
	grupo_id bigint not null, 
	permissao_id bigint not null,
	primary key (grupo_id, permissao_id),
	constraint FK_grupo_permissao_grupo foreign key (grupo_id) references grupo (id),
	constraint FK_grupo_permissao_permissao foreign key (permissao_id) references permissao (id)
) engine=InnoDB default charset=utf8;

create table restaurante (
	id bigint not null auto_increment, 
	taxa_frete decimal(38,2) not null, 
	cozinha_id bigint not null, 
	data_atualizacao datetime not null, 
	data_cadastro datetime not null, 
	endereco_cidade_id bigint, 
	endereco_bairro varchar(80), 
	endereco_cep varchar(80), 
	endereco_complemento varchar(80), 
	endereco_logradouro varchar(80), 
	endereco_numero varchar(80), 
	nome varchar(80) not null, 
	primary key (id),
	constraint FK_restaurante_cozinha foreign key (cozinha_id) references cozinha (id),
	constraint FK_restaurante_endereco_cidade foreign key (endereco_cidade_id) references cidade (id)
) engine=InnoDB default charset=utf8;

create table produto (
	id bigint not null auto_increment, 
	ativo bit not null, 
	preco decimal(38,2) not null, 
	restaurante_id bigint not null, 
	descricao varchar(80) not null, 
	nome varchar(80) not null, 
	primary key (id),
	constraint FK_produto_restaurante foreign key (restaurante_id) references restaurante (id)
) engine=InnoDB default charset=utf8;

create table restaurante_forma_pagamento (
	forma_pagamento_id bigint not null, 
	restaurante_id bigint not null,
	primary key (forma_pagamento_id, restaurante_id),
	constraint FK_restaurante_forma_pagamento_forma_pagamento foreign key (forma_pagamento_id) references forma_pagamento (id),
	constraint FK_restaurante_forma_pagamento_restaurante foreign key (restaurante_id) references restaurante (id)
) engine=InnoDB default charset=utf8;

create table usuario (
	id bigint not null auto_increment, 
	data_cadastro datetime not null, 
	email varchar(80) not null, 
	nome varchar(80) not null, 
	senha varchar(80) not null, 
	primary key (id)
) engine=InnoDB default charset=utf8;

create table usuario_grupo (
	grupo_id bigint not null, 
	usuario_id bigint not null,
	primary key (grupo_id, usuario_id),
	constraint FK_usuario_grupo_grupo foreign key (grupo_id) references grupo (id),
	constraint FK_usuario_grupo_usuario foreign key (usuario_id) references usuario (id)
) engine=InnoDB default charset=utf8;
