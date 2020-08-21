-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: furama_v1
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
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_day` datetime DEFAULT NULL,
  `end_day` datetime DEFAULT NULL,
  `down_payment` double DEFAULT NULL,
  `total_payment` double DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_employee1_idx` (`employee_id`),
  KEY `fk_contract_customer1_idx` (`customer_id`),
  KEY `fk_contract_service1_idx` (`service_id`),
  CONSTRAINT `fk_contract_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_contract_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_contract_service1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'2019-12-05 00:00:00','2020-06-06 00:00:00',100,500,202,4,6),(2,'2019-12-05 00:00:00','2020-06-06 00:00:00',100,500,203,2,7),(3,'2019-10-05 00:00:00','2020-06-06 00:00:00',100,500,205,3,6),(4,'2020-05-05 00:00:00','2020-06-06 00:00:00',100,500,202,1,4),(5,'2019-05-05 00:00:00','2020-06-06 00:00:00',100,500,202,2,3),(6,'2019-12-05 00:00:00','2020-06-06 00:00:00',100,500,202,2,3),(7,'2020-05-05 00:00:00','2019-11-06 00:00:00',100,500,202,1,2),(8,'2019-10-05 00:00:00','2019-12-06 00:00:00',100,500,202,2,4),(9,'2019-01-05 00:00:00','2019-09-06 00:00:00',100,500,202,3,1),(10,'2017-05-05 00:00:00','2020-06-06 00:00:00',100,500,202,4,2),(11,'2018-05-05 00:00:00','2020-06-06 00:00:00',100,500,202,4,3),(12,'2019-11-05 00:00:00','2019-12-06 00:00:00',100,500,202,3,4),(13,'2019-10-06 00:00:00','2019-10-06 00:00:00',100,500,202,2,2),(14,'2020-05-05 00:00:00','2020-06-06 00:00:00',100,500,202,1,3),(27,'2018-07-08 00:00:00','2019-02-02 00:00:00',200,300,205,6,4),(28,'2019-01-08 00:00:00','2019-02-03 00:00:00',200,300,208,3,1),(29,'2019-02-08 00:00:00','2019-02-20 00:00:00',200,300,206,2,3),(30,'2018-02-02 00:00:00','2019-02-02 00:00:00',300,333,203,4,4),(31,'2019-02-02 00:00:00','2019-02-20 00:00:00',300,333,203,3,4);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quanlity` int DEFAULT NULL,
  `contract_id` int DEFAULT NULL,
  `service_accompany_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_detail_contract1_idx` (`contract_id`),
  KEY `fk_contract_detail_service_accompany1_idx` (`service_accompany_id`),
  CONSTRAINT `fk_contract_detail_contract1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`),
  CONSTRAINT `fk_contract_detail_service_accompany1` FOREIGN KEY (`service_accompany_id`) REFERENCES `service_accompany` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
