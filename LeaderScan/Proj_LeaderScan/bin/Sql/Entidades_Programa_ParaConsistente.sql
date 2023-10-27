-- Criação do banco de dados
CREATE DATABASE LeaderScan;
USE LeaderScan;

-- Criação das tabelas
CREATE TABLE T01_Empresa (
  A01_codigo INT NOT NULL AUTO_INCREMENT,
  A01_nome VARCHAR(255) NOT NULL,
  PRIMARY KEY (A01_codigo)
);

CREATE TABLE T02_Usuario (
  A02_codigo INT NOT NULL AUTO_INCREMENT,
  A02_nome VARCHAR(255) NOT NULL,
  A02_email VARCHAR(255) NOT NULL,
  A02_senha VARCHAR(255) NOT NULL,
  PRIMARY KEY (A02_codigo)
);

CREATE TABLE T03_Perfil (
  A03_codigo INT NOT NULL AUTO_INCREMENT,
  A03_nome_perfil VARCHAR(255) NOT NULL,
  A03_pms_criar_prop tinyint(1) NOT NULL,
  A03_pms_responder_prop tinyint(1) NOT NULL,
  A03_peso_perfil INT NOT NULL,
  PRIMARY KEY (A03_codigo)
);

INSERT INTO T03_Perfil(A03_nome_perfil, A03_pms_criar_prop, A03_pms_responder_prop, A03_peso_perfil) 
VALUES
	("ADMIN", 1, 1, 1),
    ("GERENTE", 1, 0, 1),
    ("AVALIADOR", 0, 1, 1);
    

CREATE TABLE T04_Proposicao (
  A04_codigo INT NOT NULL AUTO_INCREMENT,
  A04_titulo VARCHAR(255) NOT NULL,
  A04_descricao VARCHAR(255) NOT NULL,
  A04_limite_decisao INT NOT NULL,
  A04_data_criacao DATETIME NOT NULL,
  PRIMARY KEY (A04_codigo)
);

CREATE TABLE T05_Participante (
  A05_codigo INT NOT NULL AUTO_INCREMENT,
  A05_grupo VARCHAR(255) NOT NULL,
  A05_codigo_T02_Usuario INT NOT NULL,
  A05_codigo_T03_Perfil INT NOT NULL,
  A05_codigo_T04_Proposicao INT NOT NULL,
  PRIMARY KEY (A05_codigo),
  FOREIGN KEY (A05_codigo_T02_Usuario) REFERENCES T02_Usuario (A02_codigo),
  FOREIGN KEY (A05_codigo_T03_Perfil) REFERENCES T03_Perfil (A03_codigo),
  FOREIGN KEY (A05_codigo_T04_Proposicao) REFERENCES T04_Proposicao (A04_codigo)
);

CREATE TABLE T06_Criterio (
  A06_codigo INT NOT NULL AUTO_INCREMENT,
  A06_descricao VARCHAR(255) NOT NULL,
  A06_peso INT NOT NULL,
  A06_codigo_T04_Proposicao INT NOT NULL,
  PRIMARY KEY (A06_codigo),
  FOREIGN KEY (A06_codigo_T04_Proposicao) REFERENCES T04_Proposicao (A04_codigo)
);

CREATE TABLE T07_Avaliado (
  A07_codigo INT NOT NULL AUTO_INCREMENT,
  A07_nome VARCHAR(255) NOT NULL,
  A07_grau_certeza_resultante FLOAT NOT NULL,
  A07_grau_incerteza_resultante FLOAT NOT NULL,
  A07_codigo_T04_Proposicao INT NOT NULL,
  PRIMARY KEY (A07_codigo),
  FOREIGN KEY (A07_codigo_T04_Proposicao) REFERENCES T04_Proposicao (A04_codigo)
);

CREATE TABLE T08_Votos (
  A08_codigo INT NOT NULL AUTO_INCREMENT,
  A08_grau_certeza_individual FLOAT NOT NULL,
  A08_grau_incerteza_individual FLOAT NOT NULL,
  A08_codigo_T05_Participante INT NOT NULL,
  A08_codigo_T06_Criterio INT NOT NULL,
  A08_codigo_T07_Avaliado INT NOT NULL,
  PRIMARY KEY (A08_codigo),
  FOREIGN KEY (A08_codigo_T05_Participante) REFERENCES T05_Participante (A05_codigo),
  FOREIGN KEY (A08_codigo_T06_Criterio) REFERENCES T06_Criterio (A06_codigo),
  FOREIGN KEY (A08_codigo_T07_Avaliado) REFERENCES T07_Avaliado (A07_codigo)
);




