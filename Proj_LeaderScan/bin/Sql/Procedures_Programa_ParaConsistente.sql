DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T01` (
    IN v01_nome VARCHAR(255)
)
BEGIN
    INSERT INTO T01_Empresa (A01_nome) VALUES (v01_nome);
END //

CREATE PROCEDURE `PROC_UPDATE_T01`(
    IN v01_codigo INT,
    IN v01_nome VARCHAR(255)
)
BEGIN
    UPDATE T01_Empresa
    SET A01_nome = v01_nome
    WHERE A01_codigo = v01_codigo;
END //

CREATE PROCEDURE  `PROC_DELETE_T01`(
    IN v01_codigo INT
)
BEGIN
    DELETE FROM T01_Empresa WHERE A01_codigo = v01_codigo;
END //
DELIMITER ;
-- -------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T02`(
    IN v02_nome VARCHAR(255),
    IN v02_email VARCHAR(255),
    IN v02_senha VARCHAR(255)
)
BEGIN
    INSERT INTO T02_Usuario (A02_nome, A02_email, A02_senha) VALUES (v02_nome, v02_email, v02_senha);
END //

CREATE PROCEDURE `PROC_UPDATE_T02`(
    IN v02_codigo INT,
    IN v02_nome VARCHAR(255),
    IN v02_email VARCHAR(255),
    IN v02_senha VARCHAR(255)
)
BEGIN
    UPDATE T02_Usuario
    SET A02_nome = v02_nome, A02_email = v02_email, A02_senha = v02_senha
    WHERE A02_codigo = v02_codigo;
END //

CREATE PROCEDURE `PROC_DELETE_T02`(
    IN v02_codigo INT
)
BEGIN
    DELETE FROM T02_Usuario WHERE A02_codigo = v02_codigo;
END //
DELIMITER ;
-- --------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T03`(
    IN v03_privilegio VARCHAR(255),
    IN v03_permissao_prop VARCHAR(255),
    IN v03_criacao_prop VARCHAR(255),
    IN v03_peso_perfil INT
)
BEGIN
    INSERT INTO T03_Perfil (A03_privilegio, A03_permissao_prop, A03_criacao_prop, A03_peso_perfil)
    VALUES ( v03_privilegio,  v03_permissao_prop,  v03_criacao_prop,  v03_peso_perfil);
END //

CREATE PROCEDURE `PROC_UPDATE_T03`(
    IN v03_codigo INT,
    IN v03_privilegio VARCHAR(255),
    IN v03_permissao_prop VARCHAR(255),
    IN v03_criacao_prop VARCHAR(255),
    IN v03_peso_perfil INT
)
BEGIN
    UPDATE T03_Perfil
    SET A03_privilegio = v03_privilegio, A03_permissao_prop = v03_permissao_prop,
        A03_criacao_prop = v03_criacao_prop, A03_peso_perfil = v03_peso_perfil
    WHERE A03_codigo = v03_codigo;
END //

CREATE PROCEDURE `PROC_DELETE_T03`(
    IN v03_codigo INT
)
BEGIN
    DELETE FROM T03_Perfil WHERE A03_codigo = v03_codigo;
END //
DELIMITER ;
-- ----------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T04`(
    IN v04_titulo VARCHAR(255),
    IN v04_descricao VARCHAR(255),
    IN v04_limite_decisao INT,
    IN v04_data_criacao DATETIME
)
BEGIN
    INSERT INTO T04_Proposicao (A04_titulo, A04_descricao, A04_limite_decisao, A04_data_criacao)
    VALUES (v04_titulo, v04_descricao, v04_limite_decisao, v04_data_criacao);
END //

CREATE PROCEDURE `PROC_UPDATE_T04`(
    IN v04_codigo INT,
    IN v04_titulo VARCHAR(255),
    IN v04_descricao VARCHAR(255),
    IN v04_limite_decisao INT,
    IN v04_data_criacao DATETIME
)
BEGIN
    UPDATE T04_Proposicao
    SET A04_titulo = v04_titulo, A04_descricao = v04_descricao,
        A04_limite_decisao = v04_limite_decisao, A04_data_criacao = v04_data_criacao
    WHERE A04_codigo = v04_codigo;
END //

CREATE PROCEDURE `PROC_DELETE_T04`(
    IN v04_codigo INT
)
BEGIN
    DELETE FROM T04_Proposicao WHERE A04_codigo = v04_codigo;
