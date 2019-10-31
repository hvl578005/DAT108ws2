DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
DROP TABLE IF EXISTS Deltager;

CREATE TABLE Deltager
(
	fornavn VARCHAR(20),
	etternavn VARCHAR(20),
	mobil VARCHAR(8) UNIQUE,
	passordhash VARCHAR(255),
	passordsalt VARCHAR(255),
	kjonn VARCHAR(6),
	CONSTRAINT UC_Deltager UNIQUE (mobil),
	CONSTRAINT PK_Deltager PRIMARY KEY (mobil)
);

