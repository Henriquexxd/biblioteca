DROP DATABASE IF EXISTS DBBIBLIOTECA;
CREATE DATABASE DBBIBLIOTECA;
USE DBBIBLIOTECA;

CREATE TABLE ENDERECO(
	IDENDERECO INT NOT NULL AUTO_INCREMENT,
    PAIS VARCHAR(45),
    ESTADO VARCHAR(2),
    CIDADE VARCHAR(50),
    BAIRRO VARCHAR(50),
    CEP VARCHAR(8),
    RUA VARCHAR(100),
    NUMERO VARCHAR(6),
    PRIMARY KEY (IDENDERECO)
);

CREATE TABLE TIPOUSUARIO(
	IDTIPOUSUARIO INT NOT NULL AUTO_INCREMENT,
    DESCRICAO VARCHAR(45),
    PRIMARY KEY (IDTIPOUSUARIO)   
);

CREATE TABLE USUARIO(
	IDUSUARIO INT NOT NULL AUTO_INCREMENT,
    IDENDERECO INT,
    IDTIPOUSUARIO INT,
    NOME VARCHAR(200),
    CPF VARCHAR(11),
    TELEFONE VARCHAR(11),
    DTCADASTRO DATE,
    LOGIN VARCHAR(50),
    SENHA VARCHAR(20),
    PRIMARY KEY (IDUSUARIO),     
  
    FOREIGN KEY (IDENDERECO) REFERENCES ENDERECO(IDENDERECO),
    FOREIGN KEY (IDTIPOUSUARIO) REFERENCES TIPOUSUARIO(IDTIPOUSUARIO)
);

CREATE TABLE EDITORA(
	IDEDITORA INT NOT NULL AUTO_INCREMENT,
	IDENDERECO INT,
    NOME VARCHAR(100),
    CNPJ VARCHAR(14),
    TELEFONE VARCHAR(11),
    PRIMARY KEY (IDEDITORA),    
  
    FOREIGN KEY (IDENDERECO) REFERENCES ENDERECO(IDENDERECO) 
);

CREATE TABLE GENERO(
	IDGENERO INT NOT NULL AUTO_INCREMENT,
    GENERO VARCHAR(100),
    PRIMARY KEY (IDGENERO)
);

CREATE TABLE LIVRO(
	IDLIVRO INT NOT NULL AUTO_INCREMENT,
	IDEDITORA INT,
    IDGENERO INT,
    TITULO VARCHAR(255),
    SUBTITULO VARCHAR(255),
    EDITORA VARCHAR(50),
    ISBN VARCHAR(13),
    QTDTOTAL INT,
    QTDDISPONIVEL INT,
    GENERO VARCHAR(50),
    DTCADASTRO DATE,
    AUTOR VARCHAR (200),
    ANOPUBLICACAO INT,
    PRIMARY KEY (IDLIVRO),    

    FOREIGN KEY (IDEDITORA) REFERENCES EDITORA(IDEDITORA),
    FOREIGN KEY (IDGENERO) REFERENCES GENERO(IDGENERO)
);

CREATE TABLE EXEMPLARES(
	IDEXEMPLARES INT NOT NULL AUTO_INCREMENT,
    IDLIVRO INT,
    REGISTRO INT,
    QUANTIDADE INT,
    ATIVO INT,    
    PRIMARY KEY(IDEXEMPLARES),    
    
    FOREIGN KEY (IDLIVRO) REFERENCES LIVRO(IDLIVRO)
);

CREATE TABLE EMPRESTIMO(
	IDEMPRESTIMO INT NOT NULL AUTO_INCREMENT,
    IDUSUARIO INT,
    IDEXEMPLARES INT,
    DTEMPRESTIMOINICIO DATE,
    DTEMPRESTIMOFIM DATE,
    DTDEVOLUCAO DATE,
    DESCRICAO VARCHAR(255),
    VALORMULTA DECIMAL(4,2),
    PRIMARY KEY(IDEMPRESTIMO),    
    
    FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(IDUSUARIO),
    FOREIGN KEY (IDEXEMPLARES) REFERENCES EXEMPLARES(IDEXEMPLARES)
);


