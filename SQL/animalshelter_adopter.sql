-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: animalshelter
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `adopter`
--

DROP TABLE IF EXISTS `adopter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adopter` (
  `adopter_ID` int NOT NULL,
  `adopter_Approval` varchar(45) DEFAULT NULL,
  `adopter_FName` varchar(45) DEFAULT NULL,
  `adopter_Address` varchar(45) DEFAULT NULL,
  `adopter_LName` varchar(45) DEFAULT NULL,
  `adopter_PhoneNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adopter_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopter`
--

LOCK TABLES `adopter` WRITE;
/*!40000 ALTER TABLE `adopter` DISABLE KEYS */;
INSERT INTO `adopter` VALUES (123456789,'Pending','Lisa','72 Peach Tree Henry,NY 24517','Sanchez','(603) 923-0023'),(213430031,'Approved','Henry','956 Saint Drive,FL 65210','Lin','(103) 593-2013'),(492359321,'Approved','Joseph','312 Cherokee Hill Road, GA 31313','Willis','(912) 738-2930'),(657225341,'Approved','Jake','2 Mapple Hill,GA 32678','King','(201) 205-2913'),(768943612,'Denied','Jaquan','200 Bacon Way,NC 87112','Jones','(523) 251-3292');
/*!40000 ALTER TABLE `adopter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-24  1:21:39
