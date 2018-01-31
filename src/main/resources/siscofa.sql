-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema siscofa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `siscofa` DEFAULT CHARACTER SET utf8 ;
USE `siscofa` ;

-- -----------------------------------------------------
-- Table `siscofa`.`tipo_movimentacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`tipo_movimentacao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siscofa`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `updated` DATETIME NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NULL DEFAULT NULL,
  `usuario` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_usuario` (`usuario` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siscofa`.`fazenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`fazenda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `qtd_alqueires` INT(11) NULL DEFAULT NULL,
  `total_gado_atual` INT(11) NULL,
  `usuario_id` INT(11) NULL DEFAULT NULL,
  `created` DATETIME NOT NULL,
  `updated` DATETIME NOT NULL,
  `excluido` INT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `FK_usuario_id` (`usuario_id` ASC),
  CONSTRAINT `FK_usuario_id`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `siscofa`.`usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siscofa`.`idade_gado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`idade_gado` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siscofa`.`movimentacao_gado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`movimentacao_gado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `valor` DOUBLE NULL,
  `peso` DOUBLE NULL,
  `sexo` CHAR(1) NULL,
  `data` DATE NOT NULL,
  `created` DATETIME NOT NULL,
  `updated` DATETIME NOT NULL,
  `tipo_movimentacao_id` INT(11) NOT NULL,
  `fazenda_id` INT(11) NOT NULL,
  `idade_gado_id` INT NOT NULL,
  `excluido` INT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_movimentacao_gado_tipo_movimentacao_idx` (`tipo_movimentacao_id` ASC),
  INDEX `fk_movimentacao_gado_fazenda1_idx` (`fazenda_id` ASC),
  INDEX `fk_movimentacao_gado_idade_gado1_idx` (`idade_gado_id` ASC),
  CONSTRAINT `fk_movimentacao_gado_tipo_movimentacao`
    FOREIGN KEY (`tipo_movimentacao_id`)
    REFERENCES `siscofa`.`tipo_movimentacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimentacao_gado_fazenda1`
    FOREIGN KEY (`fazenda_id`)
    REFERENCES `siscofa`.`fazenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimentacao_gado_idade_gado1`
    FOREIGN KEY (`idade_gado_id`)
    REFERENCES `siscofa`.`idade_gado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siscofa`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`funcionario` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `salario` FLOAT NULL,
  `fazenda_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_funcionario_fazenda1_idx` (`fazenda_id` ASC),
  CONSTRAINT `fk_funcionario_fazenda1`
    FOREIGN KEY (`fazenda_id`)
    REFERENCES `siscofa`.`fazenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siscofa`.`tipo_despesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`tipo_despesa` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(70) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siscofa`.`despesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`despesa` (
  `id` INT NOT NULL,
  `valor` DOUBLE NULL,
  `created` DATETIME NULL,
  `updated` DATETIME NULL,
  `tipo_despesa_id` INT NOT NULL,
  `fazenda_id` INT(11) NOT NULL,
  `excluido` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_Despesa_tipo_despesa1_idx` (`tipo_despesa_id` ASC),
  INDEX `fk_Despesa_fazenda1_idx` (`fazenda_id` ASC),
  CONSTRAINT `fk_Despesa_tipo_despesa1`
    FOREIGN KEY (`tipo_despesa_id`)
    REFERENCES `siscofa`.`tipo_despesa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Despesa_fazenda1`
    FOREIGN KEY (`fazenda_id`)
    REFERENCES `siscofa`.`fazenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siscofa`.`maquina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siscofa`.`maquina` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  `fazenda_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_maquina_fazenda1_idx` (`fazenda_id` ASC),
  CONSTRAINT `fk_maquina_fazenda1`
    FOREIGN KEY (`fazenda_id`)
    REFERENCES `siscofa`.`fazenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `siscofa` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
