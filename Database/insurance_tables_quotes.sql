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
-- Table structure for table `quotes`
--

DROP TABLE IF EXISTS `quotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quotes` (
  `Quote_ID` int(11) NOT NULL AUTO_INCREMENT,
  `monthly_premium` double NOT NULL,
  `dwelling_coverage` double NOT NULL,
  `detached_structures` double NOT NULL,
  `personal_property` double NOT NULL,
  `additional_living_exp` double NOT NULL,
  `med_exp` double NOT NULL,
  `deductible` double NOT NULL,
  `locations_location` int(11) NOT NULL,
  `user_users_ID` int(11) NOT NULL,
  `homeowner_quote_ID` int(11) NOT NULL,
  PRIMARY KEY (`Quote_ID`),
  KEY `FK_locations_location_idx` (`locations_location`),
  KEY `FK_user_users_idx` (`user_users_ID`),
  KEY `FK_homeowner_quote_idx` (`homeowner_quote_ID`),
  CONSTRAINT `FK_homeowner_quote` FOREIGN KEY (`homeowner_quote_ID`) REFERENCES `homeowner` (`homeowner_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_locations_location` FOREIGN KEY (`locations_location`) REFERENCES `locations` (`location_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_users` FOREIGN KEY (`user_users_ID`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotes`
--

LOCK TABLES `quotes` WRITE;
/*!40000 ALTER TABLE `quotes` DISABLE KEYS */;
INSERT INTO `quotes` VALUES (26,310,745138.5,74514,447083,149028,5000,128,38,48,28),(27,546,1310002.5,131000,786002,262001,5000,456,39,48,29),(28,32,77133,7713,46280,15427,5000,65,40,48,30),(29,32,75977,7598,45586,15195,5000,12,41,48,31),(30,32,75977,7598,45586,15195,5000,12,42,48,32),(31,65,156332.5,15633,93800,31267,5000,565,43,48,33),(32,0,62.5,6,38,13,5000,0,44,48,34),(33,0,62.5,6,38,13,5000,0,45,48,35),(34,43,103333.5,10333,62000,20667,5000,880,46,48,36);
/*!40000 ALTER TABLE `quotes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-29 16:07:43
