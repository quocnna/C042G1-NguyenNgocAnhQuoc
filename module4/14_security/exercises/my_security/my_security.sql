-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: my_security
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
-- Table structure for table `t_permission`
--

DROP TABLE IF EXISTS `t_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `permission_key` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission`
--

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` VALUES (1,NULL,NULL,0,NULL,NULL,'USER_CREATE','tạo user'),(2,NULL,NULL,0,NULL,NULL,'USER_READ','xem user'),(3,NULL,NULL,0,NULL,NULL,'USER_UPDATE','sửa user'),(4,NULL,NULL,0,NULL,NULL,'USER_DELETE','xóa user');
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `role_key` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,NULL,NULL,0,NULL,NULL,'ADMIN','Supper User'),(2,NULL,NULL,0,NULL,NULL,'CUSTOMER','Khách');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_permission`
--

DROP TABLE IF EXISTS `t_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_role_permission` (
  `role_id` bigint NOT NULL,
  `permission_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  UNIQUE KEY `UK_nkhhl7rlqqsu5goufwn1udr0e` (`permission_id`),
  CONSTRAINT `FK90j038mnbnthgkc17mqnoilu9` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKjobmrl6dorhlfite4u34hciik` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_permission`
--

LOCK TABLES `t_role_permission` WRITE;
/*!40000 ALTER TABLE `t_role_permission` DISABLE KEYS */;
INSERT INTO `t_role_permission` VALUES (1,1),(1,2),(1,3),(1,4);
/*!40000 ALTER TABLE `t_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_token`
--

DROP TABLE IF EXISTS `t_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `token` varchar(1000) DEFAULT NULL,
  `token_exp_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_token`
--

LOCK TABLES `t_token` WRITE;
/*!40000 ALTER TABLE `t_token` DISABLE KEYS */;
INSERT INTO `t_token` VALUES (1,'2020-09-15 13:38:10.166000',1,0,'2020-09-15 13:38:10.166000',NULL,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDEwMTU4ODgsInVzZXIiOnsidXNlcklkIjoxLCJ1c2VybmFtZSI6Imh1bmdoaCIsInBhc3N3b3JkIjoiJDJhJDEwJFZPYkh4bXh5Y2YwLlFKTlhsd3FFYy5tRlouaVlrUzVWNHpBSjB4ZElNU29FWW9XMThPN2N1IiwiYXV0aG9yaXRpZXMiOlsiVVNFUl9ERUxFVEUiLCJVU0VSX0NSRUFURSIsIlVTRVJfVVBEQVRFIiwiQURNSU4iLCJVU0VSX1JFQUQiXX19.uQUtKX2YoW4a5d4r-duP9BgLtu03mtNmh1mgpNVi1KI','2020-09-25 13:38:08.896000'),(2,'2020-09-15 13:39:55.614000',2,0,'2020-09-15 13:39:55.614000',NULL,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDEwMTU5OTUsInVzZXIiOnsidXNlcklkIjoyLCJ1c2VybmFtZSI6InF1b2MiLCJwYXNzd29yZCI6IiQyYSQxMCRJQzYyYUc4eXpkc282T25qVWVjXC8xLjRFYURsZ2h4aHl2ai5VV3VQNHVLcEpieGc5OXgxLmUiLCJhdXRob3JpdGllcyI6W119fQ.9JkiYw9rCSRZsU79dwoDdX6qlJD3oohb7x8B2JLyLTQ','2020-09-25 13:39:55.592000'),(3,'2020-09-15 16:46:50.615000',1,0,'2020-09-15 16:46:50.615000',NULL,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDEwMjcyMTAsInVzZXIiOnsidXNlcklkIjoxLCJ1c2VybmFtZSI6Imh1bmdoaCIsInBhc3N3b3JkIjoiJDJhJDEwJFZPYkh4bXh5Y2YwLlFKTlhsd3FFYy5tRlouaVlrUzVWNHpBSjB4ZElNU29FWW9XMThPN2N1IiwiYXV0aG9yaXRpZXMiOlsiVVNFUl9ERUxFVEUiLCJVU0VSX0NSRUFURSIsIlVTRVJfVVBEQVRFIiwiQURNSU4iLCJVU0VSX1JFQUQiXX19.68B3eOhHElzJME9LcJ1ug-TBmbQGQLevVRmiSMgI-uU','2020-09-25 16:46:50.593000');
/*!40000 ALTER TABLE `t_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,NULL,NULL,0,NULL,NULL,'$2a$10$VObHxmxycf0.QJNXlwqEc.mFZ.iYkS5V4zAJ0xdIMSoEYoW18O7cu','hunghh'),(2,'2020-09-15 11:31:17.997000',NULL,0,'2020-09-15 11:31:17.997000',NULL,'$2a$10$IC62aG8yzdso6OnjUec/1.4EaDlghxhyvj.UWuP4uKpJbxg99x1.e','quoc');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  UNIQUE KEY `UK_4uvv76e86ms8ru0kk9s01d3s2` (`role_id`),
  CONSTRAINT `FKa9c8iiy6ut0gnx491fqx4pxam` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-19 21:45:38
