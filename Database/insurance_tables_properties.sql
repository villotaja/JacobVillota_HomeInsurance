-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: insurance_tables
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `properties`
--

DROP TABLE IF EXISTS `properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `properties` (
  `property_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_value` double NOT NULL,
  `year_built` int(11) DEFAULT NULL,
  `sq_feet` int(11) DEFAULT NULL,
  `dwelling_style` varchar(45) DEFAULT NULL,
  `roof_material` varchar(45) DEFAULT NULL,
  `garage_type` varchar(45) DEFAULT NULL,
  `num_baths` int(11) DEFAULT NULL,
  `num_half_baths` int(11) DEFAULT NULL,
  `swimming_pool` tinyint(4) DEFAULT NULL,
  `locations_location_ID` int(11) NOT NULL,
  PRIMARY KEY (`property_id`),
  KEY `locations_location_id_idx` (`locations_location_ID`),
  CONSTRAINT `locations_location_id` FOREIGN KEY (`locations_location_ID`) REFERENCES `locations` (`location_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` VALUES (23,12837,123123,12312,'onestory','Concrete','Attached',1,1,0,38),(24,45645,1987,21453,'onestory','Concrete','Attached',1,1,0,39),(25,6546,1901,1231,'onestory','Concrete','Attached',1,1,0,40),(26,1234,1234,1256,'onestory','Concrete','Attached',1,1,0,41),(27,1234,1234,1256,'onestory','Concrete','Attached',1,1,0,42),(28,56465,2011,2135,'onestory','Concrete','Attached',1,1,0,43),(29,5,1980,1,'onestory','Concrete','Attached',1,1,0,44),(30,5,1980,1,'onestory','Concrete','Attached',1,1,0,45),(31,87987,1992,989,'onestory','Concrete','Attached',1,1,1,46);
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-29 16:07:44
