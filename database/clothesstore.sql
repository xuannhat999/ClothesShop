-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: clothesstore
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `action` (
  `action_id` int NOT NULL AUTO_INCREMENT,
  `action_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'Xem'),(2,'Thêm'),(3,'Sửa'),(4,'Xóa'),(5,'Tìm kiếm');
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Uniqlo'),(2,'Gucci'),(3,'Puma'),(4,'Levi'),(5,'Adidas'),(6,'H&M'),(7,'Zara'),(8,'Calvin Klein');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `user_id` int DEFAULT NULL,
  `product_variant_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `pruduct_variant_id` (`product_variant_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product_variant_id`) REFERENCES `product_variant` (`product_variant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (2,1,3),(2,9,1),(2,29,2),(1,1,2),(1,9,1),(1,29,2);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Áo thun'),(2,'Áo sơ mi'),(3,'Áo khoác'),(4,'Áo len'),(5,'Quần jeans'),(6,'Quần short'),(7,'Quần tây'),(8,'Váy đầm'),(9,'Đồ thể thao'),(10,'Đồ ngủ');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `color_id` int NOT NULL AUTO_INCREMENT,
  `color_name` varchar(30) DEFAULT NULL,
  `color_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Đen','#000000'),(2,'Trắng','#FFFFFF'),(3,'Xám','#808080'),(4,'Xanh dương','#0000FF'),(5,'Đỏ','#FF0000'),(6,'Xanh lá','#008000'),(7,'Vàng','#FFFF00'),(8,'Hồng','#FFC0CB'),(9,'Nâu','#8B4513'),(10,'Tím','#800080'),(11,'Cam','#FFA500'),(12,'Be','#F5F5DC'),(13,'Xanh navy','#000080'),(14,'Xanh rêu','#556B2F');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `user_id` (`user_id`),
  KEY `position_id` (`position_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,1),(6,4,2),(7,5,3),(8,6,4),(9,7,5);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feature`
--

DROP TABLE IF EXISTS `feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feature` (
  `feature_id` int NOT NULL AUTO_INCREMENT,
  `feature_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`feature_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feature`
--

LOCK TABLES `feature` WRITE;
/*!40000 ALTER TABLE `feature` DISABLE KEYS */;
INSERT INTO `feature` VALUES (1,'Mua hàng'),(2,'Quản lý sản phẩm'),(4,'Quản lý hóa đơn'),(5,'Quản lý khách hàng'),(6,'Quản lý nhân viên');
/*!40000 ALTER TABLE `feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `gender_id` tinyint NOT NULL,
  `gender_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`gender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (0,'Nữ'),(1,'Nam'),(2,'Unisex');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_product`
--

DROP TABLE IF EXISTS `import_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_product` (
  `import_product_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int DEFAULT NULL,
  `total_amount` decimal(15,2) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  `payment_method` int DEFAULT NULL,
  PRIMARY KEY (`import_product_id`),
  KEY `employee_id` (`employee_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `payment_method` (`payment_method`),
  CONSTRAINT `import_product_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `import_product_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  CONSTRAINT `import_product_ibfk_3` FOREIGN KEY (`payment_method`) REFERENCES `payment_method` (`payment_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_product`
--

LOCK TABLES `import_product` WRITE;
/*!40000 ALTER TABLE `import_product` DISABLE KEYS */;
INSERT INTO `import_product` VALUES (1,1,15480000.00,'2025-04-19',11,1),(4,6,98400000.00,'2025-04-19',12,1),(5,6,164800000.00,'2025-04-19',13,1),(6,7,122800000.00,'2025-04-19',14,2),(7,7,137600000.00,'2025-04-19',15,1);
/*!40000 ALTER TABLE `import_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_product_detail`
--

DROP TABLE IF EXISTS `import_product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_product_detail` (
  `import_detail_id` int NOT NULL AUTO_INCREMENT,
  `import_id` int DEFAULT NULL,
  `product_variant_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`import_detail_id`),
  KEY `import_id` (`import_id`),
  KEY `product_variant_id` (`product_variant_id`),
  CONSTRAINT `import_product_detail_ibfk_1` FOREIGN KEY (`import_id`) REFERENCES `import_product` (`import_product_id`),
  CONSTRAINT `import_product_detail_ibfk_2` FOREIGN KEY (`product_variant_id`) REFERENCES `product_variant` (`product_variant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_product_detail`
--

LOCK TABLES `import_product_detail` WRITE;
/*!40000 ALTER TABLE `import_product_detail` DISABLE KEYS */;
INSERT INTO `import_product_detail` VALUES (1,1,1,50,390000.00),(2,1,2,50,390000.00),(3,1,3,50,390000.00),(4,1,4,50,390000.00),(5,1,5,50,1600000.00),(6,1,6,50,1600000.00),(7,1,7,50,1600000.00),(8,1,8,50,1600000.00),(9,1,9,50,990000.00),(10,1,10,50,990000.00),(11,1,11,50,990000.00),(12,1,12,50,990000.00),(13,1,13,50,890000.00),(14,1,14,50,890000.00),(15,1,15,50,890000.00),(16,1,16,50,890000.00),(17,4,17,50,8900000.00),(18,4,18,50,8900000.00),(19,4,19,50,8900000.00),(20,4,20,50,8900000.00),(21,4,21,50,7000000.00),(22,4,22,50,7000000.00),(23,4,23,50,7000000.00),(24,4,24,50,7000000.00),(25,4,25,50,6900000.00),(26,4,26,50,6900000.00),(27,4,27,50,6900000.00),(28,4,28,50,6900000.00),(29,4,29,50,1800000.00),(30,4,30,50,1800000.00),(31,4,31,50,1800000.00),(32,4,32,50,1800000.00),(33,5,33,50,15000000.00),(34,5,34,50,15000000.00),(35,5,35,50,15000000.00),(36,5,36,50,15000000.00),(37,5,37,50,12000000.00),(38,5,38,50,12000000.00),(39,5,39,50,12000000.00),(40,5,40,50,12000000.00),(41,5,41,50,13000000.00),(42,5,42,50,13000000.00),(43,5,43,50,13000000.00),(44,5,44,50,13000000.00),(45,5,45,50,1200000.00),(46,5,46,50,1200000.00),(47,5,47,50,1200000.00),(48,5,48,50,1200000.00),(49,6,49,50,7000000.00),(50,6,50,50,7000000.00),(51,6,51,50,7000000.00),(52,6,52,50,7000000.00),(53,6,53,50,6900000.00),(54,6,54,50,6900000.00),(55,6,55,50,6900000.00),(56,6,56,50,6900000.00),(57,6,57,50,15000000.00),(58,6,58,50,15000000.00),(59,6,59,50,15000000.00),(60,6,60,50,15000000.00),(61,6,61,50,1800000.00),(62,6,62,50,1800000.00),(63,6,63,50,1800000.00),(64,6,64,50,1800000.00),(65,7,65,50,6900000.00),(66,7,66,50,6900000.00),(67,7,67,50,6900000.00),(68,7,68,50,6900000.00),(69,7,69,50,7000000.00),(70,7,70,50,7000000.00),(71,7,71,50,7000000.00),(72,7,72,50,7000000.00),(73,7,73,50,8500000.00),(74,7,74,50,8500000.00),(75,7,75,50,8500000.00),(76,7,76,50,8500000.00),(77,7,77,50,12000000.00),(78,7,78,50,12000000.00),(79,7,79,50,12000000.00),(80,7,80,50,12000000.00);
/*!40000 ALTER TABLE `import_product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `payment_method_id` int DEFAULT NULL,
  `status` int DEFAULT '0',
  PRIMARY KEY (`invoice_id`),
  KEY `user_id` (`user_id`),
  KEY `employee_id` (`employee_id`),
  KEY `payment_method_id` (`payment_method_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `invoice_ibfk_3` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`payment_method_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_detail`
--

DROP TABLE IF EXISTS `invoice_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_detail` (
  `invoice_id` int DEFAULT NULL,
  `product_variant_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  KEY `invoice_id` (`invoice_id`),
  KEY `product_variant_id` (`product_variant_id`),
  CONSTRAINT `invoice_detail_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  CONSTRAINT `invoice_detail_ibfk_2` FOREIGN KEY (`product_variant_id`) REFERENCES `product_variant` (`product_variant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_detail`
--

LOCK TABLES `invoice_detail` WRITE;
/*!40000 ALTER TABLE `invoice_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `material_id` int NOT NULL AUTO_INCREMENT,
  `material_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Cotton'),(2,'Polyester'),(3,'Len'),(4,'Lụa'),(5,'Jean'),(6,'Da'),(7,'Vải thun'),(8,'Nylon'),(9,'Denim'),(10,'Vải Kaki');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method` (
  `payment_method_id` int NOT NULL AUTO_INCREMENT,
  `payment_method_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`payment_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES (1,'Thanh toán khi nhận hàng'),(2,'Chuyển khoản ngân hàng');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `role_id` int DEFAULT NULL,
  `feature_id` int DEFAULT NULL,
  `action_id` int DEFAULT NULL,
  KEY `role_id` (`role_id`),
  KEY `feature_id` (`feature_id`),
  KEY `action_id` (`action_id`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `permission_ibfk_2` FOREIGN KEY (`feature_id`) REFERENCES `feature` (`feature_id`),
  CONSTRAINT `permission_ibfk_3` FOREIGN KEY (`action_id`) REFERENCES `action` (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,1,4),(1,1,3),(1,1,2),(1,1,1),(1,2,4),(1,2,3),(1,2,2),(1,2,1),(1,4,4),(1,4,3),(1,4,2),(1,4,1),(1,5,4),(1,5,3),(1,5,2),(1,5,1),(1,6,4),(1,6,3),(1,6,2),(1,6,1),(2,1,1),(2,1,2),(2,1,3),(2,1,4),(2,2,1),(2,2,2),(2,2,3),(2,2,4),(2,4,1),(2,4,2),(2,4,3),(2,4,4),(2,5,1),(2,5,2),(2,5,3),(2,5,4);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `position_name` varchar(100) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Admin',15000000.00),(2,'Quản lý cửa hàng',12000000.00),(3,'Nhân viên bán hàng',8000000.00),(4,'Nhân viên kho',7000000.00),(5,'Chăm sóc khách hàng',7500000.00);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `material_id` int DEFAULT NULL,
  `description` text,
  `price` decimal(10,0) DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  `gender` tinyint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `category_id` (`category_id`),
  KEY `material_id` (`material_id`),
  KEY `brand_id` (`brand_id`),
  KEY `gender` (`gender`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `product_ibfk_4` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`),
  CONSTRAINT `product_ibfk_5` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`),
  CONSTRAINT `product_ibfk_6` FOREIGN KEY (`gender`) REFERENCES `gender` (`gender_id`),
  CONSTRAINT `product_chk_1` CHECK ((`gender` in (0,1,2)))
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Áo thun Uniqlo',1,1,'Áo thun cotton co giãn, thoáng mát',390000,1,0),(2,'Áo khoác Uniqlo',3,3,'Áo khoác giữ nhiệt siêu nhẹ',1600000,1,2),(3,'Quần jeans Uniqlo',5,5,'Quần jeans nam dáng slim fit',990000,1,1),(4,'Váy midi Uniqlo',8,4,'Váy midi xòe phong cách Hàn Quốc',890000,1,0),(5,'Bộ đồ ngủ Uniqlo',10,8,'Bộ đồ ngủ lụa mềm mại',490000,1,2),(6,'Áo sơ mi Gucci',2,2,'Áo sơ mi nam thiết kế sang trọng',8900000,2,0),(7,'Áo len Gucci',4,4,'Áo len lông cừu cao cấp',7000000,2,1),(8,'Quần short Gucci',6,6,'Quần short nam họa tiết đặc biệt',6900000,2,0),(9,'Váy đầm Gucci',8,4,'Váy dạ hội cao cấp',15000000,2,0),(10,'Bộ đồ thể thao Gucci',9,7,'Bộ đồ thể thao hàng hiệu',13000000,2,2),(11,'Áo thun Puma',1,1,'Áo thun thể thao thoáng khí',350000,3,0),(12,'Áo khoác Puma',3,2,'Áo khoác gió chống nước',990000,3,2),(13,'Quần short Puma',6,6,'Quần short thể thao nam',490000,3,0),(14,'Giày thể thao Puma',9,7,'Giày chạy bộ nhẹ, êm ái',1800000,3,2),(15,'Áo len Puma',4,3,'Áo len Puma chống lạnh',1200000,3,1),(16,'Quần jeans Levi’s 501',5,5,'Quần jeans nam cổ điển',1500000,4,0),(17,'Áo thun Levi’s',1,1,'Áo thun in logo Levi’s',500000,4,2),(18,'Áo khoác bò Levi’s',3,6,'Áo khoác denim nam',1900000,4,0),(19,'Váy denim Levi’s',8,5,'Váy jeans phong cách năng động',1200000,4,1),(20,'Áo polo Levi’s',2,2,'Áo polo nam chất liệu cao cấp',850000,4,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_color`
--

DROP TABLE IF EXISTS `product_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_color` (
  `product_color_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `color_id` int DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_color_id`),
  KEY `product_id` (`product_id`),
  KEY `color_id` (`color_id`),
  CONSTRAINT `product_color_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `product_color_ibfk_2` FOREIGN KEY (`color_id`) REFERENCES `color` (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_color`
--

LOCK TABLES `product_color` WRITE;
/*!40000 ALTER TABLE `product_color` DISABLE KEYS */;
INSERT INTO `product_color` VALUES (1,1,1,'productimage/product_1_black.jpg'),(2,2,3,'productimage/product_2_gray.png'),(3,3,13,'productimage/product_3_navy.png'),(4,4,4,'productimage/product_4_blue.png'),(5,5,8,'productimage/product_5_pink.png'),(6,6,2,'productimage/product_6_white.png'),(7,7,4,'productimage/product_7_blue.png'),(8,8,6,'productimage/product_8_green.png'),(9,9,4,'productimage/product_9_blue.png'),(10,10,7,'productimage/product_10_yellow.png'),(11,11,1,'productimage/product_11_black.png'),(12,12,3,'productimage/product_12_gray.jpg'),(13,13,6,'productimage/product_13_green.png'),(14,14,7,'productimage/product_14_yellow.png'),(15,15,1,'productimage/product_15_black.png'),(16,16,5,'productimage/product_16_red.png'),(17,17,1,'productimage/product_17_black.png'),(18,18,5,'productimage/product_18_red.png'),(19,19,5,'productimage/product_19_red.jpg'),(20,20,2,'productimage/product_20_white.png'),(43,1,2,'1');
/*!40000 ALTER TABLE `product_color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_variant`
--

DROP TABLE IF EXISTS `product_variant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_variant` (
  `product_variant_id` int NOT NULL AUTO_INCREMENT,
  `product_color_id` int DEFAULT NULL,
  `size` enum('S','M','L','XL') DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`product_variant_id`),
  KEY `product_color_id` (`product_color_id`),
  CONSTRAINT `product_variant_ibfk_1` FOREIGN KEY (`product_color_id`) REFERENCES `product_color` (`product_color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variant`
--

LOCK TABLES `product_variant` WRITE;
/*!40000 ALTER TABLE `product_variant` DISABLE KEYS */;
INSERT INTO `product_variant` VALUES (1,1,'S',50),(2,1,'M',50),(3,1,'L',50),(4,1,'XL',50),(5,2,'S',50),(6,2,'M',50),(7,2,'L',50),(8,2,'XL',50),(9,3,'S',50),(10,3,'M',50),(11,3,'L',50),(12,3,'XL',50),(13,4,'S',50),(14,4,'M',50),(15,4,'L',50),(16,4,'XL',50),(17,5,'S',50),(18,5,'M',50),(19,5,'L',50),(20,5,'XL',50),(21,6,'S',50),(22,6,'M',50),(23,6,'L',50),(24,6,'XL',50),(25,7,'S',50),(26,7,'M',50),(27,7,'L',50),(28,7,'XL',50),(29,8,'S',50),(30,8,'M',50),(31,8,'L',50),(32,8,'XL',50),(33,9,'S',50),(34,9,'M',50),(35,9,'L',50),(36,9,'XL',50),(37,10,'S',50),(38,10,'M',50),(39,10,'L',50),(40,10,'XL',50),(41,11,'S',50),(42,11,'M',50),(43,11,'L',50),(44,11,'XL',50),(45,12,'S',50),(46,12,'M',50),(47,12,'L',50),(48,12,'XL',50),(49,13,'S',50),(50,13,'M',50),(51,13,'L',50),(52,13,'XL',50),(53,14,'S',50),(54,14,'M',50),(55,14,'L',50),(56,14,'XL',50),(57,15,'S',50),(58,15,'M',50),(59,15,'L',50),(60,15,'XL',50),(61,16,'S',50),(62,16,'M',50),(63,16,'L',50),(64,16,'XL',50),(65,17,'S',50),(66,17,'M',50),(67,17,'L',50),(68,17,'XL',50),(69,18,'S',50),(70,18,'M',50),(71,18,'L',50),(72,18,'XL',50),(73,19,'S',50),(74,19,'M',50),(75,19,'L',50),(76,19,'XL',50),(77,20,'S',50),(78,20,'M',50),(79,20,'L',50),(80,20,'XL',50),(165,43,'S',0),(166,43,'M',0),(167,43,'L',0),(168,43,'XL',0);
/*!40000 ALTER TABLE `product_variant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Staff'),(3,'Customer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (11,'Thời trang The Blue','028 3925 5679','contact@theblue.vn','Số 123 Nguyễn Trãi, Quận 5, TP.HCM'),(12,'Thời trang NEM','028 3821 8920','support@nem.vn','Số 12 Lê Lợi, Quận 1, TP.HCM'),(13,'Thời trang Canifa','024 7303 6018','cs@canifa.com','Số 30 Trần Hưng Đạo, Hà Nội'),(14,'Thời trang Việt Tiến','028 3832 4523','sales@viettien.com.vn','Số 456 Cộng Hòa, Tân Bình, TP.HCM'),(15,'Thời trang John Henry','028 3835 6789','contact@johnhenry.com.vn','Số 9 Nguyễn Đình Chiểu, Quận 3, TP.HCM');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` tinyint DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`),
  KEY `role` (`role`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_chk_1` CHECK ((`gender` in (0,1,2)))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','1995-05-20','0987654321','nguyenvana@example.com',1,'123 Đường ABC, Hà Nội','admin','1',1),(2,'Employee','1990-01-01','0901234567','employee@example.com',1,'123 Employee Street','employee','1',2),(3,'Customer','1995-05-05','0912345678','customer@example.com',0,'456 Customer Avenue','customer','1',3),(4,'Employee2','1995-01-01','0900000002','employee2@example.com',1,'Hà Nội','employee2','password2',2),(5,'Employee3','1996-02-02','0900000003','employee3@example.com',0,'Hồ Chí Minh','employee3','password3',2),(6,'Employee4','1997-03-03','0900000004','employee4@example.com',1,'Đà Nẵng','employee4','password4',2),(7,'Employee5','1998-04-04','0900000005','employee5@example.com',0,'Cần Thơ','employee5','password5',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-22 20:38:10
