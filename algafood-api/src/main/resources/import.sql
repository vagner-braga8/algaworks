insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Japonesa');

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