INSERT INTO `contract_detail` VALUES (1,2,4,1),(2,3,4,2),(3,3,1,3),(4,1,2,1),(5,2,3,3),(6,2,8,1),(7,1,12,2),(8,1,13,3),(9,1,6,1),(10,2,6,2),(11,3,6,3),(12,4,2,3),(13,5,31,4);
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `identify_number` char(10) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `customer_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_customer_type1_idx` (`customer_type_id`),
  CONSTRAINT `fk_customer_customer_type1` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Nguyen Ngoc Anh Quoc','2020-05-09 00:00:00','1234567890','1234567890','quocnna@gmail.com','Da Nang',2),(2,'Dung Nguyen','2020-05-09 00:00:00','1234567890','1234567890','quocnna@gmail.com','address',1),(3,'Dat Tran','2020-05-09 00:00:00','1234567890','1234567890','quocnna@gmail.com','address',1),(4,'Phong Le','2020-05-09 00:00:00','1234567890','1234567890','quocnna@gmail.com','Vinh',2),(5,'Tuan Nguyen','2020-05-09 00:00:00','1234567890','1234567890','quocnna@gmail.com','address',3),(6,'Phuong Le','2020-05-09 00:00:00','1234567890','1234567890','quocnna@gmail.com','address',2),(7,'Hoa Tran','2020-05-09 00:00:00','1234567890','1234567890','quocnna@gmail.com','address',3),(8,'Thao Le','1989-08-09 00:00:00','3333333333','3333333333','aaaaa@gmail.com','abc',2);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'vip'),(2,'diamond'),(3,'silver'),(4,'normal');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` VALUES (1,'dai hoc'),(2,'cap 3'),(3,'cap 2'),(4,'thac si'),(5,'tien sy'),(6,'cap 1');
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'sale'),(2,'hanh chinh'),(3,'phuc vu'),(4,'quan ly');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `identify_number` char(10) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  `degree_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_position_idx` (`position_id`),
  KEY `fk_employee_department1_idx` (`department_id`),
  KEY `fk_employee_degree1_idx` (`degree_id`),
  CONSTRAINT `fk_employee_degree1` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`id`),
  CONSTRAINT `fk_employee_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_employee_position` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=351 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (201,'Thinh Ly Quoc','2020-05-05 00:00:00','2015181835',50,'0708230984','email','address',1,2,3),(202,'Le Phong Minh Van','1984-05-05 00:00:00','2015181835',51,'0708230984','email','address',1,2,3),(203,'Tuan Van My Phong Thao','1985-05-05 00:00:00','2015181835',52,'0708230984','email','address',1,2,3),(204,'Xuan Binh Dung Tuan','1986-05-05 00:00:00','2015181835',53,'0708230984','email','address',1,2,3),(205,'Thao Hoat Linh','1987-05-05 00:00:00','2015181835',54,'0708230984','email','address',1,2,3),(206,'Hoat Son Phong','2000-05-05 00:00:00','2015181835',55,'0708230984','email','address',1,2,3),(207,'Truong Phuong Toan Tran Vu','1988-05-05 00:00:00','2015181835',56,'0708230984','email','address',1,2,3),(208,'Tuong Dung Thuong','1976-05-05 00:00:00','2015181835',57,'0708230984','email','address',1,2,3),(209,'Ho Tien Dang Tien','2020-05-05 00:00:00','2015181835',58,'0708230984','email','address',1,2,3),(210,'Vu Nguyen Chi','2020-05-05 00:00:00','2015181835',59,'0708230984','email','address',1,2,3),(211,'Thinh Dang Thuong Ho Minh','2020-05-05 00:00:00','2015181835',60,'0708230984','email','address',1,2,3),(212,'Tien Loan My Ta','2020-05-05 00:00:00','2015181835',61,'0708230984','email','address',1,2,3),(213,'Hai Toan Son Ho Tuy','2020-05-05 00:00:00','2015181835',62,'0708230984','email','address',1,2,3),(214,'Linh Loan Tran','2020-05-05 00:00:00','2015181835',63,'0708230984','email','address',1,2,3),(215,'Chuong Thanh Tran','2020-05-05 00:00:00','2015181835',64,'0708230984','email','address',1,2,3),(216,'Dang Le Loan','2020-05-05 00:00:00','2015181835',65,'0708230984','email','address',1,2,3),(217,'Tuy Hao Thanh Ly','2020-05-05 00:00:00','2015181835',66,'0708230984','email','address',1,2,3),(218,'Dung Le Hai Minh','2020-05-05 00:00:00','2015181835',67,'0708230984','email','address',1,2,3),(219,'Tuy Thanh Loan Vu','2020-05-05 00:00:00','2015181835',68,'0708230984','email','address',1,2,3),(220,'Tuan Duy Duy','2020-05-05 00:00:00','2015181835',69,'0708230984','email','address',1,2,3),(221,'Thinh Nguyen Truong','2020-05-05 00:00:00','2015181835',70,'0708230984','email','address',1,2,3),(222,'Tuy Anh Thao Dung','2020-05-05 00:00:00','2015181835',71,'0708230984','email','address',1,2,3),(223,'Van Linh Tung','2020-05-05 00:00:00','2015181835',72,'0708230984','email','address',1,2,3),(224,'Chuong Chi Hai','2020-05-05 00:00:00','2015181835',73,'0708230984','email','address',1,2,3),(225,'Doan Hoat Ngan Ton','2020-05-05 00:00:00','2015181835',74,'0708230984','email','address',1,2,3),(226,'Quang Tien Ngan','2020-05-05 00:00:00','2015181835',75,'0708230984','email','address',1,2,3),(227,'Ho Thuong Hoat','2020-05-05 00:00:00','2015181835',76,'0708230984','email','address',1,2,3),(228,'Huong Nguyen Hoat','2020-05-05 00:00:00','2015181835',77,'0708230984','email','address',1,2,3),(229,'Ta Tuan Thuong Thuong Le','2020-05-05 00:00:00','2015181835',78,'0708230984','email','address',1,2,3),(230,'Dang Minh Chuong Thao Cuong','2020-05-05 00:00:00','2015181835',79,'0708230984','email','address',1,2,3),(231,'My Tien Thinh','2020-05-05 00:00:00','2015181835',80,'0708230984','email','address',1,2,3),(232,'Tuy Dang Doan Van Lan','2020-05-05 00:00:00','2015181835',81,'0708230984','email','address',1,2,3),(233,'Nhung Tung Duy Nhung','2020-05-05 00:00:00','2015181835',82,'0708230984','email','address',1,2,3),(234,'Truong Phuong Hoa My','2020-05-05 00:00:00','2015181835',83,'0708230984','email','address',1,2,3),(235,'Xuan Dang Loan','2020-05-05 00:00:00','2015181835',84,'0708230984','email','address',1,2,3),(236,'Nhung Thinh Ly Dung','2020-05-05 00:00:00','2015181835',85,'0708230984','email','address',1,2,3),(237,'Phuong Tien Nhung','2020-05-05 00:00:00','2015181835',86,'0708230984','email','address',1,2,3),(238,'Thanh Ngan Tuy','2020-05-05 00:00:00','2015181835',87,'0708230984','email','address',1,2,3),(239,'Nhung Phong Vu','2020-05-05 00:00:00','2015181835',88,'0708230984','email','address',1,2,3),(240,'Son Thinh Theo Tuan','2020-05-05 00:00:00','2015181835',89,'0708230984','email','address',1,2,3),(241,'Tien Thinh Son Ha Son','2020-05-05 00:00:00','2015181835',90,'0708230984','email','address',1,2,3),(242,'Dung My Phong Quang','2020-05-05 00:00:00','2015181835',91,'0708230984','email','address',1,2,3),(243,'Quoc Hoa Anh','2020-05-05 00:00:00','2015181835',92,'0708230984','email','address',1,2,3),(244,'Hai Lan Anh Nguyen Chuong','2020-05-05 00:00:00','2015181835',93,'0708230984','email','address',1,2,3),(245,'Ha Duc Tin Dung Tri','2020-05-05 00:00:00','2015181835',94,'0708230984','email','address',1,2,3),(246,'Hoat Hao Nguyen','2020-05-05 00:00:00','2015181835',95,'0708230984','email','address',1,2,3),(247,'Ho Trung Phong Thinh','2020-05-05 00:00:00','2015181835',96,'0708230984','email','address',1,2,3),(248,'Linh Doan Ly Phong','2020-05-05 00:00:00','2015181835',97,'0708230984','email','address',1,2,3),(249,'Dang Cuong Nguyen','2020-05-05 00:00:00','2015181835',98,'0708230984','email','address',1,2,3),(250,'Dung Phong Truong Dung Tien','2020-05-05 00:00:00','2015181835',99,'0708230984','email','address',1,2,3),(251,'Thao Quoc Quoc Tien','2020-05-05 00:00:00','2015181835',50,'0708230984','email','address',1,2,3),(252,'Vu Hoat My Long Ha','2020-05-05 00:00:00','2015181835',51,'0708230984','email','address',1,2,3),(253,'Hung Theo Thao Vu','2020-05-05 00:00:00','2015181835',52,'0708230984','email','address',1,2,3),(254,'Quoc Hoat Tran Tinh Lan','2020-05-05 00:00:00','2015181835',53,'0708230984','email','address',1,2,3),(255,'Ngan Chuong Vu Tuan Toan','2020-05-05 00:00:00','2015181835',54,'0708230984','email','address',1,2,3),(256,'Dang Lam Dung Vu Chuong','2020-05-05 00:00:00','2015181835',55,'0708230984','email','address',1,2,3),(257,'Hoa Dung Thinh','2020-05-05 00:00:00','2015181835',56,'0708230984','email','address',1,2,3),(258,'Ly Tung Van','2020-05-05 00:00:00','2015181835',57,'0708230984','email','address',1,2,3),(259,'Lan Tuan Thao Doan','2020-05-05 00:00:00','2015181835',58,'0708230984','email','address',1,2,3),(260,'Lam Tung Thao','2020-05-05 00:00:00','2015181835',59,'0708230984','email','address',1,2,3),(261,'Doan Duy Lan Dang Nguyen','2020-05-05 00:00:00','2015181835',60,'0708230984','email','address',1,2,3),(262,'Xuan Hoa Nhung','2020-05-05 00:00:00','2015181835',61,'0708230984','email','address',1,2,3),(263,'Vu Tran Nguyen Minh','2020-05-05 00:00:00','2015181835',62,'0708230984','email','address',1,2,3),(264,'Thanh Dang Le Duy Thao','2020-05-05 00:00:00','2015181835',63,'0708230984','email','address',1,2,3),(265,'Ho Phong Theo Ngan','2020-05-05 00:00:00','2015181835',64,'0708230984','email','address',1,2,3),(266,'Dang Truong Dang Anh','2020-05-05 00:00:00','2015181835',65,'0708230984','email','address',1,2,3),(267,'Linh Chuong Trung','2020-05-05 00:00:00','2015181835',66,'0708230984','email','address',1,2,3),(268,'Anh Hoat Nhung Truong','2020-05-05 00:00:00','2015181835',67,'0708230984','email','address',1,2,3),(269,'Vu Minh Van Chuong Doan','2020-05-05 00:00:00','2015181835',68,'0708230984','email','address',1,2,3),(270,'Dung Quang Quang Dung Toan','2020-05-05 00:00:00','2015181835',69,'0708230984','email','address',1,2,3),(271,'Anh Linh Son Anh Tung','2020-05-05 00:00:00','2015181835',70,'0708230984','email','address',1,2,3),(272,'Tuong Quoc Thao','2020-05-05 00:00:00','2015181835',71,'0708230984','email','address',1,2,3),(273,'Tri Quoc Ngan Phuong','2020-05-05 00:00:00','2015181835',72,'0708230984','email','address',1,2,3),(274,'Ha Tien Thanh Phong','2020-05-05 00:00:00','2015181835',73,'0708230984','email','address',1,2,3),(275,'Tuan Thanh Toan','2020-05-05 00:00:00','2015181835',74,'0708230984','email','address',1,2,3),(276,'Phong Xuan Le Tran Phong','2020-05-05 00:00:00','2015181835',75,'0708230984','email','address',1,2,3),(277,'Duy Nguyen Lam Dung','2020-05-05 00:00:00','2015181835',76,'0708230984','email','address',1,2,3),(278,'Dung Van Ly Dung Hung','2020-05-05 00:00:00','2015181835',77,'0708230984','email','address',1,2,3),(279,'My Le Thinh','2020-05-05 00:00:00','2015181835',78,'0708230984','email','address',1,2,3),(280,'My Tien Ly Duc','2020-05-05 00:00:00','2015181835',79,'0708230984','email','address',1,2,3),(281,'Tuan Phong Tien','2020-05-05 00:00:00','2015181835',80,'0708230984','email','address',1,2,3),(282,'Thanh Tran Thao Quang','2020-05-05 00:00:00','2015181835',81,'0708230984','email','address',1,2,3),(283,'Thinh Vu Anh Ton','2020-05-05 00:00:00','2015181835',82,'0708230984','email','address',1,2,3),(284,'Tin Linh Cuong','2020-05-05 00:00:00','2015181835',83,'0708230984','email','address',1,2,3),(285,'Duy Lan Quoc','2020-05-05 00:00:00','2015181835',84,'0708230984','email','address',1,2,3),(286,'Quoc Tien Dang Thao','2020-05-05 00:00:00','2015181835',85,'0708230984','email','address',1,2,3),(287,'Tuan Doan Vu Ly Anh','2020-05-05 00:00:00','2015181835',86,'0708230984','email','address',1,2,3),(288,'Lan Ha Thanh Ly Tung','2020-05-05 00:00:00','2015181835',87,'0708230984','email','address',1,2,3),(289,'Le Nhung Doan Nhung Ly','2020-05-05 00:00:00','2015181835',88,'0708230984','email','address',1,2,3),(290,'Linh Hoat Tung','2020-05-05 00:00:00','2015181835',89,'0708230984','email','address',1,2,3),(291,'Ly Long Dung Tuong Trung','2020-05-05 00:00:00','2015181835',90,'0708230984','email','address',1,2,3),(292,'Quang Van Tuan Duy Anh','2020-05-05 00:00:00','2015181835',91,'0708230984','email','address',1,2,3),(293,'Son Truong Ton','2020-05-05 00:00:00','2015181835',92,'0708230984','email','address',1,2,3),(294,'Minh Van Dang Phong Long','2020-05-05 00:00:00','2015181835',93,'0708230984','email','address',1,2,3),(295,'Hoa Le Tung Chuong Ho','2020-05-05 00:00:00','2015181835',94,'0708230984','email','address',1,2,3),(296,'Quoc Nguyen Minh','2020-05-05 00:00:00','2015181835',95,'0708230984','email','address',1,2,3),(297,'Long Nhung Thinh Tuy Nhung','2020-05-05 00:00:00','2015181835',96,'0708230984','email','address',1,2,3),(298,'Son Linh Lam','2020-05-05 00:00:00','2015181835',97,'0708230984','email','address',1,2,3),(299,'Tan Dung Ta Xuan','2020-05-05 00:00:00','2015181835',98,'0708230984','email','address',1,2,3),(300,'Tin Loan Dung Anh','2020-05-05 00:00:00','2015181835',99,'0708230984','email','address',1,2,3),(301,'Ho Lan Phuong','2020-05-05 00:00:00','2015181835',50,'0708230984','email','address',1,2,3),(302,'Nhung Quoc Lan','2020-05-05 00:00:00','2015181835',51,'0708230984','email','address',1,2,3),(303,'Vu Son Tung','2020-05-05 00:00:00','2015181835',52,'0708230984','email','address',1,2,3),(304,'Van Dang Van Chuong Ly','2020-05-05 00:00:00','2015181835',53,'0708230984','email','address',1,2,3),(305,'Lan Ngan Binh My Vu','2020-05-05 00:00:00','2015181835',54,'0708230984','email','address',1,2,3),(306,'Tien Minh Quang Ha Anh','2020-05-05 00:00:00','2015181835',55,'0708230984','email','address',1,2,3),(307,'Loan Ta Thinh Loan','2020-05-05 00:00:00','2015181835',56,'0708230984','email','address',1,2,3),(308,'Tien Dung Thinh Van','2020-05-05 00:00:00','2015181835',57,'0708230984','email','address',1,2,3),(309,'Lan My Le Son Duy','2020-05-05 00:00:00','2015181835',58,'0708230984','email','address',1,2,3),(310,'My Tuong Hoa Hoa','2020-05-05 00:00:00','2015181835',59,'0708230984','email','address',1,2,3),(311,'Thinh Ly Thuong Lan Cuong','2020-05-05 00:00:00','2015181835',60,'0708230984','email','address',1,2,3),(312,'Toan Dang Lan Chuong','2020-05-05 00:00:00','2015181835',61,'0708230984','email','address',1,2,3),(313,'Thuong Dang Duy Hoat','2020-05-05 00:00:00','2015181835',62,'0708230984','email','address',1,2,3),(314,'Tung Lan Truong','2020-05-05 00:00:00','2015181835',63,'0708230984','email','address',1,2,3),(315,'Phuong Thanh Toan','2020-05-05 00:00:00','2015181835',64,'0708230984','email','address',1,2,3),(316,'Phong My Tri Quang Anh','2020-05-05 00:00:00','2015181835',65,'0708230984','email','address',1,2,3),(317,'Anh Lam Tran Toan','2020-05-05 00:00:00','2015181835',66,'0708230984','email','address',1,2,3),(318,'Xuan Thao Le Toan Phong','2020-05-05 00:00:00','2015181835',67,'0708230984','email','address',1,2,3),(319,'Duy Truong Tran Ha','2020-05-05 00:00:00','2015181835',68,'0708230984','email','address',1,2,3),(320,'Tinh Son Hung','2020-05-05 00:00:00','2015181835',69,'0708230984','email','address',1,2,3),(321,'Ly Anh Hoa Phuong Tung','2020-05-05 00:00:00','2015181835',70,'0708230984','email','address',1,2,3),(322,'Vu Ngan Doan Binh','2020-05-05 00:00:00','2015181835',71,'0708230984','email','address',1,2,3),(323,'Loan Nguyen Loan Le','2020-05-05 00:00:00','2015181835',72,'0708230984','email','address',1,2,3),(324,'Duy Doan Chuong','2020-05-05 00:00:00','2015181835',73,'0708230984','email','address',1,2,3),(325,'Vu Hoa Tuan Thuong Tung','2020-05-05 00:00:00','2015181835',74,'0708230984','email','address',1,2,3),(326,'Cuong Nhung Van','2020-05-05 00:00:00','2015181835',75,'0708230984','email','address',1,2,3),(327,'Anh Loan Thuong Hai Lam','2020-05-05 00:00:00','2015181835',76,'0708230984','email','address',1,2,3),(328,'Anh Thanh Long Phuong Son','2020-05-05 00:00:00','2015181835',77,'0708230984','email','address',1,2,3),(329,'Chuong Tuong Tuong Theo','2020-05-05 00:00:00','2015181835',78,'0708230984','email','address',1,2,3),(330,'Tri Thinh Tuan Quang Vu','2020-05-05 00:00:00','2015181835',79,'0708230984','email','address',1,2,3),(331,'Ngan Loan Thao Xuan','2020-05-05 00:00:00','2015181835',80,'0708230984','email','address',1,2,3),(332,'Chuong Trung Tran','2020-05-05 00:00:00','2015181835',81,'0708230984','email','address',1,2,3),(333,'Thanh Thao Long','2020-05-05 00:00:00','2015181835',82,'0708230984','email','address',1,2,3),(334,'Le Theo Hai','2020-05-05 00:00:00','2015181835',83,'0708230984','email','address',1,2,3),(335,'Phuong Van Cuong Thinh Truong','2020-05-05 00:00:00','2015181835',84,'0708230984','email','address',1,2,3),(336,'Phuong Minh Tuan Hoat','2020-05-05 00:00:00','2015181835',85,'0708230984','email','address',1,2,3),(337,'Tran Lan Thanh','2020-05-05 00:00:00','2015181835',86,'0708230984','email','address',1,2,3),(338,'Hoa Hoat Thao Le Hoa','2020-05-05 00:00:00','2015181835',87,'0708230984','email','address',1,2,3),(339,'Tuan Truong Van','2020-05-05 00:00:00','2015181835',88,'0708230984','email','address',1,2,3),(340,'Duy Son Anh Hai','2020-05-05 00:00:00','2015181835',89,'0708230984','email','address',1,2,3),(341,'Ha Minh Tung','2020-05-05 00:00:00','2015181835',90,'0708230984','email','address',1,2,3),(342,'Hung Nguyen Loan Son','2020-05-05 00:00:00','2015181835',91,'0708230984','email','address',1,2,3),(343,'Ha Ha Tung','2020-05-05 00:00:00','2015181835',92,'0708230984','email','address',1,2,3),(344,'Thanh Tuan Tung Tuy Quoc','2020-05-05 00:00:00','2015181835',93,'0708230984','email','address',1,2,3),(345,'Thao Ngan Cuong Loan Duy','2020-05-05 00:00:00','2015181835',94,'0708230984','email','address',1,2,3),(346,'Nguyen Thinh Nguyen','2020-05-05 00:00:00','2015181835',95,'0708230984','email','address',1,2,3),(347,'Loan My Vu Doan','2020-05-05 00:00:00','2015181835',96,'0708230984','email','address',1,2,3),(348,'Ho Linh My','2020-05-05 00:00:00','2015181835',97,'0708230984','email','address',1,2,3),(349,'Duy Truong Thanh Ha','2020-05-05 00:00:00','2015181835',98,'0708230984','email','address',1,2,3),(350,'Linh Tuy Thanh','2020-05-05 00:00:00','2015181835',99,'0708230984','email','address',1,2,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `period_rent`
--

DROP TABLE IF EXISTS `period_rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `period_rent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `period_rent`
--

LOCK TABLES `period_rent` WRITE;
/*!40000 ALTER TABLE `period_rent` DISABLE KEYS */;
INSERT INTO `period_rent` VALUES (1,'day'),(2,'month'),(3,'year');
/*!40000 ALTER TABLE `period_rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'le tan'),(2,'phuc vu'),(3,'chuyen vien'),(4,'giam sat'),(5,'quan ly'),(6,'giam doc');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `area` double DEFAULT NULL,
  `number_of_floor` int DEFAULT NULL,
  `max_people` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `service_type_id` int DEFAULT NULL,
  `period_rent_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_service_service_type1_idx` (`service_type_id`),
  KEY `fk_service_period_rent1_idx` (`period_rent_id`),
  CONSTRAINT `fk_service_period_rent1` FOREIGN KEY (`period_rent_id`) REFERENCES `period_rent` (`id`),
  CONSTRAINT `fk_service_service_type1` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'villa 1',20,3,10,100,1,1,2),(2,'villa 2',20,3,10,100,1,2,2),(3,'villa 3',20,3,10,100,1,2,2),(4,'villa 4',20,3,10,100,1,3,2),(5,'villa 5',20,3,10,100,1,2,2),(6,'house',10,11,11,22,1,2,1),(7,'room',12,12,12,12,1,1,1);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_accompany`
--

DROP TABLE IF EXISTS `service_accompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_accompany` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_accompany`
--

LOCK TABLES `service_accompany` WRITE;
/*!40000 ALTER TABLE `service_accompany` DISABLE KEYS */;
INSERT INTO `service_accompany` VALUES (1,'car',200,'chiec',1),(2,'bar',300,'quay',1),(3,'massage',50,'ve',1),(4,'buffe',80,'ve',1);
/*!40000 ALTER TABLE `service_accompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'villa'),(2,'house'),(3,'room');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-30 22:08:19
