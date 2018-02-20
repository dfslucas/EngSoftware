
CREATE SCHEMA IF NOT EXISTS `aluguelcarro` DEFAULT CHARACTER SET utf8 ;
USE `aluguelcarro` ;

-- -----------------------------------------------------
-- Table `aluguelcarro`.`carros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluguelcarro`.`carros` (
  `placa` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`placa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `aluguelcarro`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluguelcarro`.`clientes` (
  `cpf` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `aluguelcarro`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluguelcarro`.`reservas` (
  `Clientes_cpf` VARCHAR(45) NOT NULL,
  `Carros_placa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Clientes_cpf`, `Carros_placa`),
  INDEX `Carros_placa` (`Carros_placa` ASC),
  CONSTRAINT `reservas_ibfk_1`
    FOREIGN KEY (`Clientes_cpf`)
    REFERENCES `aluguelcarro`.`clientes` (`cpf`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `reservas_ibfk_2`
    FOREIGN KEY (`Carros_placa`)
    REFERENCES `aluguelcarro`.`carros` (`placa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO carros (`placa`, `modelo`) VALUES ("ABC1234", "Camaro");
INSERT INTO carros (`placa`, `modelo`) VALUES ("QWE1234", "Cruzer");
INSERT INTO carros (`placa`, `modelo`) VALUES ("DFG1234", "Uno");

INSERT INTO clientes (`cpf`, `nome`, `endereco`) VALUES ("234.567.89-5", "Andre Jorge", "Rua das alamedas n 451");
INSERT INTO clientes (`cpf`, `nome`, `endereco`) VALUES ("388.123.70-3", "Jose Carlos", "Rua das Melancias n 123");