CREATE TABLE clientes ( 
	codigo               integer PRIMARY KEY AUTOINCREMENT,
	numero               integer     ,
	estado               char(2)     ,
	cep                  varchar(100)     ,
	cidade               varchar(100)     ,
	bairro               varchar(100)     ,
	lagradouro           varchar(100)     ,
	nome                 varchar(100)     
 );

CREATE TABLE fisica ( 
	cpf                  varchar(12)     ,
	estado_civil         varchar(100)     ,
	data_nascimento      varchar(8)     ,
	codigo               integer     ,
	CONSTRAINT sqlite_autoindex_fisica_1 UNIQUE ( cpf ) ,
	FOREIGN KEY ( codigo ) REFERENCES clientes( codigo )  
 );

CREATE TABLE juridica ( 
	cnpj                 varchar(100)     ,
	codigo               integer     ,
	CONSTRAINT sqlite_autoindex_juridica_1 UNIQUE ( cnpj ) ,
	FOREIGN KEY ( codigo ) REFERENCES clientes( codigo )  
 );

CREATE TABLE funcionarios ( 
	ra                   integer PRIMARY KEY AUTOINCREMENT,
	nome                 varchar(100)     ,
	estado_civil         varchar(100)     ,
	cargo                varchar(100)     ,
	estado               char(2)     ,
	cep                  varchar(100)     ,
	cidade               varchar(100)     ,
	numero               integer     ,
	bairro               varchar(100)     ,
	lagradouro           varchar(100)     ,
	data_nascimento      varchar(100)     ,
	salario              decimal(10)     
 );

CREATE TABLE login ( 
	usuario              varchar(30) NOT NULL    ,
	senha                varchar(30)     ,
	ra                   integer NOT NULL    ,
	FOREIGN KEY ( ra ) REFERENCES funcionarios( ra )  
 );

CREATE TABLE pedidos ( 
	codigo_pedido        integer PRIMARY KEY AUTOINCREMENT,
	entrega              char(1)     ,
	cep                  varchar(100)     ,
	numero               integer     ,
	cidade               varchar(100)     ,
	logradouro           varchar(100)     ,
	telefone             varchar(100)     ,
	codigo               integer     ,
	bairro               varchar(100)     ,
	valor                decimal(10)     ,
	status               varchar(255) NOT NULL DEFAULT 'Pendente'   ,
	criado_em            timestamp  DEFAULT CURRENT_TIMESTAMP   ,
	FOREIGN KEY ( codigo ) REFERENCES clientes( codigo )  
 );

CREATE TABLE produtos ( 
	codigo_produto       integer PRIMARY KEY AUTOINCREMENT,
	nome                 varchar(100)     ,
	quantidade           integer     ,
	valor                decimal(10)     
 );

CREATE TABLE entregas ( 
	codigo               integer PRIMARY KEY AUTOINCREMENT,
	codigo_pedido        integer NOT NULL UNIQUE,
	valor                double(10,2) NOT NULL    ,
	criado_em            datetime  DEFAULT CURRENT_TIMESTAMP   ,
	status               varchar(255) NOT NULL DEFAULT 'Pendente'   ,
	FOREIGN KEY ( codigo_pedido ) REFERENCES pedidos( codigo_pedido ) ON DELETE CASCADE 
 );

CREATE TABLE pedido_tem_produto ( 
	codigo_produto       integer NOT NULL    ,
	quantidade           integer NOT NULL    ,
	codigo_pedido        integer NOT NULL    ,
	valor                double(10,2) NOT NULL    ,
	FOREIGN KEY ( codigo_produto ) REFERENCES produtos( codigo_produto )  ,
	FOREIGN KEY ( codigo_pedido ) REFERENCES pedidos( codigo_pedido )  
 );



INSERT INTO funcionarios( ra, nome, estado_civil, cargo, estado, cep, cidade, numero, bairro, lagradouro, data_nascimento, salario ) VALUES ( 1, 'Test', 'Viuvo(A)', 'Dev', 'SP', '00000-000', 'São Paulo', 123, 'qualquer', 'qualquer', '12/1/2000', 12345.56);
INSERT INTO login( usuario, senha, ra ) VALUES ( 'admin', 'admin', 1);

INSERT into sqlite_sequence(name,seq)VALUES('produtos',0);

INSERT into sqlite_sequence(name,seq)VALUES('pedidos',0);

INSERT into sqlite_sequence(name,seq)VALUES('entregas',0);

INSERT into sqlite_sequence(name,seq)VALUES('clientes',0);