create database agenciaViagens;

use agenciaViagens;

CREATE TABLE cliente (
    id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(40),
    cpf VARCHAR(11),
    telefone VARCHAR(14)
);

CREATE TABLE viagem (
    id INTEGER PRIMARY KEY auto_increment,
    valor_Diaria DOUBLE,
    data_Ida date,
    data_Volta date,
    cliente_id INTEGER, 
    destino_id INTEGER
);

CREATE TABLE destino (
    id INTEGER PRIMARY KEY auto_increment,
    valor_Passagem DOUBLE,
    cidade VARCHAR(100),
    pais VARCHAR(100)
);
 
ALTER TABLE viagem ADD CONSTRAINT FK_Viagem_2
    FOREIGN KEY (cliente_id)
    REFERENCES cliente (id)
    ON DELETE CASCADE;
 
ALTER TABLE viagem ADD CONSTRAINT FK_Viagem_3
    FOREIGN KEY (destino_id)
    REFERENCES destino (id)
    ON DELETE CASCADE;
    
    -- consulta dos dados
    select * from cliente;
	select * from destino;
	select * from viagem;
    -- consulta por join
	select 
    cliente.nome,
    cliente.id as clienteId,
	destino.pais,
    destino.id as destinoId,
	destino.valor_Passagem,
	viagem.valor_Diaria, viagem.data_Ida, viagem.data_Volta
	from viagem
	left join cliente on viagem.cliente_id = cliente.id
	left join destino on viagem.destino_id = destino.id;
    
    -- adicionando dados
    insert into cliente (nome, cpf, telefone) values 
    ("Lucas","00055599941","22986532145"),
    ("Ramon","9873245465","3899885236"),
	("Andrey","66612365478","2198654578");
    
    insert into destino (valor_Passagem, cidade, pais) values
    (2490.90, "Lisboa", "Portugal"),
    (3900.90, "andorra-a-Velha","Andorra");
    
    insert into viagem (valor_Diaria, data_Ida, data_Volta, cliente_id, destino_id) values
    (225,"2023-09-20","2023-10-25",1,1),
    (136,"2023-09-25","2023-11-02",2,2);
    
    -- atualizando dados
    UPDATE cliente SET nome = 'lucas araujo', cpf = '06233665484', telefone = '2294744744' WHERE id = 1;
	UPDATE destino SET valor_Passagem = 2300.90, cidade = 'Rio de Janeiro', pais = 'Brasil' WHERE id = 1;
    
    
    -- deletando dados
    DELETE FROM cliente WHERE id = 1;
    DELETE FROM destino WHERE id = 1;
    DELETE FROM viagem WHERE id = 1;
    
    set sql_safe_updates = 0;
    