-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: library
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
-- Table structure for table `borrow_order`
--

DROP TABLE IF EXISTS `borrow_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  `limit_day` int DEFAULT '7',
  `overdue_fee_each` double DEFAULT '1000',
  `status` tinyint DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `borrow_book_id_idx` (`book_id`),
  KEY `borrow_student_id_idx` (`student_id`),
  CONSTRAINT `borrow_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `borrow_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_order`
--

LOCK TABLES `borrow_order` WRITE;
/*!40000 ALTER TABLE `borrow_order` DISABLE KEYS */;
INSERT INTO `borrow_order` VALUES (1,'2020-07-17 00:00:00','2020-07-23 00:00:00',7,1000,1,1,1),(2,'2020-07-12 00:00:00',NULL,7,1000,NULL,2,2),(3,'2020-07-19 00:00:00','2020-07-29 00:00:00',7,9000,NULL,3,3);
/*!40000 ALTER TABLE `borrow_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-16 10:51:46
