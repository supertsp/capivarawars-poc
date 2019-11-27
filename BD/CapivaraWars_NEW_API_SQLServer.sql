-- [GENERO] VARCHAR(1) NOT NULL CHECK([GENERO] IN('M', 'F'))
-- -----------------------------------------------------
-- Schema CapivaraWars
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS CapivaraWars DEFAULT CHARACTER SET utf8 ;
USE [CapivaraWars];

-- -----------------------------------------------------
-- Table `CapivaraWars`.`GAME_STATUS`
-- -----------------------------------------------------
CREATE TABLE GAME_STATUS
(
    [ID_GAME_STATUS] INT NOT NULL IDENTITY,
    [NAME] VARCHAR(10) NOT NULL CHECK([NAME] IN('CREATED', 'ONGOING', 'WIN', 'LOSE', 'DRAW')),
    PRIMARY KEY ([ID_GAME_STATUS])
)


-- -----------------------------------------------------
-- Table `CapivaraWars`.`MATCH`
-- -----------------------------------------------------
CREATE TABLE MATCH
(
    [ID_MATCH] INT NOT NULL IDENTITY,
    [START] DATETIME2(0) NULL,
    [END] DATETIME2(0) NULL,
    [ID_PRIZE_FOR_PLACED_1] INT NULL,
    [ID_PRIZE_FOR_PLACED_2] INT NULL,
    [ID_PRIZE_FOR_PLACED_3] INT NULL,
    [ID_GAME_STATUS] INT NULL,
    PRIMARY KEY ([ID_MATCH])
 ,
    CONSTRAINT [FK_MATCH_CLOSURE_TYPE1]
    FOREIGN KEY ([ID_GAME_STATUS])
    REFERENCES GAME_STATUS ([ID_GAME_STATUS])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX [FK_MATCH_ID_PRIZE_FOR_PLACED_1] ON MATCH ([ID_PRIZE_FOR_PLACED_1] ASC);
CREATE INDEX [FK_MATCH_ID_PRIZE_FOR_PLACED_2] ON MATCH ([ID_PRIZE_FOR_PLACED_2] ASC);
CREATE INDEX [FK_MATCH_ID_PRIZE_FOR_PLACED_3] ON MATCH ([ID_PRIZE_FOR_PLACED_3] ASC);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`CHAMPIONSHIP`
-- -----------------------------------------------------
CREATE TABLE CHAMPIONSHIP
(
    [ID_CHAMPIONSHIP] INT NOT NULL IDENTITY,
    [NAME] VARCHAR(120) NOT NULL,
    [START] DATETIME2(0) NOT NULL,
    [END] DATETIME2(0) NULL,
    [MAX_PLAYERS] INT NOT NULL,
    [MAX_MATCHES] INT NOT NULL,
    [CURRENT_NUMBER_OF_PLAYERS] INT NULL,
    [ID_PRIZE_FOR_PLACED_1] INT NULL,
    [ID_PRIZE_FOR_PLACED_2] INT NULL,
    [ID_PRIZE_FOR_PLACED_3] INT NULL,
    [ID_GAME_STATUS] INT NULL,
    PRIMARY KEY ([ID_CHAMPIONSHIP])
 ,
    CONSTRAINT [FK_CHAMPIONSHIP_GAME_STATUS1]
    FOREIGN KEY ([ID_GAME_STATUS])
    REFERENCES GAME_STATUS ([ID_GAME_STATUS])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX [FK_CHAMPIONSHIP_ID_PRIZE_FOR_PLACED_1] ON CHAMPIONSHIP ([ID_PRIZE_FOR_PLACED_1] ASC);
CREATE INDEX [FK_CHAMPIONSHIP_ID_PRIZE_FOR_PLACED_2] ON CHAMPIONSHIP ([ID_PRIZE_FOR_PLACED_2] ASC);
CREATE INDEX [FK_CHAMPIONSHIP_ID_PRIZE_FOR_PLACED_3] ON CHAMPIONSHIP ([ID_PRIZE_FOR_PLACED_3] ASC);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`PLAYER`
-- -----------------------------------------------------
CREATE TABLE PLAYER
(
    [ID_PLAYER] INT NOT NULL IDENTITY,
    [NICK] VARCHAR(45) NOT NULL,
    [PASSWORD] VARCHAR(45) NOT NULL,
    [EMAIL] VARCHAR(255) NOT NULL,
    [ACCOUNT_BIRTHDAY] DATETIME2(0) NOT NULL,
    [AVATAR_URL] VARCHAR(255) NOT NULL,
    [FULL_NAME] VARCHAR(100) NOT NULL,
    [GENDER] VARCHAR(1) NOT NULL CHECK([GENDER] IN('M', 'F')),
    [BIRTHDAY] DATE NOT NULL,
    [ONLINE] SMALLINT NULL,
    [LAST_ACTIVATION_CODE] VARCHAR(255) NULL,
    [COINS] INT NULL,
    [SCORE] INT NULL,
    [WINS] INT NULL,
    [LOSSES] INT NULL,
    [DRAWS] INT NULL,
    [ACCURATE_SHOTS] INT NULL,
    [BAD_SHOTS] INT NULL,
    [SHOTS_RECEIVED] INT NULL,
    [MOVEMENTS] INT NULL,
    [MATCHES_PLAYED] INT NULL,
    [CHAMPIONSHIPS_PLAYED] INT NULL,
    [PRIZES_EARNED] INT NULL,
    PRIMARY KEY ([ID_PLAYER]),
    CONSTRAINT [NICK_UNIQUE] UNIQUE  ([NICK] ASC),
    CONSTRAINT [EMAIL_UNIQUE] UNIQUE  ([EMAIL] ASC)
);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`COLOR`
-- -----------------------------------------------------
CREATE TABLE COLOR
(
    [ID_COLOR] INT NOT NULL IDENTITY,
    [NAME] VARCHAR(120) NOT NULL,
    [RGBA] CHAR(9) NOT NULL,
    PRIMARY KEY ([ID_COLOR])
);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`CAPYBARA`
-- -----------------------------------------------------
CREATE TABLE CAPYBARA
(
    [ID_CAPYBARA] INT NOT NULL IDENTITY,
    [NAME] VARCHAR(45) NOT NULL,
    [BIRTHDAY] DATETIME2(0) NOT NULL,
    [HP] INT NULL,
    [ID_COLOR] INT NULL,
    [ID_PLAYER] INT NULL,
    PRIMARY KEY ([ID_CAPYBARA]),
    CONSTRAINT [FK_CAPIVARA_COR]
    FOREIGN KEY ([ID_COLOR])
    REFERENCES COLOR ([ID_COLOR])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX [FK_CAPYBARA_ID_PLAYER] ON CAPYBARA ([ID_PLAYER] ASC);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`PRIZE`
-- -----------------------------------------------------
CREATE TABLE PRIZE
(
    [ID_PRIZE] INT NOT NULL IDENTITY,
    [NAME] VARCHAR(120) NOT NULL,
    [COINS] INT NOT NULL,
    [ICON_URL] VARCHAR(255) NOT NULL,
    [CREATED_IN] DATETIME2(0) NOT NULL,
    PRIMARY KEY ([ID_PRIZE])
);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`PRIZE_EARNED`
-- -----------------------------------------------------
CREATE TABLE PRIZE_EARNED
(
    [ID_PRIZE_EARNED] INT NOT NULL IDENTITY,
    [ID_PLAYER] INT NULL,
    [ID_PRIZE] INT NULL,
    [PRIZE_DATETIME] DATETIME2(0) NULL,
    PRIMARY KEY ([ID_PRIZE_EARNED]),
    CONSTRAINT [FK_JOGADOR_PREMIO_JOGADOR1]
    FOREIGN KEY ([ID_PLAYER])
    REFERENCES PLAYER ([ID_PLAYER])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX [FK_PRIZE_EARNED_ID_PRIZE] ON PRIZE_EARNED ([ID_PRIZE] ASC);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`CHAMPIONSHIP_PLAYED`
-- -----------------------------------------------------
CREATE TABLE CHAMPIONSHIP_PLAYED
(
    [ID_CHAMPIONSHIP_PLAYED] INT NOT NULL IDENTITY,
    [ID_CHAMPIONSHIP] INT NULL,
    [ID_PLAYER] INT NULL,
    [START] DATETIME2(0) NULL,
    [END] DATETIME2(0) NULL,
    [ID_GAME_STATUS] INT NULL,
    PRIMARY KEY ([ID_CHAMPIONSHIP_PLAYED]),
    CONSTRAINT [FK_JOGADORES_EM_CAMPEONATO_JOGADOR1]
    FOREIGN KEY ([ID_PLAYER])
    REFERENCES PLAYER ([ID_PLAYER])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX [FK_CHAMPIONSHIP_PLAYED_ID_CHAMPIONSHIP] ON CHAMPIONSHIP_PLAYED ([ID_CHAMPIONSHIP] ASC);
CREATE INDEX [FK_CHAMPIONSHIP_PLAYED_ID_GAME_STATUS] ON CHAMPIONSHIP_PLAYED ([ID_GAME_STATUS] ASC);


-- -----------------------------------------------------
-- Table `CapivaraWars`.`MATCH_PLAYED`
-- -----------------------------------------------------
CREATE TABLE MATCH_PLAYED
(
    [ID_MATCH_PLAYED] INT NOT NULL IDENTITY,
    [ID_PLAYER] INT NULL,
    [ID_MATCH] INT NULL,
    [ID_GAME_STATUS] INT NULL,
    PRIMARY KEY ([ID_MATCH_PLAYED]),
    CONSTRAINT [FK_JOGADOR_PARTIDA_JOGADOR1]
    FOREIGN KEY ([ID_PLAYER])
    REFERENCES PLAYER ([ID_PLAYER])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX [FK_MATCH_PLAYED_ID_MATCH] ON MATCH_PLAYED ([ID_MATCH] ASC);
CREATE INDEX [FK_MATCH_PLAYED_ID_GAME_STATUS] ON MATCH_PLAYED ([ID_GAME_STATUS] ASC);

