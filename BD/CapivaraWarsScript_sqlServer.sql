USE [CapivaraWars]
;

-- -----------------------------------------------------
-- Table `CapivaraWars`.`PREMIO`
-- -----------------------------------------------------
CREATE TABLE PREMIO
(
    [ID_PREMIO] INT NOT NULL IDENTITY,
    [NOME] VARCHAR(120) NOT NULL,
    [VALOR_EM_MOEDAS] INT NOT NULL,
    [URL_IMAGEM] VARCHAR(255) NOT NULL,
    [DATAHORA_CRIACAO] DATETIME2(0) NOT NULL,
    PRIMARY KEY ([ID_PREMIO])
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`JOGADOR`
-- -----------------------------------------------------
CREATE TABLE JOGADOR
(
    [ID_JOGADOR] INT NOT NULL IDENTITY,
    [NICK] VARCHAR(45) NOT NULL,
    [SENHA] VARCHAR(45) NOT NULL,
    [DATAHORA_CRIACAO_CONTA] DATETIME2(0) NOT NULL,
    [URL_FOTO] VARCHAR(255) NOT NULL,
    [NOME_COMPLETO] VARCHAR(100) NOT NULL,
    [EMAIL] VARCHAR(255) NOT NULL,
    [GENERO] VARCHAR(1) NOT NULL CHECK (GENERO IN('M', 'F')),
    [DATA_NASCIMENTO] DATE NOT NULL,
    [ONLINE] SMALLINT NULL,
    [ULTIMO_CODIGO_ATIVACAO] VARCHAR(255) NULL,
    [MOEDAS] INT NULL,
    [PONTUACAO] INT NULL,
    [VITORIAS] INT NULL,
    [EMPATES] INT NULL,
    [DERROTAS] INT NULL,
    [QTD_TIROS_CERTEIROS] INT NULL,
    [QTD_TIROS_RUINS] INT NULL,
    [QTD_TIROS_RECEBIDOS] INT NULL,
    [QTD_MOVIMENTOS] INT NULL,
    PRIMARY KEY ([ID_JOGADOR]),
    CONSTRAINT [NICK_UNIQUE] UNIQUE  ([NICK] ASC),
    CONSTRAINT [EMAIL_UNIQUE] UNIQUE  ([EMAIL] ASC)
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`CAMPEONATO`
-- -----------------------------------------------------
CREATE TABLE CAMPEONATO
(
    [ID_CAMPEONATO] INT NOT NULL IDENTITY,
    [NOME] VARCHAR(120) NOT NULL,
    [DATAHORA_INICIO] DATETIME2(0) NOT NULL,
    [DATAHORA_FIM] DATETIME2(0) NULL,
    [LIMITE_PARTICIPANTES] INT NOT NULL,
    [QTD_ATUAL_PARTICIPANTES] INT NULL,
    [ID_PREMIO_PRIMEIRO_COLOCADO] INT NOT NULL,
    [ID_PREMIO_SEGUNDO_COLOCADO] INT NOT NULL,
    [ID_PREMIO_TERCEIRO_COLOCADO] INT NOT NULL,
    [ID_JOGADOR_VENCEDOR_PRIMEIRO] INT NULL,
    [ID_JOGADOR_VENCEDOR_SEGUNDO] INT NULL,
    [ID_JOGADOR_VENCEDOR_TERCEIRO] INT NULL,
    PRIMARY KEY ([ID_CAMPEONATO]),
    CONSTRAINT [fk_CAMPEONATO_PREMIO1]
    FOREIGN KEY ([ID_PREMIO_PRIMEIRO_COLOCADO])
    REFERENCES PREMIO ([ID_PREMIO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_CAMPEONATO_PREMIO2]
    FOREIGN KEY ([ID_PREMIO_SEGUNDO_COLOCADO])
    REFERENCES PREMIO ([ID_PREMIO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_CAMPEONATO_PREMIO3]
    FOREIGN KEY ([ID_PREMIO_TERCEIRO_COLOCADO])
    REFERENCES PREMIO ([ID_PREMIO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_CAMPEONATO_JOGADOR1]
    FOREIGN KEY ([ID_JOGADOR_VENCEDOR_PRIMEIRO])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_CAMPEONATO_JOGADOR2]
    FOREIGN KEY ([ID_JOGADOR_VENCEDOR_SEGUNDO])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_CAMPEONATO_JOGADOR3]
    FOREIGN KEY ([ID_JOGADOR_VENCEDOR_TERCEIRO])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`PARTIDA`
-- -----------------------------------------------------
CREATE TABLE PARTIDA
(
    [ID_PARTIDA] INT NOT NULL,
    [DATAHORA_INCIO] DATETIME2(0) NOT NULL,
    [DATAHORA_FIM] DATETIME2(0) NULL,
    [ID_JOGADOR_1] INT NOT NULL,
    [ID_JOGADOR_2] INT NOT NULL,
    [ID_JOGADOR_VENCEDOR] INT NULL,
    [EMPATOU] SMALLINT NULL,
    [ID_CAMPEONATO] INT NULL,
    PRIMARY KEY ([ID_PARTIDA]),
    CONSTRAINT [fk_PARTIDA_CAMPEONATO1]
    FOREIGN KEY ([ID_CAMPEONATO])
    REFERENCES CAMPEONATO ([ID_CAMPEONATO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_PARTIDA_JOGADOR1]
    FOREIGN KEY ([ID_JOGADOR_VENCEDOR])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_PARTIDA_JOGADOR2]
    FOREIGN KEY ([ID_JOGADOR_1])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_PARTIDA_JOGADOR3]
    FOREIGN KEY ([ID_JOGADOR_2])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`COR`
-- -----------------------------------------------------
CREATE TABLE COR
(
    [ID_COR] INT NOT NULL IDENTITY,
    [NOME] VARCHAR(120) NOT NULL,
    [RGBA] CHAR(9) NOT NULL,
    PRIMARY KEY ([ID_COR])
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`CAPIVARA`
-- -----------------------------------------------------
CREATE TABLE CAPIVARA
(
    [ID_CAPIVARA] INT NOT NULL IDENTITY,
    [NOME] VARCHAR(45) NOT NULL,
    [DATAHORA_CRIACAO] DATETIME2(0) NOT NULL,
    [BARRA_VIDA] INT NULL,
    [ID_COR] INT NULL,
    [ID_JOGADOR] INT NULL,
    PRIMARY KEY ([ID_CAPIVARA]),
    CONSTRAINT [fk_CAPIVARA_COR]
    FOREIGN KEY ([ID_COR])
    REFERENCES COR ([ID_COR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_CAPIVARA_JOGADOR1]
    FOREIGN KEY ([ID_JOGADOR])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`TIPO_ACESSORIO`
-- -----------------------------------------------------
CREATE TABLE TIPO_ACESSORIO
(
    [ID_TIPO_ACESSORIO] INT NOT NULL IDENTITY,
    [NOME] VARCHAR(120) NOT NULL,
    PRIMARY KEY ([ID_TIPO_ACESSORIO])
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`ACESSORIO`
-- -----------------------------------------------------
CREATE TABLE ACESSORIO
(
    [ID_ACESSORIO] INT NOT NULL IDENTITY,
    [NOME] VARCHAR(120) NOT NULL,
    [PRECO] INT NOT NULL,
    [URL_IMAGEM] VARCHAR(255) NOT NULL,
    [DATAHORA_CRIACAO] DATETIME2(0) NOT NULL,
    [ID_TIPO_ACESSORIO] INT NOT NULL,
    PRIMARY KEY ([ID_ACESSORIO]),
    CONSTRAINT [fk_ACESSORIO_TIPO_ACESSORIO1]
    FOREIGN KEY ([ID_TIPO_ACESSORIO])
    REFERENCES TIPO_ACESSORIO ([ID_TIPO_ACESSORIO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`ACESSORIOS_DA_CAPIVARA`
-- -----------------------------------------------------
CREATE TABLE ACESSORIOS_DA_CAPIVARA
(
    [ID_CAPIVARA] INT NOT NULL,
    [ID_ACESSORIO] INT NOT NULL,
    [DATAHORA_AQUISICAO] DATETIME2(0) NOT NULL,
    [PRECO_PAGO] INT NOT NULL,
    PRIMARY KEY ([ID_CAPIVARA], [ID_ACESSORIO]),
    CONSTRAINT [fk_CAPIVARA_ACESSORIO_CAPIVARA1]
    FOREIGN KEY ([ID_CAPIVARA])
    REFERENCES CAPIVARA ([ID_CAPIVARA])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_CAPIVARA_ACESSORIO_ACESSORIO1]
    FOREIGN KEY ([ID_ACESSORIO])
    REFERENCES ACESSORIO ([ID_ACESSORIO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`PREMIOS_DO_JOGADOR`
-- -----------------------------------------------------
CREATE TABLE PREMIOS_DO_JOGADOR
(
    [ID_JOGADOR] INT NOT NULL,
    [ID_PREMIO] INT NOT NULL,
    [DATAHORA_AQUISICAO] DATETIME2(0) NOT NULL,
    PRIMARY KEY ([ID_JOGADOR], [ID_PREMIO]),
    CONSTRAINT [fk_JOGADOR_PREMIO_JOGADOR1]
    FOREIGN KEY ([ID_JOGADOR])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_JOGADOR_PREMIO_PREMIO1]
    FOREIGN KEY ([ID_PREMIO])
    REFERENCES PREMIO ([ID_PREMIO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
;


-- -----------------------------------------------------
-- Table `CapivaraWars`.`JOGADORES_EM_CAMPEONATO`
-- -----------------------------------------------------
CREATE TABLE JOGADORES_EM_CAMPEONATO
(
    [ID_JOGADOR] INT NOT NULL,
    [ID_CAMPEONATO] INT NOT NULL,
    [DATAHORA_INICIO_PARTICIPACAO] DATETIME2(0) NOT NULL,
    [DATAHORA_FIM_PARTICIPACAO] DATETIME2(0) NULL,
    PRIMARY KEY ([ID_JOGADOR], [ID_CAMPEONATO]),
    CONSTRAINT [fk_JOGADOR_CAMPEONATO_JOGADOR1]
    FOREIGN KEY ([ID_JOGADOR])
    REFERENCES JOGADOR ([ID_JOGADOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT [fk_JOGADOR_CAMPEONATO_CAMPEONATO1]
    FOREIGN KEY ([ID_CAMPEONATO])
    REFERENCES CAMPEONATO ([ID_CAMPEONATO])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
;