create database agenciaViagens;

use agenciaViagens;


CREATE TABLE Cliente (
    id_Cliente INTEGER PRIMARY KEY auto_increment,
    Nome VARCHAR(40),
    Cpf VARCHAR(11),
    Telefone VARCHAR(14)
);

CREATE TABLE Viagem (
    id_Viagem INTEGER PRIMARY KEY auto_increment,
    valor_Diaria FLOAT,
    data_Ida DATE,
    data_Volta DATE,
    Cliente_id_Cliente INTEGER,
    Destino_id_Destino INTEGER
);

CREATE TABLE Destino (
    id_Destino INTEGER PRIMARY KEY auto_increment,
    valor_Passagem FLOAT,
    cidade_Destino VARCHAR(100),
    nome_Destino VARCHAR(100)
);
 
ALTER TABLE Viagem ADD CONSTRAINT FK_Viagem_2
    FOREIGN KEY (Cliente_id_Cliente)
    REFERENCES Cliente (id_Cliente)
    ON DELETE CASCADE;
 
ALTER TABLE Viagem ADD CONSTRAINT FK_Viagem_3
    FOREIGN KEY (Destino_id_Destino)
    REFERENCES Destino (id_Destino)
    ON DELETE CASCADE;
    
    
    select * from cliente;
	select * from destino;
	select * from viagem;
    
    insert into cliente values (default,"Lucas","00055599941","22986532145");
	insert into cliente values (default,"Andrey","66612365478","2198654578");
    
    insert into destino values
    (default,2490.90, "Lisboa", "Portugal"),(default,3900.90, "Andorra-a-Velha","Andorra");
    
    insert into viagem values
    (default,225.50,"2023-09-20","2023-10-25",1,1),(default,136.40,"2023-09-25","2023-11-02",2,2);
    
    set sql_safe_updates = 0;
    