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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `Age` int DEFAULT NULL,
  `CageNum` int DEFAULT NULL,
  `Animal_ID` int NOT NULL,
  `Price` float DEFAULT NULL,
  `Animal_Name` varchar(45) DEFAULT NULL,
  `Species` varchar(45) DEFAULT NULL,
  `Adoption_Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Animal_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (2,4,116112537,150.5,'Orange','Cat','Not_Adopted'),(1,45,123456789,150,'Bud','Dog','Adopted'),(3,2,137474629,163.5,'George','Cat','Not_Adopted'),(13,7,158836721,176.5,'Luna','Dog','Not_Adopted'),(6,1,180198814,189.5,'Max','Dog','Adopted'),(2,23,201560906,202.5,'Greg','Cat','Not_Adopted'),(3,32,222922998,215.5,'Lobster','Cat','Not_Adopted'),(3,22,244285091,228.5,'Mori','Dog','Not_Adopted'),(2,43,265647183,241.5,'Red','Dog','Adopted'),(5,34,287009276,254.5,'Kooper','Cat','Not_Adopted'),(5,6,293012311,20,'Mr.Freckles','Cat','Not_Adopted'),(2,11,308371368,267.5,'Patty','Cat','Not_Adopted'),(2,21,456213212,75,'Sprinkles','Cat','Not_Adopted'),(0,24,781126235,175,'Coco','Dog','Not_Adopted'),(5,12,947504444,137.5,'Sasha','Dog','Adopted');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
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