END //
DELIMITER ;
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T05`(
    IN v05_grupo VARCHAR(255),
    IN v05_codigo_T02_Usuario INT,
    IN v05_codigo_T03_Perfil INT,
    IN v05_codigo_T04_Proposicao INT
)
BEGIN
    INSERT INTO T05_Participante (A05_grupo, A05_codigo_T02_Usuario, A05_codigo_T03_Perfil, A05_codigo_T04_Proposicao)
    VALUES (v05_grupo, v05_codigo_T02_Usuario, v05_codigo_T03_Perfil, v05_codigo_T04_Proposicao);
END //

CREATE PROCEDURE `PROC_UPDATE_T05`(
    IN v05_codigo INT,
    IN v05_grupo VARCHAR(255),
    IN v05_codigo_T02_Usuario INT,
    IN v05_codigo_T03_Perfil INT,
    IN v05_codigo_T04_Proposicao INT
)
BEGIN
    UPDATE T05_Participante
    SET A05_grupo = v05_grupo, A05_codigo_T02_Usuario = v05_codigo_T02_Usuario,
        A05_codigo_T03_Perfil = v05_codigo_T03_Perfil, A05_codigo_T04_Proposicao = v05_codigo_T04_Proposicao
    WHERE A05_codigo = v05_codigo;
END //

CREATE PROCEDURE `PROC_DELETE_T05`(
    IN v05_codigo INT
)
BEGIN
    DELETE FROM T05_Participante WHERE A05_codigo = v05_codigo;
END //
DELIMITER ;
-- -------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T06`(
    IN v06_descricao VARCHAR(255),
    IN v06_peso INT,
    IN v06_codigo_T04_Proposicao INT
)
BEGIN
    INSERT INTO T06_Criterio (A06_descricao, A06_peso, A06_codigo_T04_Proposicao)
    VALUES (v06_descricao, v06_peso, v06_codigo_T04_Proposicao);
END //

CREATE PROCEDURE `PROC_UPDATE_T06`(
    IN v06_codigo INT,
    IN v06_descricao VARCHAR(255),
    IN v06_peso INT,
    IN v06_codigo_T04_Proposicao INT
)
BEGIN
    UPDATE T06_Criterio
    SET A06_descricao = v06_descricao, A06_peso = v06_peso, A06_codigo_T04_Proposicao = v06_codigo_T04_Proposicao
    WHERE A06_codigo = v06_codigo;
END //

CREATE PROCEDURE `PROC_DELETE_T06`(
    IN v06_codigo INT
)
BEGIN
    DELETE FROM T06_Criterio WHERE A06_codigo = v06_codigo;
END //
DELIMITER ;
-- --------------------------------------------------------
DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T07`(
    IN v07_nome VARCHAR(255),
    IN v07_grau_certeza_resultante FLOAT,
    IN v07_grau_incerteza_resultante FLOAT,
    IN v07_codigo_T04_Proposicao INT
)
BEGIN
    INSERT INTO T07_Avaliado (A07_nome, A07_grau_certeza_resultante, A07_grau_incerteza_resultante, A07_codigo_T04_Proposicao)
    VALUES (v07_nome, v07_grau_certeza_resultante, v07_grau_incerteza_resultante, v07_codigo_T04_Proposicao);
END //

CREATE PROCEDURE `PROC_UPDATE_T07`(
    IN v07_codigo INT,
    IN v07_nome VARCHAR(255),
    IN v07_grau_certeza_resultante FLOAT,
    IN v07_grau_incerteza_resultante FLOAT,
    IN v07_codigo_T04_Proposicao INT
)
BEGIN
    UPDATE T07_Avaliado
    SET A07_nome = v07_nome, A07_grau_certeza_resultante = v07_grau_certeza_resultante,
        A07_grau_incerteza_resultante = v07_grau_incerteza_resultante, A07_codigo_T04_Proposicao = v07_codigo_T04_Proposicao
    WHERE A07_codigo = v07_codigo;
END //

CREATE PROCEDURE `PROC_DELETE_T07`(
    IN v07_codigo INT
)
BEGIN
    DELETE FROM T07_Avaliado WHERE A07_codigo = v07_codigo;
END //
DELIMITER ;

-- ---------------------------------------------------------
DELIMITER //
CREATE PROCEDURE `PROC_INSERT_T08`(
    IN v08_grau_certeza_individual FLOAT,
    IN v08_grau_incerteza_individual FLOAT,
    IN v08_codigo_T05_Participante INT,
    IN v08_codigo_T06_Criterio INT,
    IN v08_codigo_T07_Avaliado INT
)
BEGIN
    INSERT INTO T08_Votos (A08_grau_certeza_individual, A08_grau_incerteza_individual, A08_codigo_T05_Participante, A08_codigo_T06_Criterio, A08_codigo_T07_Avaliado)
    VALUES (v08_grau_certeza_individual, v08_grau_incerteza_individual, v08_codigo_T05_Participante, v08_codigo_T06_Criterio, v08_codigo_T07_Avaliado);
END //

CREATE PROCEDURE `PROC_UPDATE_T08`(
    IN v08_codigo INT,
    IN v08_grau_certeza_individual FLOAT,
    IN v08_grau_incerteza_individual FLOAT,
    IN v08_codigo_T05_Participante INT,
    IN v08_codigo_T06_Criterio INT,
    IN v08_codigo_T07_Avaliado INT
)
BEGIN
    UPDATE T08_Votos
    SET A08_grau_certeza_individual = v08_grau_certeza_individual,
        A08_grau_incerteza_individual = v08_grau_incerteza_individual,
        A08_codigo_T05_Participante = v08_codigo_T05_Participante,
        A08_codigo_T06_Criterio = v08_codigo_T06_Criterio,
        A08_codigo_T07_Avaliado = v08_codigo_T07_Avaliado
    WHERE A08_codigo = v08_codigo;
END //

CREATE PROCEDURE `PROC_DELETE_T08`(
    IN v08_codigo INT
)
BEGIN
    DELETE FROM T08_Votos WHERE A08_codigo = v08_codigo;
END //
DELIMITER ;