-- ENDERECO DAS EDITORAS
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'SP', 'SÃO PAULO', 'FRANCA', '12345678', 'RUA DAS LARANJAS', '100' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'PR', 'CURITIBA', 'CENTRO', '12345678', 'RUA DOS LIVROS', '200' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'SC', 'PALHOÇA', 'PASSA VINTE', '12345678', 'RUA DOS LIMOES', '300' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'RS', 'PORTO ALEGRE', 'BOM JESUS', '12345678', 'RUA HERCÍLIO LUZ', '400' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'RJ', 'RIO DE JANEIRO', 'ROCINHA', '12345678', 'RUA DOS COLETE', '500' );
-- ENDERECO DOS USUARIOS
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'SC', 'FLORIANÓPOLIS', 'COSTEIRA', '12345678', 'SERVIDÃO SEVERO MATOS', '600' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'SC', 'SÃO JOSÉ', 'BARREIROS', '12345678', 'RUA DOS PALMITO', '700' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'SC', 'FLORIANÓPOLIS', 'CENTRO', '12345678', 'RUA DEODORO', '800' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'SC', 'PALHOÇA', 'MADRID', '12345678', 'RUA DAS BALA PERDIDA', '900' );
INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO) VALUES ('BRASIL', 'SC', 'SÃO JOSÉ', 'ROÇADO', '12345678', 'RUA DO MATAGAL', '1000' );


-- TIPOS DE USUARIO
INSERT INTO TIPOUSUARIO (DESCRICAO) VALUES ('ADMINISTRADOR');
INSERT INTO TIPOUSUARIO (DESCRICAO) VALUES ('CLIENTE');


SELECT * FROM GENERO;
-- CADASTRO DOS GENEROS
INSERT INTO GENERO(GENERO) VALUES ('INFANTIL');
INSERT INTO GENERO(GENERO) VALUES ('FICÇÃO');
INSERT INTO GENERO(GENERO) VALUES ('DRAMA');


-- CADASTRO DAS EDITORAS
SELECT * FROM EDITORA;
INSERT INTO EDITORA (IDENDERECO, NOME, CNPJ, TELEFONE) VALUES (1, 'MODERNA', '12345678901234', '12345678900');
INSERT INTO EDITORA (IDENDERECO, NOME, CNPJ, TELEFONE) VALUES (2, 'SEXTANTE', '12345678901236', '12345678901');
INSERT INTO EDITORA (IDENDERECO, NOME, CNPJ, TELEFONE) VALUES (3, 'EDIOURO', '12345678901238', '12345678902');
INSERT INTO EDITORA (IDENDERECO, NOME, CNPJ, TELEFONE) VALUES (4, 'PANDA BOOKS', '12345678901240', '12345678903');
INSERT INTO EDITORA (IDENDERECO, NOME, CNPJ, TELEFONE) VALUES (5, 'ALTA BOOKS', '12345678901242', '12345678904');


