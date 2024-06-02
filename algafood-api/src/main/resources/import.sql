insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Japonesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delights', 12.00, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Indian Spice', 11.50, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Sushi World', 13.25, 3);

insert into estado (nome) values ('Rio Grande do Sul');
insert into estado (nome) values ('Santa Catarina');
insert into estado (nome) values ('São Paulo');

insert into cidade (nome, estado_id) values ('Florianópolis', 2);
insert into cidade (nome, estado_id) values ('Porto Alegre', 1);
insert into cidade (nome, estado_id) values ('Campinas', 3);

INSERT INTO forma_pagamento (nome) VALUES ('Cartão de Crédito');
INSERT INTO forma_pagamento (nome) VALUES ('Boleto Bancário');
INSERT INTO forma_pagamento (nome) VALUES ('Transferência Bancária');
INSERT INTO forma_pagamento (nome) VALUES ('PayPal');
INSERT INTO forma_pagamento (nome) VALUES ('Pix');
INSERT INTO forma_pagamento (nome) VALUES ('Dinheiro');

INSERT INTO permissao (nome, descricao) VALUES ('Consultar Produtos', 'Permite a consulta de produtos.');

