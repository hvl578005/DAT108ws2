SET search_path = f15demo;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS klasse;

CREATE TABLE klasse 
(
   kode     CHARACTER VARYING (10),
   program  CHARACTER VARYING (40),
   PRIMARY KEY (kode)
);

CREATE TABLE student 
(
   id           CHARACTER (7),
   navn         CHARACTER VARYING (40),
   klasse_kode  CHARACTER VARYING (10),
   PRIMARY KEY (id),
   FOREIGN KEY (klasse_kode) REFERENCES klasse (kode)
);

INSERT INTO klasse VALUES 
	('17hData', 'Dataingeniør'),
	('17hInf', 'Informasjonsteknologi');

INSERT INTO student VALUES 
	('123456', 'Arne', '17hData'),
	('123457', 'Brit', '17hData'),
	('123458', 'Carl', '17hData'),
	('123459', 'Dina', '17hInf'),
	('123460', 'Erik', '17hInf'),
	('123461', 'Fred', '17hInf');


