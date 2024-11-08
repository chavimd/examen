-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_emapa
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comprador`
--

DROP TABLE IF EXISTS `comprador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprador` (
  `id_comprador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `ci` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `celular` int(11) NOT NULL,
  PRIMARY KEY (`id_comprador`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprador`
--

LOCK TABLES `comprador` WRITE;
/*!40000 ALTER TABLE `comprador` DISABLE KEYS */;
INSERT INTO `comprador` VALUES (1,'Mario','Condori',11070710,'Prado',6484555),(3,'Maria','Fernandez',4899523,'Perez',4548484),(8,'lucho','paredez',10928215,'la perez',10928215),(9,'','',0,'',0);
/*!40000 ALTER TABLE `comprador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noperecedero`
--

DROP TABLE IF EXISTS `noperecedero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noperecedero` (
  `id_noPerecedero` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(100) NOT NULL,
  `id_producto` int(11) NOT NULL,
  PRIMARY KEY (`id_noPerecedero`),
  KEY `noperecedero_producto_FK` (`id_producto`),
  CONSTRAINT `noperecedero_producto_FK` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noperecedero`
--

LOCK TABLES `noperecedero` WRITE;
/*!40000 ALTER TABLE `noperecedero` DISABLE KEYS */;
/*!40000 ALTER TABLE `noperecedero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perecedero`
--

DROP TABLE IF EXISTS `perecedero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perecedero` (
  `id_perecedero` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `fechaCaducidad` varchar(100) NOT NULL,
  PRIMARY KEY (`id_perecedero`),
  KEY `perecedero_producto_FK` (`id_producto`),
  CONSTRAINT `perecedero_producto_FK` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perecedero`
--

LOCK TABLES `perecedero` WRITE;
/*!40000 ALTER TABLE `perecedero` DISABLE KEYS */;
INSERT INTO `perecedero` VALUES (7,14,'08-11-2024'),(8,1,'08-11-2024'),(9,1,'08-11-2024'),(10,1,'08-11-2024'),(41,1,'29-10-2024'),(42,1,'29-10-2024'),(43,1,'29-10-2024');
/*!40000 ALTER TABLE `perecedero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Leche',20,-15),(14,'Detergente',20,20),(15,'Detergente',20,20),(30,'Detergente',20,-10),(31,'Detergente',20,20),(32,'Detergente',20,20),(33,'Detergente',20,20),(34,'Detergente',20,20),(35,'Detergente',20,20),(36,'Detergente',20,20),(40,'Detergente',20,-100),(41,'Detergente',20,20),(42,'Detergente',20,20),(43,'Detergente',20,20),(44,'Detergente',20,20),(45,'Detergente',20,20),(46,'Detergente',20,20),(48,'Detergente',20,20),(49,'Detergente',20,20);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_comprador` int(11) NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `venta_comprador_FK` (`id_comprador`),
  CONSTRAINT `venta_comprador_FK` FOREIGN KEY (`id_comprador`) REFERENCES `comprador` (`id_comprador`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_producto`
--

DROP TABLE IF EXISTS `venta_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_producto` (
  `id_ventaProducto` int(11) NOT NULL AUTO_INCREMENT,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_ventaProducto`),
  KEY `venta_producto_producto_FK` (`id_producto`),
  KEY `venta_producto_venta_FK` (`id_venta`),
  CONSTRAINT `venta_producto_producto_FK` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `venta_producto_venta_FK` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_producto`
--

LOCK TABLES `venta_producto` WRITE;
/*!40000 ALTER TABLE `venta_producto` DISABLE KEYS */;
INSERT INTO `venta_producto` VALUES (2,1,1,5),(3,1,1,30),(5,1,30,30),(6,1,40,30),(7,1,40,30),(8,1,40,30),(9,1,40,30);
/*!40000 ALTER TABLE `venta_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bd_emapa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-08  3:27:01
