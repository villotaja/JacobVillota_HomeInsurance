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
-- Table structure for table `homeowner`
--

DROP TABLE IF EXISTS `homeowner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `homeowner` (
  `Homeowner_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `birthday` date NOT NULL,
  `retired` tinyint(4) NOT NULL,
  `ssn` varchar(9) NOT NULL,
  `user_user_id` int(11) NOT NULL,
  `Email` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`Homeowner_Id`),
  KEY `FK_user_user_Id_idx` (`user_user_id`),
  CONSTRAINT `FK_user_user_Id` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeowner`
--

LOCK TABLES `homeowner` WRITE;
/*!40000 ALTER TABLE `homeowner` DISABLE KEYS */;
INSERT INTO `homeowner` VALUES (28,'Jake','Jakester','1987-11-05',0,'456123',48,'jjjj'),(29,'Lenny','Bobster','1987-11-12',1,'456456456',48,'bob@bob.com'),(30,'kjljlkj','lkjlk','0999-11-30',0,'87987',48,'h@h.com'),(31,'lkjl','kjlk','1203-11-10',0,'789798',48,'j@j.com'),(32,'lkjl','kjlk','1203-11-10',0,'789798',48,'j@j.com'),(33,'liulkj','lkjlkj','1223-10-23',0,'6545654',48,'j@k.com'),(34,'skjasdlkj','lkjlkj','0999-11-30',0,'6545654',48,'Ja@kl.com'),(35,'skjasdlkj','lkjlkj','0999-11-30',0,'6545654',48,'Ja@kl.com'),(36,'jon','jonster','1992-10-10',1,'456123456',48,'Jon@jon.com');
/*!40000 ALTER TABLE `homeowner` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-29 16:07:45
