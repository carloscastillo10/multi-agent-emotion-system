-- -----------------------------------------------------
-- Schema emotionsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS emotionsdb; 
CREATE SCHEMA emotionsdb DEFAULT CHARACTER SET utf8;
USE emotionsdb;

-- -----------------------------------------------------
-- USER 'admin'
-- -----------------------------------------------------
DROP USER IF EXISTS 'teacher'@'localhost';
CREATE USER 'teacher'@'localhost' IDENTIFIED BY 'teacher';

GRANT SELECT ON emotionsdb.* TO 'teacher'@'localhost';

FLUSH PRIVILEGES;

-- -----------------------------------------------------
-- Table Emotion
-- -----------------------------------------------------
CREATE TABLE emotionsdb.Emotion(
  idEmotion VARCHAR(11) NOT NULL,
  nameEmotion VARCHAR(45) NOT NULL,
  PRIMARY KEY (idEmotion))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Cause
-- -----------------------------------------------------
CREATE TABLE emotionsdb.Cause(
  idCause VARCHAR(11) NOT NULL,
  descriptionCause LONGTEXT NULL,
  idEmotion VARCHAR(11) NOT NULL,
  PRIMARY KEY (idCause))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Recommendation
-- -----------------------------------------------------
CREATE TABLE emotionsdb.Recommendation(
  idRecommendation VARCHAR(11) NOT NULL,
  descriptionRecommendation LONGTEXT NULL,
  idEmotion VARCHAR(11) NOT NULL,
  PRIMARY KEY (idRecommendation))
ENGINE = InnoDB;

ALTER TABLE emotionsdb.Cause
	ADD CONSTRAINT fk_Cause_Emotion
    FOREIGN KEY (idEmotion) REFERENCES Emotion(idEmotion);
    
ALTER TABLE emotionsdb.Recommendation
	ADD CONSTRAINT fk_Recommendation_Emotion
    FOREIGN KEY (idEmotion) REFERENCES Emotion(idEmotion);

-- -----------------------------------------------------
-- Insert values of table Emotion
-- -----------------------------------------------------    
INSERT INTO emotionsdb.Emotion(idEmotion, nameEmotion) VALUES ('em-001','Alegría');
INSERT INTO emotionsdb.Emotion(idEmotion, nameEmotion) VALUES ('em-002','Aburrimiento');
INSERT INTO emotionsdb.Emotion(idEmotion, nameEmotion) VALUES ('em-003','Enojo');

-- -----------------------------------------------------
-- insert causes of 'Alegría' emotion
-- -----------------------------------------------------    
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-001','Didáctica empleada permite que los alumnos puedan interactuar y de esta forma eviten el aburrimiento.', 'em-001');
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-002','Los contenidos mostrados en la clase son interesantes y dinámicos.', 'em-001');
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-003','Su forma de impartir la clase es entretenida e innovadora.', 'em-001');

-- -----------------------------------------------------
-- insert causes of 'Aburrimiento' emotion
-- -----------------------------------------------------    
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-004','Falta de material didáctico.', 'em-002');
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-005','Presenta material en el que se encuentra mucho texto.', 'em-002');
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-006','No busca formas innovadoras de presentar un tema.', 'em-002');

-- -----------------------------------------------------
-- insert recommendatios of 'Aburrimiento' emotion
-- -----------------------------------------------------
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-001', 'Estimular producción de los estudiantes.', 'em-002'); 
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-002', 'Promover el dialogo y discusiones respetuosas.', 'em-002');
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-003', 'Brindar la opción de mayor participación al alumno.', 'em-002');  
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-004', 'Confrontar distintos puntos de vista.', 'em-002');

-- -----------------------------------------------------
-- insert causes of 'Enojo' emotion
-- -----------------------------------------------------    
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-007','Ambigua, confusa y desorganizada.', 'em-003');
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-008','Falta de preparación del material didáctico empleado en la clase.', 'em-003');
INSERT INTO emotionsdb.Cause(idCause, descriptionCause, idEmotion) VALUES ('ca-009','Se realiza interrogatorios o pruebas de improviso.', 'em-003');         

-- -----------------------------------------------------
-- insert recommendatios of 'Enojo' emotion
-- -----------------------------------------------------
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-005', 'Tratar contenido contextualizados en las experiencias propias cuya aplicación se pueda visualizar en la práctica.', 'em-003'); 
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-006', 'Valorar al estudiante y su esfuerzo.', 'em-003');
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-007', 'Ampliar la capacidad de tolerancia.', 'em-003');  
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-008', 'Ofrecer retroalimentación a sus alumnos.', 'em-003');
INSERT INTO emotionsdb.Recommendation(idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-009', 'Captar los distintos mensajes que transmiten los alumnos.', 'em-003');