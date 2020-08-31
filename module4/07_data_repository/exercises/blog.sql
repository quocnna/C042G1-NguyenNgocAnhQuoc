-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: blog
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
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text,
  `created_on` date DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `likes` int NOT NULL,
  `title` char(150) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqyvjif1i2geaeuvkh3n1jrnn4` (`category_id`),
  CONSTRAINT `FKqyvjif1i2geaeuvkh3n1jrnn4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (2,'Lời của Koeman đẩy Messi tới quyết định rời Barca. Hôm 25/8, anh gửi fax cho Chủ tịch Josep Maria Bartomeu và bảy Giám đốc Barca, đề nghị ra đi. Trong đó, Messi muốn đơn phương chấm dứt ngay hợp đồng, vốn có thời hạn tới tháng 6/2021.\n\nHôm 20/8, Koeman lần đầu gặp Messi với tư cách tân HLV Barca. HLV người Hà Lan khẳng định Messi là trụ cột trong kế hoạch của ông. Còn Messi nói rằng anh cảm thấy muốn ra đi hơn ở lại.\n\nTheo báo Anh Sportsmail, Messi lĩnh 50 triệu euro (khoảng 60 triệu USD), sau thuế, mỗi năm ở Barca. Tính trước thuế, Barca tốn 100 triệu euro mỗi năm cho Messi. Covid-19 khiến đội bóng này thất thu 300 triệu Euro. Do đó, tỷ lệ quỹ lương trên doanh thu của Barca tăng từ 60% lên 80%. Tỷ lệ này sẽ giảm đáng kể nếu Messi ra đi.\n\nTheo đài Catalonia CatRadio, Messi đã liên hệ HLV Pep Guardiola để tìm cách chuyển tới Man City. Esporte Interativo còn khẳng định Messi đã chọn Man City làm bến đỗ mới, còn tờ The Athletic của Anh cho rằng Man City đã sẵn sàng chiêu mộ Messi theo dạng chuyển nhượng tự do.','2020-05-05','img20.jpg',11,'Lời nói của Koeman khiến Messi phật lòng',1),(4,'Ngoài Đập vỡ tim anh cho rồi, trong năm cc','2020-08-29','img15.jpg',2,'Trọng Hiếu muốn truyền cc',3),(5,'Ngoài Đập vỡ tim anh cho rồi, trong năm nay, anh còn cho ra mắt 6 sản phẩm âm nhạc, kèm theo các bản acoustic và remix để phục vụ nhu cầu thưởng thức nhạc của công chúng. Ca sĩ mong mọi người sẽ có thêm năng lượng tích cực và cảm hứng.\n\nTrước câu hỏi \"chất lượng các MV có đảm bảo khi ra mắt dồn dập\", ca sĩ nói việc sáng tạo không thể đánh giá bằng thời gian. Thời gian ngắn cảm xúc thường thăng hoa, tăng độ tập trung và hiệu quả làm việc hơn là kéo dài. Anh lý giải ý tưởng có thể đến bất cứ khi nào miễn là nghệ sĩ tập trung.\n\n\"Ra MV mỗi tháng không có nghĩa tôi chỉ dành ít ngày chuẩn bị. Ngược lại, hầu hết ca khúc tôi đã sáng tác, dành tâm huyết từ trước đó cả năm. Tất cả là những tác phẩm tôi tâm đắc. Đặc biệt, âm nhạc thể hiện con người và cảm xúc tôi, vì thếtôi tin rằng khán giả sẽ không chán hay ngợp khi cảm nhận. Ngược lại, họ sẽ đồng hành với tôi ở mọi khía cạnh\", anh nói.\n\nTheo Trọng Hiếu, khi hạn chế ra ngoài vì Covid-19, anh có thêm thời gian tập hát, nhảy, tăng kỹ năng sáng tác và hoàn thiện bản thân. Một ngày anh dậy từ 6h sáng, đánh đàn, tập thể dục, đi bơi, ăn sáng, sau đó sáng tác nhạc trong ba tiếng. Buổi chiều anh tập nhảy hai tiếng, tối đến sẽ tập hát và cập nhật thông tin, giao lưu khán giả. Cuối tuần, anh thêm chơi các môn thể thao vận động nhiều như cầu lông, tennis.\n\nĐể duy trì năng lượng và sáng tạo mỗi ngày, anh luôn tìm điều mới mẻ, thực hiện những chuyện trước đây không nghĩ bản thân sẽ làm được. Anh thích du lịch, trải nghiệm nhiều nền văn hóa, làm quen với người mới... Thời gian này không thể du hý, ca sĩ dành mọi quan tâm cho người thân, bạn bè và fan. Trò chuyện sâu hơn khiến anh nhìn ra nhiều điều thú vị mà trước đây không thấy, từ đó có thêm chất liệu sáng tác.\n\n\"Quan sát cuộc sống và chuyển động xung quanh giúp khơi nguồn sáng tạo. Bạn có thể cảm nhận trực tiếp bằng các giác quan, qua mạng xã hội, diễn đàn hay báo chí. Với tôi, sự chuyển động này là không ngừng và không bao giờ chán\", anh nói.','2020-06-06','img15.jpg',2,'Trọng Hiếu muốn truyền năng lượng, lạc quan qua âm nhạc',3),(6,'Ngoài Đập vỡ tim anh cho rồi, trong năm nay, anh còn cho ra mắt 6 sản phẩm âm nhạc, kèm theo các bản acoustic và remix để phục vụ nhu cầu thưởng thức nhạc của công chúng. Ca sĩ mong mọi người sẽ có thêm năng lượng tích cực và cảm hứng.\n\nTrước câu hỏi \"chất lượng các MV có đảm bảo khi ra mắt dồn dập\", ca sĩ nói việc sáng tạo không thể đánh giá bằng thời gian. Thời gian ngắn cảm xúc thường thăng hoa, tăng độ tập trung và hiệu quả làm việc hơn là kéo dài. Anh lý giải ý tưởng có thể đến bất cứ khi nào miễn là nghệ sĩ tập trung.\n\n\"Ra MV mỗi tháng không có nghĩa tôi chỉ dành ít ngày chuẩn bị. Ngược lại, hầu hết ca khúc tôi đã sáng tác, dành tâm huyết từ trước đó cả năm. Tất cả là những tác phẩm tôi tâm đắc. Đặc biệt, âm nhạc thể hiện con người và cảm xúc tôi, vì thếtôi tin rằng khán giả sẽ không chán hay ngợp khi cảm nhận. Ngược lại, họ sẽ đồng hành với tôi ở mọi khía cạnh\", anh nói.\n\nTheo Trọng Hiếu, khi hạn chế ra ngoài vì Covid-19, anh có thêm thời gian tập hát, nhảy, tăng kỹ năng sáng tác và hoàn thiện bản thân. Một ngày anh dậy từ 6h sáng, đánh đàn, tập thể dục, đi bơi, ăn sáng, sau đó sáng tác nhạc trong ba tiếng. Buổi chiều anh tập nhảy hai tiếng, tối đến sẽ tập hát và cập nhật thông tin, giao lưu khán giả. Cuối tuần, anh thêm chơi các môn thể thao vận động nhiều như cầu lông, tennis.\n\nĐể duy trì năng lượng và sáng tạo mỗi ngày, anh luôn tìm điều mới mẻ, thực hiện những chuyện trước đây không nghĩ bản thân sẽ làm được. Anh thích du lịch, trải nghiệm nhiều nền văn hóa, làm quen với người mới... Thời gian này không thể du hý, ca sĩ dành mọi quan tâm cho người thân, bạn bè và fan. Trò chuyện sâu hơn khiến anh nhìn ra nhiều điều thú vị mà trước đây không thấy, từ đó có thêm chất liệu sáng tác.\n\n\"Quan sát cuộc sống và chuyển động xung quanh giúp khơi nguồn sáng tạo. Bạn có thể cảm nhận trực tiếp bằng các giác quan, qua mạng xã hội, diễn đàn hay báo chí. Với tôi, sự chuyển động này là không ngừng và không bao giờ chán\", anh nói.','2020-06-06','img15.jpg',2,'Trọng Hiếu muốn truyền năng lượng, lạc quan qua âm nhạc',3),(20,'new content2','2020-08-30','img11.jpg',5,'new title23',4),(22,'','2020-08-30','',5,'new title2',1),(23,'new content2','2020-08-30','img11.jpg',5,'fast and furios1',1),(24,'new content2','2020-08-30','img11.jpg',5,'new title2',1),(25,'new content2','2020-08-30','img11.jpg',5,'new title2',1),(26,'new content2','2020-08-30','',5,'new title2',1),(27,'new con8jjjbbbbbbyy','2020-08-31','img11.jpg',5,'0708230984',1),(28,'new content2','2020-08-31','img11.jpg',5,'0708230984',1),(36,'edit content1vvvv','2020-08-31','img11.jpg',8,'0708230984',1),(37,'new content2','2020-08-31','img11.jpg',5,'0708230984',1),(38,'new content2','2020-08-31','',5,'0708230984',1),(39,'edit content1','2020-08-31','img11.jpg',5,'0708230984',2),(40,'edit content1','2020-08-31','img11.jpg',5,'0708230984',1),(41,'new content2','2020-08-31','img11.jpg',5,'0708230984',1),(42,'edit content1','2020-08-31','jjj',5,'0708230984',1),(43,'new content2','2020-08-31','img11.jpg',5,'0708230984',1),(44,'new content2','2020-08-31','img11.jpg',5,'0708230984',1);
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'sport'),(2,'food'),(3,'life'),(4,'develop'),(5,'technology');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-31 11:52:56