-- CADASTRO DOS LIVROS
INSERT INTO LIVRO (IDEDITORA, IDGENERO, TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO, AUTOR, ANOPUBLICACAO) VALUES (1, 1, 'CHAPEUZINHO VERMELHO', 'E OS 7 ANÕES', 'MODERNA', '1234567891234', '2010-01-01', 'HENRIQUE', '1990');
INSERT INTO LIVRO (IDEDITORA, IDGENERO, TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO, AUTOR, ANOPUBLICACAO) VALUES (2, 1, 'BOB ESPONJA', 'CALSA QUADRADA', 'SEXTANTE', '1234567891334', '2010-01-01', 'HENRIQUE', '1991');
INSERT INTO LIVRO (IDEDITORA, IDGENERO, TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO, AUTOR, ANOPUBLICACAO) VALUES (3, 2, 'HARRY POTTER', 'E A PEDRA FILOSOFAL', 'EDIOURO', '1234567891434', '2010-01-01', 'HENRIQUE', '1992');
INSERT INTO LIVRO (IDEDITORA, IDGENERO, TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO, AUTOR, ANOPUBLICACAO) VALUES (4, 3, 'INFERNO', 'O MUNDO EM GUERRA', 'PANDA BOOKS', '1234567891534', '2010-01-01', 'HENRIQUE', '1993');
INSERT INTO LIVRO (IDEDITORA, IDGENERO, TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO, AUTOR, ANOPUBLICACAO) VALUES (5, 3, 'O CAÇADOR DE PIPAS', 'LIVRO BAITA', 'ALTA BOOKS', '1234567891634', '2010-01-01', 'HENRIQUE', '1994');

INSERT INTO LIVRO (TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO, AUTOR, ANOPUBLICACAO) VALUES ('O CAÇADOR DE PIPAS', 'LIVRO BAITA', 'ALTA BOOKS', '1234567891234', '2010-01-01', 'HENRIQUE', '1995');

-- INSERCAO NA TABELA EXEMPLARES
INSERT INTO EXEMPLARES (IDLIVRO, QUANTIDADE, ATIVO) VALUES (1,20,1);
INSERT INTO EXEMPLARES (IDLIVRO, QUANTIDADE, ATIVO) VALUES (2,18,1);
INSERT INTO EXEMPLARES (IDLIVRO, QUANTIDADE, ATIVO) VALUES (3,16,1);
INSERT INTO EXEMPLARES (IDLIVRO, QUANTIDADE, ATIVO) VALUES (4,14,1);
INSERT INTO EXEMPLARES (IDLIVRO, QUANTIDADE, ATIVO) VALUES (5,12,0);

-- CADASTRO DOS USAURIOS
INSERT INTO USUARIO (IDENDERECO, IDTIPOUSUARIO, NOME, CPF, TELEFONE, DTCADASTRO, LOGIN, SENHA) VALUES (6, 1, 'HENRIQUE','18693550950', '984436000','2023-06-08','HENRIQUE','123456');
INSERT INTO USUARIO (IDENDERECO, IDTIPOUSUARIO, NOME, CPF, TELEFONE, DTCADASTRO, LOGIN, SENHA) VALUES (7, 1, 'ARTHUR','18693550950', '884436011','2023-06-08','ARTHUR','123456');
INSERT INTO USUARIO (IDENDERECO, IDTIPOUSUARIO, NOME, CPF, TELEFONE, DTCADASTRO, LOGIN, SENHA) VALUES (8, 2, 'LEITOR1','18693550950', '784436022','2023-06-08','LEITOOR1','123456');
INSERT INTO USUARIO (IDENDERECO, IDTIPOUSUARIO, NOME, CPF, TELEFONE, DTCADASTRO, LOGIN, SENHA) VALUES (9, 2, 'LEITOR2','18693550950', '684436033','2023-06-08','LEITOOR2','123456');
INSERT INTO USUARIO (IDENDERECO, IDTIPOUSUARIO, NOME, CPF, TELEFONE, DTCADASTRO, LOGIN, SENHA) VALUES (10, 2, 'LEITOR3','18693550950', '584436044','2023-06-08','LEITOOR3','123456');

