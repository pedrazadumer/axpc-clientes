CREATE SCHEMA IF NOT EXISTS `axpc`;
USE `axpc`;

-- -----------------------------------------------------
-- Table `usuarioTipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarioTipo` (
  `usTiId` INT NOT NULL,
  `usTiNombre` VARCHAR(45) NULL,
  `usTiUsuario` VARCHAR(45) NULL,
  `usTiFechaMod` DATETIME NULL,
  `usTiEstado` TINYINT NULL,
  PRIMARY KEY (`usTiId`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `usuarioTipoIdentificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarioTipoIdentificacion` (
  `usTiIdID` INT NULL,
  `ustiIdNombre` VARCHAR(45) NULL,
  `usTiIdAbrev` VARCHAR(45) NOT NULL, -- Cambiemos la llave primaria a la abreviatura
  `usTiIdFechaMod` DATETIME NULL,
  `usTiIdEstado` TINYINT NULL,
  PRIMARY KEY (`usTiIdAbrev`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `moneda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneda` (
  `monId` INT NOT NULL,
  `monNombre` VARCHAR(45) NULL,
  `monAbreviacion` VARCHAR(45) NULL,
  `monUsuario` VARCHAR(45) NULL,
  `monFechaMod` DATETIME NULL,
  `monEstado` TINYINT NULL,
  PRIMARY KEY (`monId`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario` (
  `usrId` INT NULL,
  `usrLogin` VARCHAR(90) NOT NULL, -- Cambiemos la llave primaria al Nombre De Usuario
  `usrPrimerNombre` VARCHAR(90) NOT NULL, -- Agreguemos la columna
  `usrSegundoNombre` VARCHAR(90) NULL, -- Agreguemos la columna
  `usrPrimerApellido` VARCHAR(90) NOT NULL, -- Agreguemos la columna
  `usrSegundoApellido` VARCHAR(90) NULL, -- Agreguemos la columna
  `usrCorreo` VARCHAR(90) NOT NULL,
  `usrUsTiId` INT NOT NULL,
  `usrPassHash` VARCHAR(256) NOT NULL, -- Aumentemos a 256
  `usrPaiId` INT NULL,
  `usrEstId` INT NULL,
  `usrCiuId` INT NULL,
  `usrDepartamento1` VARCHAR(256) NULL,
  `usrCiudad1` VARCHAR(256) NULL,
  `usrDireccion1` VARCHAR(45) NULL,
  `usrDireccion2` VARCHAR(45) NULL,
  `usrTelefono1` VARCHAR(45) NULL,
  `usrTelefono2` VARCHAR(45) NULL,
  `usrIdentificacion` VARCHAR(45) NOT NULL,
  `usrUsTiIdAbrev` VARCHAR(45) NOT NULL,
  `usrNombreEmpresa` VARCHAR(45) NULL,
  `usrMonid` INT NOT NULL,
  `usrUsuario` VARCHAR(45) NULL,
  `usrFechaMod` DATETIME NULL,
  `usrEstado` TINYINT NULL,
  PRIMARY KEY (`usrLogin`),
  UNIQUE INDEX `usrLogin_UNIQUE` (`usrLogin` ASC))
ENGINE = InnoDB;