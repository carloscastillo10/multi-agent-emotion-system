-- -----------------------------------------------------
-- Schema emotionsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS emotionsdb; 
CREATE SCHEMA emotionsdb DEFAULT CHARACTER SET utf8;
USE emotionsdb;

-- -----------------------------------------------------
-- USER 'admin'
-- -----------------------------------------------------
DROP USER IF EXISTS 'admin'@'localhost';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT CREATE ON emotionsdb.* TO 'admin'@'localhost';
GRANT DROP ON emotionsdb.* TO 'admin'@'localhost';
GRANT DELETE ON emotionsdb.* TO 'admin'@'localhost';
GRANT INSERT ON emotionsdb.* TO 'admin'@'localhost';
GRANT SELECT ON emotionsdb.* TO 'admin'@'localhost';
GRANT UPDATE ON emotionsdb.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

-- -----------------------------------------------------
-- Table Emotion
-- -----------------------------------------------------
CREATE TABLE emotionsdb.Emotion(
  idEmotion INT NOT NULL AUTO_INCREMENT,
  nameEmotion VARCHAR(45) NOT NULL,
  PRIMARY KEY (idEmotion))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Recommendation
-- -----------------------------------------------------
CREATE TABLE emotionsdb.Recommendation(
  idRecommendation INT NOT NULL AUTO_INCREMENT,
  nameRecommendation VARCHAR(45) NULL,
  descriptionRecommendation LONGTEXT NULL,
  idEmotion INT NOT NULL,
  PRIMARY KEY (idRecommendation))
ENGINE = InnoDB;

ALTER TABLE emotionsdb.Recommendation
	ADD CONSTRAINT fk_Recommendation_Emotion
    FOREIGN KEY (idEmotion) REFERENCES Emotion(idEmotion);