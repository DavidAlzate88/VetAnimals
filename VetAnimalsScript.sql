-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema VetAnimals
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `VetAnimals` ;

-- -----------------------------------------------------
-- Schema VetAnimals
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `VetAnimals` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `VetAnimals` ;

-- -----------------------------------------------------
-- Table `VetAnimals`.`PAISES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetAnimals`.`PAISES` (
  `id_pais` INT NOT NULL COMMENT '',
  `nombre_pais` VARCHAR(60) NOT NULL COMMENT '',
  PRIMARY KEY (`id_pais`)  COMMENT '',
  UNIQUE INDEX `id_pais_UNIQUE` (`id_pais` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VetAnimals`.`DEPARTAMENTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetAnimals`.`DEPARTAMENTOS` (
  `id_departamento` INT NOT NULL COMMENT '',
  `nombre_departamento` VARCHAR(45) NOT NULL COMMENT '',
  `id_pais` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_departamento`, `id_pais`)  COMMENT '',
  INDEX `fk_DEPARTAMENTOS_PAISES_idx` (`id_pais` ASC)  COMMENT '',
  UNIQUE INDEX `id_departamentos_UNIQUE` (`id_departamento` ASC)  COMMENT '',
  CONSTRAINT `fk_DEPARTAMENTOS_PAISES`
    FOREIGN KEY (`id_pais`)
    REFERENCES `VetAnimals`.`PAISES` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VetAnimals`.`CIUDADES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetAnimals`.`CIUDADES` (
  `id_ciudad` INT NOT NULL COMMENT '',
  `nombre_ciudad` VARCHAR(60) NOT NULL COMMENT '',
  `id_departamento` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_ciudad`, `id_departamento`)  COMMENT '',
  INDEX `fk_CIUDAD_DEPARTAMENTOS1_idx` (`id_departamento` ASC)  COMMENT '',
  UNIQUE INDEX `id_ciudad_UNIQUE` (`id_ciudad` ASC)  COMMENT '',
  CONSTRAINT `fk_CIUDAD_DEPARTAMENTOS1`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `VetAnimals`.`DEPARTAMENTOS` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VetAnimals`.`ROLES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetAnimals`.`ROLES` (
  `id_rol` INT NOT NULL COMMENT '',
  `nombre_rol` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id_rol`)  COMMENT '',
  UNIQUE INDEX `id_rol_UNIQUE` (`id_rol` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VetAnimals`.`USUARIOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetAnimals`.`USUARIOS` (
  `id_usuario` INT NULL AUTO_INCREMENT COMMENT '',
  `nombres` VARCHAR(45) NOT NULL COMMENT '',
  `apellidos` VARCHAR(45) NOT NULL COMMENT '',
  `telefono` CHAR(25) NOT NULL COMMENT '',
  `direccion` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `password` VARCHAR(200) NOT NULL COMMENT '',
  `id_ciudad` INT NOT NULL COMMENT '',
  `id_roles` INT NOT NULL COMMENT '',
  `fecha_nac` DATE NOT NULL COMMENT '',
  `sexo` VARCHAR(1) NOT NULL COMMENT '',
  PRIMARY KEY (`id_usuario`, `id_ciudad`, `id_roles`)  COMMENT '',
  INDEX `fk_USUARIOS_CIUDAD1_idx` (`id_ciudad` ASC)  COMMENT '',
  INDEX `fk_USUARIOS_ROLES1_idx` (`id_roles` ASC)  COMMENT '',
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC)  COMMENT '',
  CONSTRAINT `fk_USUARIOS_CIUDAD1`
    FOREIGN KEY (`id_ciudad`)
    REFERENCES `VetAnimals`.`CIUDADES` (`id_ciudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIOS_ROLES1`
    FOREIGN KEY (`id_roles`)
    REFERENCES `VetAnimals`.`ROLES` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `VetAnimals`.`PAISES`
-- -----------------------------------------------------
START TRANSACTION;
USE `VetAnimals`;
INSERT INTO `VetAnimals`.`PAISES` (`id_pais`, `nombre_pais`) VALUES (1, 'Colombia');

COMMIT;


-- -----------------------------------------------------
-- Data for table `VetAnimals`.`DEPARTAMENTOS`
-- -----------------------------------------------------
START TRANSACTION;
USE `VetAnimals`;
INSERT INTO `VetAnimals`.`DEPARTAMENTOS` (`id_departamento`, `nombre_departamento`, `id_pais`) VALUES (1, 'valle', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `VetAnimals`.`CIUDADES`
-- -----------------------------------------------------
START TRANSACTION;
USE `VetAnimals`;
INSERT INTO `VetAnimals`.`CIUDADES` (`id_ciudad`, `nombre_ciudad`, `id_departamento`) VALUES (1, 'palmira', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `VetAnimals`.`ROLES`
-- -----------------------------------------------------
START TRANSACTION;
USE `VetAnimals`;
INSERT INTO `VetAnimals`.`ROLES` (`id_rol`, `nombre_rol`) VALUES (1, 'Admin');
INSERT INTO `VetAnimals`.`ROLES` (`id_rol`, `nombre_rol`) VALUES (2, 'Cliente');
INSERT INTO `VetAnimals`.`ROLES` (`id_rol`, `nombre_rol`) VALUES (3, 'Veterinaria');

COMMIT;


-- -----------------------------------------------------
-- Data for table `VetAnimals`.`USUARIOS`
-- -----------------------------------------------------
START TRANSACTION;
USE `VetAnimals`;
INSERT INTO `VetAnimals`.`USUARIOS` (`id_usuario`, `nombres`, `apellidos`, `telefono`, `direccion`, `email`, `password`, `id_ciudad`, `id_roles`, `fecha_nac`, `sexo`) VALUES (1, 'david', 'alzate', '1234', 'calle falsa 123', 'davids20xx@misena.edu.co', 'david1234', 1, 2, '1988/09/18', 'm');

COMMIT;

