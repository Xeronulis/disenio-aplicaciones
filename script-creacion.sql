-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fastDevelopmentDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fastDevelopmentDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fastDevelopmentDB` DEFAULT CHARACTER SET utf8 ;
USE `fastDevelopmentDB` ;

-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`EstadoLibro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`EstadoLibro` (
  `idestadoLibro` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idestadoLibro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Editorial` (
  `idEditorial` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idEditorial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Libro` (
  `numeroSerie` INT NOT NULL,
  `ISBN` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `numeroPaginas` INT NULL,
  `precioReferencia` DOUBLE NULL,
  `fechaPublicacion` DATE NULL,
  `idestadoLibro` INT NOT NULL,
  `idEditorial` INT NOT NULL,
  INDEX `fk_Libro_estadoLibro1_idx` (`idestadoLibro` ASC) VISIBLE,
  INDEX `fk_Libro_Editorial1_idx` (`idEditorial` ASC) VISIBLE,
  PRIMARY KEY (`numeroSerie`),
  CONSTRAINT `fk_Libro_estadoLibro1`
    FOREIGN KEY (`idestadoLibro`)
    REFERENCES `fastDevelopmentDB`.`EstadoLibro` (`idestadoLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_Editorial1`
    FOREIGN KEY (`idEditorial`)
    REFERENCES `fastDevelopmentDB`.`Editorial` (`idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Distribuidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Distribuidor` (
  `idDistribuidor` INT NOT NULL AUTO_INCREMENT,
  `rut` VARCHAR(16) NULL,
  `nombreEmpresa` VARCHAR(64) NULL,
  `direccion` VARCHAR(64) NULL,
  `telefono` VARCHAR(32) NULL,
  `inicioDistribuidor` YEAR NULL,
  PRIMARY KEY (`idDistribuidor`),
  UNIQUE INDEX `nombreEmpresa_UNIQUE` (`nombreEmpresa` ASC) VISIBLE,
  UNIQUE INDEX `direccion_UNIQUE` (`direccion` ASC) VISIBLE,
  UNIQUE INDEX `telefono_UNIQUE` (`telefono` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `rut` VARCHAR(16) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidoPaterno` VARCHAR(45) NULL,
  `apellidoMaterno` VARCHAR(45) NULL,
  `fechaNacimiento` DATE NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Trabajador` (
  `idtrabajador` INT NOT NULL AUTO_INCREMENT,
  `rut` VARCHAR(16) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidoPaterno` VARCHAR(45) NULL,
  `apellidoMaterno` VARCHAR(45) NULL,
  `fechaContrato` DATE NULL,
  PRIMARY KEY (`idtrabajador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellidoPaterno` VARCHAR(45) NULL,
  `apellidoMaterno` VARCHAR(45) NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`AutorLibro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`AutorLibro` (
  `idAutor` INT NOT NULL,
  `LibroNumeroSerie` INT NOT NULL,
  PRIMARY KEY (`idAutor`, `LibroNumeroSerie`),
  INDEX `fk_Autor_has_Libro_Libro1_idx` (`LibroNumeroSerie` ASC) VISIBLE,
  INDEX `fk_Autor_has_Libro_Autor_idx` (`idAutor` ASC) VISIBLE,
  CONSTRAINT `fk_Autor_has_Libro_Autor`
    FOREIGN KEY (`idAutor`)
    REFERENCES `fastDevelopmentDB`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Autor_has_Libro_Libro1`
    FOREIGN KEY (`LibroNumeroSerie`)
    REFERENCES `fastDevelopmentDB`.`Libro` (`numeroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Idioma` (
  `idIdioma` INT NOT NULL AUTO_INCREMENT,
  `idioma` VARCHAR(45) NULL,
  PRIMARY KEY (`idIdioma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`LibroIdioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`LibroIdioma` (
  `libroNumeroSerie` INT NOT NULL,
  `idIdioma` INT NOT NULL,
  PRIMARY KEY (`libroNumeroSerie`, `idIdioma`),
  INDEX `fk_Libro_has_Idioma_Idioma1_idx` (`idIdioma` ASC) VISIBLE,
  INDEX `fk_Libro_has_Idioma_Libro1_idx` (`libroNumeroSerie` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_has_Idioma_Libro1`
    FOREIGN KEY (`libroNumeroSerie`)
    REFERENCES `fastDevelopmentDB`.`Libro` (`numeroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_has_Idioma_Idioma1`
    FOREIGN KEY (`idIdioma`)
    REFERENCES `fastDevelopmentDB`.`Idioma` (`idIdioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`LibroCategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`LibroCategoria` (
  `libroNumeroSerie` INT NOT NULL,
  `idCategoria` INT NOT NULL,
  PRIMARY KEY (`libroNumeroSerie`, `idCategoria`),
  INDEX `fk_Libro_has_Categoria_Categoria1_idx` (`idCategoria` ASC) VISIBLE,
  INDEX `fk_Libro_has_Categoria_Libro1_idx` (`libroNumeroSerie` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_has_Categoria_Libro1`
    FOREIGN KEY (`libroNumeroSerie`)
    REFERENCES `fastDevelopmentDB`.`Libro` (`numeroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_has_Categoria_Categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `fastDevelopmentDB`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`TelefonoCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`TelefonoCliente` (
  `idCliente` INT NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  INDEX `fk_TelefonoCliente_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  PRIMARY KEY (`idCliente`, `numero`),
  CONSTRAINT `fk_TelefonoCliente_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `fastDevelopmentDB`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`DireccionCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`DireccionCliente` (
  `idCliente` INT NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  INDEX `fk_DireccionCliente_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  PRIMARY KEY (`idCliente`, `direccion`),
  CONSTRAINT `fk_DireccionCliente_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `fastDevelopmentDB`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`CorreoCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`CorreoCliente` (
  `idCliente` INT NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  INDEX `fk_CorreoCliente_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  PRIMARY KEY (`idCliente`, `correo`),
  CONSTRAINT `fk_CorreoCliente_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `fastDevelopmentDB`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`CorreoTrabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`CorreoTrabajador` (
  `idtrabajador` INT NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  INDEX `fk_CorreoTrabajador_trabajador1_idx` (`idtrabajador` ASC) VISIBLE,
  PRIMARY KEY (`idtrabajador`, `correo`),
  CONSTRAINT `fk_CorreoTrabajador_trabajador1`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `fastDevelopmentDB`.`Trabajador` (`idtrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`DireccionTrabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`DireccionTrabajador` (
  `idtrabajador` INT NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  INDEX `fk_DireccionTrabajador_trabajador1_idx` (`idtrabajador` ASC) VISIBLE,
  PRIMARY KEY (`idtrabajador`, `direccion`),
  CONSTRAINT `fk_DireccionTrabajador_trabajador1`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `fastDevelopmentDB`.`Trabajador` (`idtrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`TelefonoTrabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`TelefonoTrabajador` (
  `idtrabajador` INT NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  INDEX `fk_TelefonoTrabajador_trabajador1_idx` (`idtrabajador` ASC) VISIBLE,
  PRIMARY KEY (`idtrabajador`, `numero`),
  CONSTRAINT `fk_TelefonoTrabajador_trabajador1`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `fastDevelopmentDB`.`Trabajador` (`idtrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`MetodoPago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`MetodoPago` (
  `idMetodoPago` INT NOT NULL AUTO_INCREMENT,
  `metodo` VARCHAR(45) NULL,
  PRIMARY KEY (`idMetodoPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `idDistribuidor` INT NOT NULL,
  `folio` INT NOT NULL,
  `fechaCompra` DATE NULL,
  `horaCompra` TIME NULL,
  `idMetodoPago` INT NOT NULL,
  `costoTotal` DOUBLE NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_MetodoPago1_idx` (`idMetodoPago` ASC) VISIBLE,
  INDEX `fk_Factura_Distribuidor1_idx` (`idDistribuidor` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_MetodoPago1`
    FOREIGN KEY (`idMetodoPago`)
    REFERENCES `fastDevelopmentDB`.`MetodoPago` (`idMetodoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Distribuidor1`
    FOREIGN KEY (`idDistribuidor`)
    REFERENCES `fastDevelopmentDB`.`Distribuidor` (`idDistribuidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Compra` (
  `LibroNumeroSerie` INT NOT NULL,
  `idFactura` INT NOT NULL,
  `precioNeto` DOUBLE NULL,
  `precioConIva` DOUBLE NULL,
  `costoIva` DOUBLE NULL,
  PRIMARY KEY (`LibroNumeroSerie`, `idFactura`),
  INDEX `fk_Distribuidor_has_Libro_Libro1_idx` (`LibroNumeroSerie` ASC) VISIBLE,
  INDEX `fk_Compra_Factura1_idx` (`idFactura` ASC) VISIBLE,
  CONSTRAINT `fk_Distribuidor_has_Libro_Libro1`
    FOREIGN KEY (`LibroNumeroSerie`)
    REFERENCES `fastDevelopmentDB`.`Libro` (`numeroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Factura1`
    FOREIGN KEY (`idFactura`)
    REFERENCES `fastDevelopmentDB`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Boleta` (
  `idBoleta` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `folio` INT NULL,
  `idtrabajador` INT NOT NULL,
  `fechaVenta` DATE NULL,
  `horaVenta` TIME NULL,
  `idMetodoPago` INT NOT NULL,
  `costoTotal` DOUBLE NULL,
  PRIMARY KEY (`idBoleta`),
  INDEX `fk_Boleta_MetodoPago1_idx` (`idMetodoPago` ASC) VISIBLE,
  INDEX `fk_Boleta_Trabajador1_idx` (`idtrabajador` ASC) VISIBLE,
  INDEX `fk_Boleta_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Boleta_MetodoPago1`
    FOREIGN KEY (`idMetodoPago`)
    REFERENCES `fastDevelopmentDB`.`MetodoPago` (`idMetodoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Boleta_Trabajador1`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `fastDevelopmentDB`.`Trabajador` (`idtrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Boleta_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `fastDevelopmentDB`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Venta` (
  `LibroNumeroSerie` INT NOT NULL,
  `idBoleta` INT NOT NULL,
  `precioNeto` DOUBLE NULL,
  `precioConIva` DOUBLE NULL,
  `costoIva` DOUBLE NULL,
  PRIMARY KEY (`LibroNumeroSerie`, `idBoleta`),
  INDEX `fk_Cliente_has_Libro_Libro1_idx` (`LibroNumeroSerie` ASC) VISIBLE,
  INDEX `fk_Venta_Boleta1_idx` (`idBoleta` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_has_Libro_Libro1`
    FOREIGN KEY (`LibroNumeroSerie`)
    REFERENCES `fastDevelopmentDB`.`Libro` (`numeroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Boleta1`
    FOREIGN KEY (`idBoleta`)
    REFERENCES `fastDevelopmentDB`.`Boleta` (`idBoleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`Arriendo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`Arriendo` (
  `idArriendo` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idtrabajador` INT NOT NULL,
  `fecha` DATE NULL,
  `fechaDevolEst` DATE NULL,
  `fechaDevolReal` DATE NULL,
  `diasRetraso` INT NULL,
  `costoArriendo` DOUBLE NULL,
  `multa` DOUBLE NULL,
  `costoTotal` DOUBLE NULL,
  PRIMARY KEY (`idArriendo`),
  INDEX `fk_Arriendo_Trabajador1_idx` (`idtrabajador` ASC) VISIBLE,
  INDEX `fk_Arriendo_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Arriendo_Trabajador1`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `fastDevelopmentDB`.`Trabajador` (`idtrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Arriendo_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `fastDevelopmentDB`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fastDevelopmentDB`.`LibroParaArriendo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fastDevelopmentDB`.`LibroParaArriendo` (
  `libroNumeroSerie` INT NOT NULL,
  `idArriendo` INT NOT NULL,
  PRIMARY KEY (`libroNumeroSerie`, `idArriendo`),
  INDEX `fk_Cliente_has_Libro_Libro2_idx` (`libroNumeroSerie` ASC) VISIBLE,
  INDEX `fk_LibroParaArriendo_Arriendo1_idx` (`idArriendo` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_has_Libro_Libro2`
    FOREIGN KEY (`libroNumeroSerie`)
    REFERENCES `fastDevelopmentDB`.`Libro` (`numeroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LibroParaArriendo_Arriendo1`
    FOREIGN KEY (`idArriendo`)
    REFERENCES `fastDevelopmentDB`.`Arriendo` (`idArriendo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
