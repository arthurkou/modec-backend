DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS VESSEL;

CREATE TABLE EQUIPMENT (
name VARCHAR(250) NOT NULL,
code VARCHAR(250) NOT NULL PRIMARY KEY,
status VARCHAR(250),
location VARCHAR(250) NOT NULL
);


CREATE TABLE VESSEL (
CD_VESSEL VARCHAR(250) NOT NULL PRIMARY KEY,
CD_EQUIPMENT VARCHAR(250) 
);

INSERT INTO equipment VALUES ('Compressor1', '5310B9D1', 'active', 'RJ-BR');
INSERT INTO equipment VALUES ('Compressor2', '5310B9D2', 'inactive', 'Tokyo-JP');
INSERT INTO equipment VALUES ('Compressor3', '5310B9D3', 'inactive', 'Tokyo-JP');
INSERT INTO equipment VALUES ('Compressor4', '5310B9D4', 'active', 'RJ-BR');
INSERT INTO equipment VALUES ('Compressor5', '5310B9D5', 'active', 'Tokyo-JP');
INSERT INTO equipment VALUES ('Compressor6', '5310B9D6', 'active', 'RJ-BR');
INSERT INTO equipment VALUES ('Compressor7', '5310B9D7', 'active', 'RJ-BR');
INSERT INTO equipment VALUES ('Compressor8', '5310B9D8', 'inactive', 'RJ-BR');
INSERT INTO equipment VALUES ('Compressor9', '5310B9D9', 'active', 'Tokyo-JP');

INSERT INTO vessel VALUES ('MV102', '5310B9D1');
INSERT INTO vessel VALUES ('MV103', '5310B9D2');
INSERT INTO vessel VALUES ('MV104', '5310B9D3');
INSERT INTO vessel VALUES ('MV105', '5310B9D4');
INSERT INTO vessel VALUES ('MV106', '5310B9D5');
INSERT INTO vessel VALUES ('MV107', '5310B9D6');
INSERT INTO vessel VALUES ('MV108', '5310B9D7');
INSERT INTO vessel VALUES ('MV109', '5310B9D8');
INSERT INTO vessel VALUES ('MV101', '5310B9D9');

SELECT `equipment`.*, `vessel`.`CD_VESSEL` FROM `equipment`
  INNER JOIN `vessel` ON `equipment`.`code` = `vessel`.`CD_EQUIPMENT`;