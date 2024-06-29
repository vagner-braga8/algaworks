set foreign_key_checks = 0;

delete from cidade;
delete from cozinha;
delete from estado;
delete from forma_pagamento;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;
delete from usuario_grupo;

set foreign_key_checks = 1;

ALTER TABLE cidade AUTO_INCREMENT = 1;
ALTER TABLE cozinha AUTO_INCREMENT = 1;
ALTER TABLE estado AUTO_INCREMENT = 1;
ALTER TABLE forma_pagamento AUTO_INCREMENT = 1;
ALTER TABLE grupo AUTO_INCREMENT = 1;
ALTER TABLE permissao AUTO_INCREMENT = 1;
ALTER TABLE produto AUTO_INCREMENT = 1;
ALTER TABLE restaurante AUTO_INCREMENT = 1;
ALTER TABLE usuario AUTO_INCREMENT = 1;

insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Argentina');
insert into cozinha (nome) values ('Brasileira');

insert into estado (nome) values ('Rio Grande do Sul');
insert into estado (nome) values ('Santa Catarina');
insert into estado (nome) values ('São Paulo');

insert into cidade (nome, estado_id) values ('Florianópolis', 2);
insert into cidade (nome, estado_id) values ('Porto Alegre', 1);
insert into cidade (nome, estado_id) values ('Campinas', 3);

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values ('Thai Delights', 12.00, 1, utc_timestamp,utc_timestamp, 2, '88000-000', 'Rua das Delícias', '123', 'Sala 101', 'Centro');
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values ('Indian Spice', 11.50, 2, utc_timestamp,utc_timestamp, 1, '90000-000', 'Av. das Especiarias', '456', 'Andar 2', 'Centro');
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values ('Sushi World', 13.25, 3, utc_timestamp,utc_timestamp, 3, '13000-000', 'Alameda dos Sushis', '789', 'Loja 5', 'Jardins');

INSERT INTO forma_pagamento (nome) VALUES ('Cartão de Crédito');
INSERT INTO forma_pagamento (nome) VALUES ('Boleto Bancário');
INSERT INTO forma_pagamento (nome) VALUES ('Transferência Bancária');
INSERT INTO forma_pagamento (nome) VALUES ('PayPal');
INSERT INTO forma_pagamento (nome) VALUES ('Pix');
INSERT INTO forma_pagamento (nome) VALUES ('Dinheiro');

INSERT INTO permissao (nome, descricao) VALUES ('Consultar Produtos', 'Permite a consulta de produtos.');

INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES (1, 1), (1, 3), (2, 1), (2, 2), (2, 5), (3, 1), (3, 4), (3, 6);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sushi de Salmão', 'Delicioso sushi de salmão fresco', 15.00, true, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Curry de Frango', 'Frango ao molho curry com arroz basmati', 20.00, true, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Pad Thai', 'Macarrão de arroz frito com camarão', 18.00, true, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife de Chorizo', 'Bife de chorizo grelhado', 30.00, true, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Empanadas', 'Empanadas argentinas', 10.00, true, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Feijoada', 'Feijoada completa com arroz, farofa e couve', 25.00, true, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Moqueca de Peixe', 'Moqueca de peixe com pirão e arroz', 28.00, true, 3);