-- INSERCAO NA TABELA EMPRESTIMO
INSERT INTO EMPRESTIMO(IDUSUARIO, IDEXEMPLARES, DTEMPRESTIMOINICIO, DTEMPRESTIMOFIM, DTDEVOLUCAO, DESCRICAO) VALUES (1, 1, '2023-06-05', '2023-06-10', '2023-06-09', 'LIVRO LEGAL');
INSERT INTO EMPRESTIMO(IDUSUARIO, IDEXEMPLARES, DTEMPRESTIMOINICIO, DTEMPRESTIMOFIM, DTDEVOLUCAO, DESCRICAO, VALORMULTA) VALUES (2, 2, '2023-06-01', '2023-06-07', '2023-06-10', 'LIVRO LEGAL', '2.00');
INSERT INTO EMPRESTIMO(IDUSUARIO, IDEXEMPLARES, DTEMPRESTIMOINICIO, DTEMPRESTIMOFIM, DTDEVOLUCAO, DESCRICAO, VALORMULTA) VALUES (3, 3, '2023-05-10', '2023-05-15', '2023-06-01', 'LIVRO LEGAL', '10.00');

USE DBBIBLIOTECA;
SELECT * FROM EXEMPLARES;
SELECT * FROM LIVRO;
SELECT * FROM USUARIO;
SELECT * FROM TIPOUSUARIO;
SELECT * FROM ENDERECO;
SELECT * FROM EMPRESTIMO;
SELECT * FROM GENERO;
SELECT * FROM EDITORA;

INSERT INTO LIVRO (TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO, AUTOR, ANOPUBLICACAO) VALUES ('?', '?', '?', '?', '2023-06-26', '?', '2023');
SELECT *
FROM USUARIO AS U
JOIN EMPRESTIMO AS E ON U.IDUSUARIO = E.IDEMPRESTIMO; 
SELECT * FROM EDITORA WHERE IDEDITORA = 1;
/*
SELECT * FROM ENDERECO WHERE
IDENDERECO = 6;
*/

-- INSERT INTO USUARIO (NOME, CPF, TELEFONE, DTCADASTRO, LOGIN, SENHA) VALUES (?, ?, ?, ?, ?, ?);

SELECT * FROM EMPRESTIMO;

SELECT * FROM EMPRESTIMO
INNER JOIN  EXEMPLARES ON EXEMPLARES.IDEXEMPLARES = EMPRESTIMO.IDEMPRESTIMO
INNER JOIN USUARIO ON USUARIO.IDUSUARIO = EMPRESTIMO.IDEMPRESTIMO; 

-- CONSULTA POR DATA 
SELECT * FROM EMPRESTIMO WHERE DTEMPRESTIMOINICIO >= '2023-01-04'
ORDER BY DTEMPRESTIMOINICIO;

INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO)VALUES ('?', '?', '?', '?', '?', '?', '?');

SELECT * FROM LIVRO 
INNER JOIN GENERO
ON LIVRO.IDLIVRO = GENERO.IDGENERO;

SELECT LIVRO.TITULO, LIVRO.IDLIVRO, GENERO.GENERO	
FROM LIVRO
INNER JOIN GENERO
ON LIVRO.IDLIVRO = GENERO.IDGENERO;

SELECT GENERO.GENERO, GENERO.IDGENERO, LIVRO.TITULO,LIVRO.IDLIVRO
FROM GENERO
INNER JOIN LIVRO
ON GENERO.IDGENERO = LIVRO.IDLIVRO;

select  livro.titulo, genero.genero
from livro
inner join genero
on livro.idlivro = genero.idgenero
where genero.genero like 'infan%';

select livro.titulo, livro.idlivro
from livro
where autor = 'henrique';

SELECT * FROM EMPRESTIMO
WHERE IDEMPRESTIMO = 1;

SELECT login FROM USUARIO WHERE login = 'henrique';

SELECT GENERO FROM GENERO WHERE GENERO ='INFANTIL';

SELECT LIVRO.TITULO, GENERO.GENERO
FROM GENERO
INNER JOIN LIVRO
ON GENERO.IDGENERO = LIVRO.IDLIVRO
WHERE GENERO.GENERO LIKE 'IN%';


SELECT CEP, NUMERO FROM ENDERECO WHERE CEP = '12345678' AND NUMERO = '200';


delete from livro where idlivro = 1;