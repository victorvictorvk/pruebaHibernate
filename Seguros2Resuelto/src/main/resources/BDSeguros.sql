
use seguros2; 

-- Dumping structure for table seguros.seguro
DROP TABLE IF EXISTS seguro;
CREATE TABLE IF NOT EXISTS seguro (
  id int NOT NULL AUTO_INCREMENT,
  nif varchar(255) NOT NULL UNIQUE,
  nombre varchar(255) DEFAULT NULL,
  ape1 varchar(255) DEFAULT NULL,
  ape2 varchar(255) DEFAULT NULL,
  edad int DEFAULT NULL,
  sexo int DEFAULT NULL,
  casado char(1) DEFAULT NULL,
  numHijos int DEFAULT NULL,
  embarazada char(1) DEFAULT NULL,
  coberturaId int DEFAULT NULL,
  enfermedadId int DEFAULT NULL,
  fechaCreacion date DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO seguro 
	(id, nif, nombre, ape1, ape2, edad, sexo, casado, numHijos, embarazada, fechaCreacion) 
VALUES
	(1, '17546586R', 'JOAQUIM', 'SORIA', 'SORIA', 19, 1, 'Y', 0, 'N', '2013-04-22 19:05:11'),
	(2, '22737883Z', 'FELIX EDUARDO', 'EVA EUGENIA', 'IVORRA', 40, 1, 'Y', 3, 'N','2013-04-22 19:05:12'),
	(3, '41179582Z', 'MARIA INES', 'MARCO', 'LIBEROS', 26, 1, 'Y', 2, 'N', '2013-04-22 19:05:12'),
	(4, '55386997F', 'NURIA', 'PUERTO', 'VILLANOVA', 46, 1, 'Y', 2, 'N', '2013-04-22 19:05:12'),
	(5, '66738365R', 'JOAQUIN', 'SAYAS', 'SENABRE', 25, 0, 'N', 1, 'N', '2013-04-22 19:05:12'),
	(6, '42749118F', 'JOSEF BENANTZIO', 'SAVALL', 'RABASCO', 40, 1, 'N', 2, 'N', '2013-04-22 19:05:12'),
	(7, '78172651K', 'CRISTINA', 'PEREZ', 'HARILLO', 56, 0,'Y', 1, 'N', '2013-04-22 19:05:12'),
	(8, '51256964S', 'MARIA SANDRA', 'CASES', 'ROIG', 58, 1, 'N', 3, 'N', '2013-04-22 19:05:12');
	

INSERT INTO seguro 
	(id, nif, nombre, ape1, ape2, edad, sexo, casado, numHijos, embarazada,enfermedadId, fechaCreacion) 
VALUES
	(default, '17558586R', 'Joanna', 'SORIA', 'SORIA', 19, 1, 'Y', 0, 'N', 1, '2013-04-22 19:05:11');

DROP TABLE IF EXISTS enfermedad;
CREATE TABLE IF NOT EXISTS enfermedad (
  id int NOT NULL AUTO_INCREMENT,
  corazon char(1) not null default "N",
  estomacal char(1) not null default "N",
  rinyones char(1) not null default "N",
  alergia char(1) not null default "N",
  nombreAlergia varchar(50) null,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

   

DROP TABLE IF EXISTS cobertura;
CREATE TABLE IF NOT EXISTS cobertura (
  id int NOT NULL AUTO_INCREMENT,
  oftalmologia char(1) not null default "F",
  dental char(1) not null default "F",
  fecundacionInVitro char(1) not null default "F",
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS asistencia;
CREATE TABLE IF NOT EXISTS asistencia (
  id int NOT NULL AUTO_INCREMENT,
  seguroId int NOT NULL,
  descripcion varchar(255),
  lugar varchar(50),
  explicacion blob,
  tipoAsistencia varchar(50),
  fecha date,
  hora time,
  importe decimal(10,2),
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

ALTER TABLE asistencia
ADD CONSTRAINT fk_seguro
FOREIGN KEY (seguroId) REFERENCES seguro (id);

ALTER TABLE seguro
ADD CONSTRAINT fk_cobertura
FOREIGN KEY (coberturaId) REFERENCES cobertura (id);
  
ALTER TABLE seguro
ADD CONSTRAINT fk_enfermedad  
FOREIGN KEY (enfermedadId) REFERENCES enfermedad (id);

INSERT INTO asistencia (id, seguroId, descripcion, lugar, explicacion, tipoAsistencia, fecha, hora, importe)
VALUES ( DEFAULT, 2, "Coberturas de mucha calidad", "Luna", "Cubre contra coronaVirus" , "HOSPITALARIA", '2020-02-02', '17:20:20', 8025.25),
( DEFAULT, 2, "Coberturas de extrema calidad", "Wuhuan", "Cubre contra todo tipo coronaVirus" , "HOSPITALARIA", '2020-02-02', '17:20:20', 14035.25)
;

INSERT INTO enfermedad (id, corazon , estomacal, rinyones, alergia, nombreAlergia) VALUES
(default, default,default,default,default, "penicilina"), 
(default, default,default,default,default, "amoxicilina");
select s.id, s.nif, count(a.seguroId) from seguro s join asistencia a on s.id = a.seguroId group by a.seguroId;

Select s.id, e.nombreAlergia from seguro s join enfermedad e on s.enfermedadId = e.id;


