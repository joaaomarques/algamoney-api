CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(200),
	numero VARCHAR(10),
	complemento VARCHAR(250),
	bairro VARCHAR(50),
	cep VARCHAR(8),
	cidade VARCHAR(50),
	estado VARCHAR(20),	
	ativo BOOLEAN NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET = utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Alan', 'rua 1', '1', 'Bloco 1', 'Cajazeiras', '11111111', 'Salvador','BA', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João', 'rua 2', '2','Bloco 2', 'Cabula', '22222222', 'Salvador','BA', false);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Lucas', 'rua 3', '3', 'Bloco 3', 'Pituba', '33333333', 'Salvador','BA', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Filipe', 'rua 4', '4','Bloco 4', 'Brotas', '44444444', 'Salvador','BA', false);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro', 'rua 5', '5', 'Bloco 5', 'Caminho das Árvores', '55555555', 'Salvador','BA', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João Paulo', 'rua 6', '6', 'Bloco 6', 'Cabula', '66666666', 'Salvador','BA', false);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Camila', 'rua 7', '7', 'Bloco 7','Imbuí', '77777777', 'Salvador','BA', true);