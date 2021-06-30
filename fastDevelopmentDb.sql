-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fastdevelopmentdb
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arriendo`
--

DROP TABLE IF EXISTS `arriendo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arriendo` (
  `idArriendo` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idtrabajador` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `fechaDevolEst` date DEFAULT NULL,
  `fechaDevolReal` date DEFAULT NULL,
  `diasRetraso` int DEFAULT NULL,
  `costoArriendo` double DEFAULT NULL,
  `multa` double DEFAULT NULL,
  `costoTotal` double DEFAULT NULL,
  PRIMARY KEY (`idArriendo`),
  KEY `fk_Arriendo_Trabajador1_idx` (`idtrabajador`),
  KEY `fk_Arriendo_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_Arriendo_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_Arriendo_Trabajador1` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arriendo`
--

LOCK TABLES `arriendo` WRITE;
/*!40000 ALTER TABLE `arriendo` DISABLE KEYS */;
/*!40000 ALTER TABLE `arriendo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidoPaterno` varchar(45) DEFAULT NULL,
  `apellidoMaterno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Manuel','Pereira','Rojas');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorlibro`
--

DROP TABLE IF EXISTS `autorlibro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autorlibro` (
  `idAutor` int NOT NULL,
  `LibroNumeroSerie` int NOT NULL,
  PRIMARY KEY (`idAutor`,`LibroNumeroSerie`),
  KEY `fk_Autor_has_Libro_Libro1_idx` (`LibroNumeroSerie`),
  KEY `fk_Autor_has_Libro_Autor_idx` (`idAutor`),
  CONSTRAINT `fk_Autor_has_Libro_Autor` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`),
  CONSTRAINT `fk_Autor_has_Libro_Libro1` FOREIGN KEY (`LibroNumeroSerie`) REFERENCES `libro` (`numeroSerie`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorlibro`
--

LOCK TABLES `autorlibro` WRITE;
/*!40000 ALTER TABLE `autorlibro` DISABLE KEYS */;
INSERT INTO `autorlibro` VALUES (1,23315);
/*!40000 ALTER TABLE `autorlibro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boleta`
--

DROP TABLE IF EXISTS `boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boleta` (
  `idBoleta` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `folio` int DEFAULT NULL,
  `idtrabajador` int NOT NULL,
  `fechaVenta` date DEFAULT NULL,
  `horaVenta` time DEFAULT NULL,
  `idMetodoPago` int NOT NULL,
  `costoTotal` double DEFAULT NULL,
  PRIMARY KEY (`idBoleta`),
  KEY `fk_Boleta_MetodoPago1_idx` (`idMetodoPago`),
  KEY `fk_Boleta_Trabajador1_idx` (`idtrabajador`),
  KEY `fk_Boleta_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_Boleta_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_Boleta_MetodoPago1` FOREIGN KEY (`idMetodoPago`) REFERENCES `metodopago` (`idMetodoPago`),
  CONSTRAINT `fk_Boleta_Trabajador1` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boleta`
--

LOCK TABLES `boleta` WRITE;
/*!40000 ALTER TABLE `boleta` DISABLE KEYS */;
/*!40000 ALTER TABLE `boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'best categoria');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `rut` varchar(16) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidoPaterno` varchar(45) DEFAULT NULL,
  `apellidoMaterno` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `LibroNumeroSerie` int NOT NULL,
  `idFactura` int NOT NULL,
  `precioNeto` double DEFAULT NULL,
  `precioConIva` double DEFAULT NULL,
  `costoIva` double DEFAULT NULL,
  PRIMARY KEY (`LibroNumeroSerie`,`idFactura`),
  KEY `fk_Distribuidor_has_Libro_Libro1_idx` (`LibroNumeroSerie`),
  KEY `fk_Compra_Factura1_idx` (`idFactura`),
  CONSTRAINT `fk_Compra_Factura1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`),
  CONSTRAINT `fk_Distribuidor_has_Libro_Libro1` FOREIGN KEY (`LibroNumeroSerie`) REFERENCES `libro` (`numeroSerie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correocliente`
--

DROP TABLE IF EXISTS `correocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `correocliente` (
  `idCliente` int NOT NULL,
  `correo` varchar(100) NOT NULL,
  PRIMARY KEY (`idCliente`,`correo`),
  KEY `fk_CorreoCliente_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_CorreoCliente_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correocliente`
--

LOCK TABLES `correocliente` WRITE;
/*!40000 ALTER TABLE `correocliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `correocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correotrabajador`
--

DROP TABLE IF EXISTS `correotrabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `correotrabajador` (
  `idtrabajador` int NOT NULL,
  `correo` varchar(100) NOT NULL,
  PRIMARY KEY (`idtrabajador`,`correo`),
  KEY `fk_CorreoTrabajador_trabajador1_idx` (`idtrabajador`),
  CONSTRAINT `fk_CorreoTrabajador_trabajador1` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correotrabajador`
--

LOCK TABLES `correotrabajador` WRITE;
/*!40000 ALTER TABLE `correotrabajador` DISABLE KEYS */;
/*!40000 ALTER TABLE `correotrabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccioncliente`
--

DROP TABLE IF EXISTS `direccioncliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccioncliente` (
  `idCliente` int NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`idCliente`,`direccion`),
  KEY `fk_DireccionCliente_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_DireccionCliente_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccioncliente`
--

LOCK TABLES `direccioncliente` WRITE;
/*!40000 ALTER TABLE `direccioncliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `direccioncliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciontrabajador`
--

DROP TABLE IF EXISTS `direcciontrabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciontrabajador` (
  `idtrabajador` int NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`idtrabajador`,`direccion`),
  KEY `fk_DireccionTrabajador_trabajador1_idx` (`idtrabajador`),
  CONSTRAINT `fk_DireccionTrabajador_trabajador1` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciontrabajador`
--

LOCK TABLES `direcciontrabajador` WRITE;
/*!40000 ALTER TABLE `direcciontrabajador` DISABLE KEYS */;
/*!40000 ALTER TABLE `direcciontrabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuidor`
--

DROP TABLE IF EXISTS `distribuidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribuidor` (
  `idDistribuidor` int NOT NULL AUTO_INCREMENT,
  `rut` varchar(16) DEFAULT NULL,
  `nombreEmpresa` varchar(64) DEFAULT NULL,
  `direccion` varchar(64) DEFAULT NULL,
  `telefono` varchar(32) DEFAULT NULL,
  `inicioDistribuidor` year DEFAULT NULL,
  PRIMARY KEY (`idDistribuidor`),
  UNIQUE KEY `nombreEmpresa_UNIQUE` (`nombreEmpresa`),
  UNIQUE KEY `direccion_UNIQUE` (`direccion`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuidor`
--

LOCK TABLES `distribuidor` WRITE;
/*!40000 ALTER TABLE `distribuidor` DISABLE KEYS */;
INSERT INTO `distribuidor` VALUES (2,'2025','generic dist','sas de ses123','1020',2021),(3,'99182k','toi potente','direccion potente','9073273',2021);
/*!40000 ALTER TABLE `distribuidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editorial` (
  `idEditorial` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEditorial`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` VALUES (2,'editorial potente'),(6,'wena'),(7,'hola'),(16,'sas'),(17,'ses');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadolibro`
--

DROP TABLE IF EXISTS `estadolibro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadolibro` (
  `idEstadoLibro` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstadoLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadolibro`
--

LOCK TABLES `estadolibro` WRITE;
/*!40000 ALTER TABLE `estadolibro` DISABLE KEYS */;
INSERT INTO `estadolibro` VALUES (1,'ta bien');
/*!40000 ALTER TABLE `estadolibro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idFactura` int NOT NULL AUTO_INCREMENT,
  `idDistribuidor` int NOT NULL,
  `folio` int NOT NULL,
  `fechaCompra` date DEFAULT NULL,
  `horaCompra` time DEFAULT NULL,
  `idMetodoPago` int NOT NULL,
  `costoTotal` double DEFAULT NULL,
  `locked` tinyint DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_Factura_MetodoPago1_idx` (`idMetodoPago`),
  KEY `fk_Factura_Distribuidor1_idx` (`idDistribuidor`),
  CONSTRAINT `fk_Factura_Distribuidor1` FOREIGN KEY (`idDistribuidor`) REFERENCES `distribuidor` (`idDistribuidor`),
  CONSTRAINT `fk_Factura_MetodoPago1` FOREIGN KEY (`idMetodoPago`) REFERENCES `metodopago` (`idMetodoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idioma`
--

DROP TABLE IF EXISTS `idioma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `idioma` (
  `idIdioma` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idIdioma`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idioma`
--

LOCK TABLES `idioma` WRITE;
/*!40000 ALTER TABLE `idioma` DISABLE KEYS */;
INSERT INTO `idioma` VALUES (1,'shileno');
/*!40000 ALTER TABLE `idioma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `numeroSerie` int NOT NULL,
  `ISBN` varchar(45) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `numeroPaginas` int DEFAULT NULL,
  `precioReferencia` double DEFAULT NULL,
  `fechaPublicacion` date DEFAULT NULL,
  `idestadoLibro` int NOT NULL,
  `idEditorial` int NOT NULL,
  PRIMARY KEY (`numeroSerie`),
  KEY `fk_Libro_estadoLibro1_idx` (`idestadoLibro`),
  KEY `fk_Libro_Editorial1_idx` (`idEditorial`),
  CONSTRAINT `fk_Libro_Editorial1` FOREIGN KEY (`idEditorial`) REFERENCES `editorial` (`idEditorial`),
  CONSTRAINT `fk_Libro_estadoLibro1` FOREIGN KEY (`idestadoLibro`) REFERENCES `estadolibro` (`idEstadoLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (23315,'1234','Soy un librito',93,95.23,'2000-02-12',1,2);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librocategoria`
--

DROP TABLE IF EXISTS `librocategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librocategoria` (
  `libroNumeroSerie` int NOT NULL,
  `idCategoria` int NOT NULL,
  PRIMARY KEY (`libroNumeroSerie`,`idCategoria`),
  KEY `fk_Libro_has_Categoria_Categoria1_idx` (`idCategoria`),
  KEY `fk_Libro_has_Categoria_Libro1_idx` (`libroNumeroSerie`),
  CONSTRAINT `fk_Libro_has_Categoria_Categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  CONSTRAINT `fk_Libro_has_Categoria_Libro1` FOREIGN KEY (`libroNumeroSerie`) REFERENCES `libro` (`numeroSerie`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librocategoria`
--

LOCK TABLES `librocategoria` WRITE;
/*!40000 ALTER TABLE `librocategoria` DISABLE KEYS */;
INSERT INTO `librocategoria` VALUES (23315,1);
/*!40000 ALTER TABLE `librocategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libroidioma`
--

DROP TABLE IF EXISTS `libroidioma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libroidioma` (
  `libroNumeroSerie` int NOT NULL,
  `idIdioma` int NOT NULL,
  PRIMARY KEY (`libroNumeroSerie`,`idIdioma`),
  KEY `fk_Libro_has_Idioma_Idioma1_idx` (`idIdioma`),
  KEY `fk_Libro_has_Idioma_Libro1_idx` (`libroNumeroSerie`),
  CONSTRAINT `fk_Libro_has_Idioma_Idioma1` FOREIGN KEY (`idIdioma`) REFERENCES `idioma` (`idIdioma`),
  CONSTRAINT `fk_Libro_has_Idioma_Libro1` FOREIGN KEY (`libroNumeroSerie`) REFERENCES `libro` (`numeroSerie`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libroidioma`
--

LOCK TABLES `libroidioma` WRITE;
/*!40000 ALTER TABLE `libroidioma` DISABLE KEYS */;
INSERT INTO `libroidioma` VALUES (23315,1);
/*!40000 ALTER TABLE `libroidioma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libroparaarriendo`
--

DROP TABLE IF EXISTS `libroparaarriendo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libroparaarriendo` (
  `libroNumeroSerie` int NOT NULL,
  `idArriendo` int NOT NULL,
  PRIMARY KEY (`libroNumeroSerie`,`idArriendo`),
  KEY `fk_Cliente_has_Libro_Libro2_idx` (`libroNumeroSerie`),
  KEY `fk_LibroParaArriendo_Arriendo1_idx` (`idArriendo`),
  CONSTRAINT `fk_Cliente_has_Libro_Libro2` FOREIGN KEY (`libroNumeroSerie`) REFERENCES `libro` (`numeroSerie`),
  CONSTRAINT `fk_LibroParaArriendo_Arriendo1` FOREIGN KEY (`idArriendo`) REFERENCES `arriendo` (`idArriendo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libroparaarriendo`
--

LOCK TABLES `libroparaarriendo` WRITE;
/*!40000 ALTER TABLE `libroparaarriendo` DISABLE KEYS */;
/*!40000 ALTER TABLE `libroparaarriendo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodopago`
--

DROP TABLE IF EXISTS `metodopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodopago` (
  `idMetodoPago` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMetodoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodopago`
--

LOCK TABLES `metodopago` WRITE;
/*!40000 ALTER TABLE `metodopago` DISABLE KEYS */;
/*!40000 ALTER TABLE `metodopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonocliente`
--

DROP TABLE IF EXISTS `telefonocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonocliente` (
  `idCliente` int NOT NULL,
  `numero` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`,`numero`),
  KEY `fk_TelefonoCliente_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_TelefonoCliente_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonocliente`
--

LOCK TABLES `telefonocliente` WRITE;
/*!40000 ALTER TABLE `telefonocliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonotrabajador`
--

DROP TABLE IF EXISTS `telefonotrabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonotrabajador` (
  `idtrabajador` int NOT NULL,
  `numero` varchar(45) NOT NULL,
  PRIMARY KEY (`idtrabajador`,`numero`),
  KEY `fk_TelefonoTrabajador_trabajador1_idx` (`idtrabajador`),
  CONSTRAINT `fk_TelefonoTrabajador_trabajador1` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonotrabajador`
--

LOCK TABLES `telefonotrabajador` WRITE;
/*!40000 ALTER TABLE `telefonotrabajador` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonotrabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador` (
  `idtrabajador` int NOT NULL AUTO_INCREMENT,
  `rut` varchar(16) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidoPaterno` varchar(45) DEFAULT NULL,
  `apellidoMaterno` varchar(45) DEFAULT NULL,
  `fechaContrato` date DEFAULT NULL,
  PRIMARY KEY (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `LibroNumeroSerie` int NOT NULL,
  `idBoleta` int NOT NULL,
  `precioNeto` double DEFAULT NULL,
  `precioConIva` double DEFAULT NULL,
  `costoIva` double DEFAULT NULL,
  PRIMARY KEY (`LibroNumeroSerie`,`idBoleta`),
  KEY `fk_Cliente_has_Libro_Libro1_idx` (`LibroNumeroSerie`),
  KEY `fk_Venta_Boleta1_idx` (`idBoleta`),
  CONSTRAINT `fk_Cliente_has_Libro_Libro1` FOREIGN KEY (`LibroNumeroSerie`) REFERENCES `libro` (`numeroSerie`),
  CONSTRAINT `fk_Venta_Boleta1` FOREIGN KEY (`idBoleta`) REFERENCES `boleta` (`idBoleta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-30 12:57:13
