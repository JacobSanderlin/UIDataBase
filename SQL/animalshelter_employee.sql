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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `role` varchar(45) DEFAULT NULL,
  `fName` varchar(45) DEFAULT NULL,
  `employee_ID` int NOT NULL,
  `SSN` int NOT NULL DEFAULT '0',
  `sex` varchar(45) DEFAULT NULL,
  `lName` varchar(45) DEFAULT NULL,
  `hours` int DEFAULT NULL,
  `supervisor_ID` int NOT NULL,
  PRIMARY KEY (`employee_ID`,`SSN`),
  UNIQUE KEY `Employee_SSN_UNIQUE` (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('Unpaid Intern','George',1114321,934252123,'M','Cantwell',15,9999999),('General','John',1234567,111223333,'M','Smith',35,7654321),('Unpaid Intern','Albert',1258393,634723143,'M','Wong',33,7654321),('General','Annie',2737482,542132112,'F','Chang',31,7654321),('General','Lindsey',3940613,993124883,'F','Reeve',23,9999999),('General','Bob',4443123,447323123,'M','Johnson',20,7654321),('General','Thomas',5455453,663421632,'M','Bush',37,9999999),('Unpaid Intern','Kaitlyn',5554444,956231245,'F','Porter',24,9999999),('General','Lance',5912912,583942131,'M','Miracle',34,7654321),('General','April',5942034,909353102,'F','Parker',26,9999999),('General','John',6324212,688565423,'M','Bartley',19,9999999),('General','Logan',7552393,321365432,'M','Williams',28,9999999),('Manager\n','Jill',7654321,111335555,'F','Jones',35,0),('General','Jo',7823453,178346213,'F','Flemings',26,7654321),('Unpaid Intern','Patricia',9092931,122314231,'F','Hills',22,9999999),('General','Johnathan',9155648,150211028,'M','Parker',23,7654321),('Manager','Bryan',9999999,403215342,'M','Martin',41,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
