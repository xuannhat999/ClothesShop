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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank` (
  `bank_id` int NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_account` (
  `bank_account_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `bank_account_number` varchar(15) DEFAULT NULL,
  `bank_id` int DEFAULT NULL,
  PRIMARY KEY (`bank_account_id`),
  KEY `user_id` (`user_id`),
  KEY `bank_id` (`bank_id`),
  CONSTRAINT `bank_account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `bank_account_ibfk_2` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
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
  `pruduct_variant_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `pruduct_variant_id` (`pruduct_variant_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`pruduct_variant_id`) REFERENCES `product_variant` (`product_variant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
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
INSERT INTO `feature` VALUES (1,'Mua hàng'),(2,'Quản lý sản phẩm'),(3,'Quản lý nhập hàng'),(4,'Quản lý hóa đơn'),(5,'Quản lý khách hàng'),(6,'Quản lý nhân viên');
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
  `total_amount` decimal(10,2) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  `payment_method` int DEFAULT NULL,
  `bank_account_id` int DEFAULT NULL,
  PRIMARY KEY (`import_product_id`),
  KEY `employee_id` (`employee_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `payment_method` (`payment_method`),
  KEY `bank_account_id` (`bank_account_id`),
  CONSTRAINT `import_product_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `import_product_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  CONSTRAINT `import_product_ibfk_3` FOREIGN KEY (`payment_method`) REFERENCES `payment_method` (`payment_method_id`),
  CONSTRAINT `import_product_ibfk_4` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_account` (`bank_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_product`
--

LOCK TABLES `import_product` WRITE;
/*!40000 ALTER TABLE `import_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `import_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_product_detail`
--

DROP TABLE IF EXISTS `import_product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_product_detail` (
  `import_id` int DEFAULT NULL,
  `product_variant_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  KEY `import_id` (`import_id`),
  KEY `product_variant_id` (`product_variant_id`),
  CONSTRAINT `import_product_detail_ibfk_1` FOREIGN KEY (`import_id`) REFERENCES `import_product` (`import_product_id`),
  CONSTRAINT `import_product_detail_ibfk_2` FOREIGN KEY (`product_variant_id`) REFERENCES `product_variant` (`product_variant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_product_detail`
--

LOCK TABLES `import_product_detail` WRITE;
/*!40000 ALTER TABLE `import_product_detail` DISABLE KEYS */;
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
  `bank_account_id` int DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `user_id` (`user_id`),
  KEY `employee_id` (`employee_id`),
  KEY `payment_method_id` (`payment_method_id`),
  KEY `bank_account_id` (`bank_account_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `invoice_ibfk_3` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`payment_method_id`),
  CONSTRAINT `invoice_ibfk_4` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_account` (`bank_account_id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
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
INSERT INTO `permission` VALUES (1,1,5),(1,1,4),(1,1,3),(1,1,2),(1,1,1),(1,2,5),(1,2,4),(1,2,3),(1,2,2),(1,2,1),(1,3,5),(1,3,4),(1,3,3),(1,3,2),(1,3,1),(1,4,5),(1,4,4),(1,4,3),(1,4,2),(1,4,1),(1,5,5),(1,5,4),(1,5,3),(1,5,2),(1,5,1),(1,6,5),(1,6,4),(1,6,3),(1,6,2),(1,6,1),(2,1,1),(2,1,2),(2,1,3),(2,1,4),(2,1,5),(2,2,1),(2,2,2),(2,2,3),(2,2,4),(2,2,5),(2,3,1),(2,3,2),(2,3,3),(2,3,4),(2,3,5),(2,4,1),(2,4,2),(2,4,3),(2,4,4),(2,4,5),(2,5,1),(2,5,2),(2,5,3),(2,5,4),(2,5,5);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Áo thun Uniqlo',1,1,'Áo thun cotton co giãn, thoáng mát',390000,1,0),(2,'Áo khoác Uniqlo',3,3,'Áo khoác giữ nhiệt siêu nhẹ',1600000,1,2),(3,'Quần jeans Uniqlo',5,5,'Quần jeans nam dáng slim fit',990000,1,0),(4,'Váy midi Uniqlo',8,4,'Váy midi xòe phong cách Hàn Quốc',890000,1,1),(5,'Bộ đồ ngủ Uniqlo',10,8,'Bộ đồ ngủ lụa mềm mại',490000,1,2),(6,'Áo sơ mi Gucci',2,2,'Áo sơ mi nam thiết kế sang trọng',8900000,2,0),(7,'Áo len Gucci',4,4,'Áo len lông cừu cao cấp',7000000,2,1),(8,'Quần short Gucci',6,6,'Quần short nam họa tiết đặc biệt',6900000,2,0),(9,'Váy đầm Gucci',8,4,'Váy dạ hội cao cấp',15000000,2,1),(10,'Bộ đồ thể thao Gucci',9,7,'Bộ đồ thể thao hàng hiệu',13000000,2,2),(11,'Áo thun Puma',1,1,'Áo thun thể thao thoáng khí',350000,3,0),(12,'Áo khoác Puma',3,3,'Áo khoác gió chống nước',990000,3,2),(13,'Quần short Puma',6,6,'Quần short thể thao nam',490000,3,0),(14,'Giày thể thao Puma',9,7,'Giày chạy bộ nhẹ, êm ái',1800000,3,2),(15,'Bộ đồ thể thao Puma',9,7,'Bộ thể thao thoáng mát',1200000,3,0),(16,'Quần jeans Levi’s 501',5,5,'Quần jeans nam cổ điển',1500000,4,0),(17,'Áo thun Levi’s',1,1,'Áo thun in logo Levi’s',500000,4,2),(18,'Áo khoác bò Levi’s',3,5,'Áo khoác denim nam',1900000,4,0),(19,'Váy denim Levi’s',8,5,'Váy jeans phong cách năng động',1200000,4,1),(20,'Áo polo Levi’s',2,2,'Áo polo nam chất liệu cao cấp',850000,4,0),(21,'Áo thun Adidas',1,1,'Áo thun thể thao thấm hút mồ hôi',450000,5,0),(22,'Áo khoác Adidas',3,3,'Áo khoác gió siêu nhẹ',1200000,5,2),(23,'Quần thể thao Adidas',9,6,'Quần jogger thể thao',750000,5,0),(24,'Giày thể thao Adidas',9,7,'Giày chạy bộ thoải mái',2100000,5,2),(25,'Bộ đồ thể thao Adidas',9,7,'Bộ thể thao co giãn',1300000,5,0),(26,'Áo sơ mi H&M',2,2,'Áo sơ mi công sở đơn giản',490000,6,0),(27,'Áo len H&M',4,4,'Áo len nữ cổ lọ mềm mại',690000,6,1),(28,'Quần jeans H&M',5,5,'Quần jeans dáng ôm thời trang',850000,6,0),(29,'Váy đầm H&M',8,4,'Váy đầm dạ hội sang trọng',1200000,6,1),(30,'Bộ đồ ngủ H&M',10,8,'Bộ ngủ lụa mềm mại',590000,6,2),(31,'Áo khoác Zara',3,3,'Áo khoác dáng dài thanh lịch',1900000,7,1),(32,'Áo thun Zara',1,1,'Áo thun cotton cao cấp',550000,7,0),(33,'Quần tây Zara',7,6,'Quần tây nam phong cách Hàn Quốc',1200000,7,0),(34,'Váy bodycon Zara',8,4,'Váy bodycon tôn dáng',890000,7,1),(35,'Bộ suit Zara',7,6,'Bộ suit nam lịch lãm',3500000,7,0),(36,'Áo polo Calvin Klein',2,2,'Áo polo cao cấp',990000,8,0),(37,'Áo khoác Calvin Klein',3,3,'Áo khoác da thời trang',4500000,8,2),(38,'Quần jeans Calvin Klein',5,5,'Quần jeans nam phong cách',1800000,8,0),(39,'Bộ đồ ngủ Calvin Klein',10,8,'Bộ đồ ngủ cotton mềm',750000,8,2),(40,'Bộ đồ thể thao Calvin Klein',9,7,'Bộ thể thao nam cao cấp',2000000,8,0);
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
  `url1` varchar(100) DEFAULT NULL,
  `url2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_color_id`),
  KEY `product_id` (`product_id`),
  KEY `color_id` (`color_id`),
  CONSTRAINT `product_color_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `product_color_ibfk_2` FOREIGN KEY (`color_id`) REFERENCES `color` (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_color`
--

LOCK TABLES `product_color` WRITE;
/*!40000 ALTER TABLE `product_color` DISABLE KEYS */;
INSERT INTO `product_color` VALUES (1,1,1,'image1.jpg','image2.jpg'),(2,2,3,'image3.jpg','image4.jpg'),(3,3,5,'image5.jpg','image6.jpg'),(4,4,4,'image7.jpg','image8.jpg'),(5,5,8,'image9.jpg','image10.jpg'),(6,6,2,'image11.jpg','image12.jpg'),(7,7,4,'image13.jpg','image14.jpg'),(8,8,6,'image15.jpg','image16.jpg'),(9,9,4,'image17.jpg','image18.jpg'),(10,10,7,'image19.jpg','image20.jpg'),(11,11,1,'image21.jpg','image22.jpg'),(12,12,3,'image23.jpg','image24.jpg'),(13,13,6,'image25.jpg','image26.jpg'),(14,14,7,'image27.jpg','image28.jpg'),(15,15,7,'image29.jpg','image30.jpg'),(16,16,5,'image31.jpg','image32.jpg'),(17,17,1,'image33.jpg','image34.jpg'),(18,18,5,'image35.jpg','image36.jpg'),(19,19,5,'image37.jpg','image38.jpg'),(20,20,2,'image39.jpg','image40.jpg'),(21,21,1,'image41.jpg','image42.jpg'),(22,22,3,'image43.jpg','image44.jpg'),(23,23,6,'image45.jpg','image46.jpg'),(24,24,7,'image47.jpg','image48.jpg'),(25,25,7,'image49.jpg','image50.jpg'),(26,26,2,'image51.jpg','image52.jpg'),(27,27,4,'image53.jpg','image54.jpg'),(28,28,5,'image55.jpg','image56.jpg'),(29,29,4,'image57.jpg','image58.jpg'),(30,30,8,'image59.jpg','image60.jpg'),(31,31,3,'image61.jpg','image62.jpg'),(32,32,1,'image63.jpg','image64.jpg'),(33,33,6,'image65.jpg','image66.jpg'),(34,34,4,'image67.jpg','image68.jpg'),(35,35,6,'image69.jpg','image70.jpg'),(36,36,2,'image71.jpg','image72.jpg'),(37,37,3,'image73.jpg','image74.jpg'),(38,38,5,'image75.jpg','image76.jpg'),(39,39,8,'image77.jpg','image78.jpg'),(40,40,7,'image79.jpg','image80.jpg');
/*!40000 ALTER TABLE `product_color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_rate`
--

DROP TABLE IF EXISTS `product_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_rate` (
  `rate_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `star` int DEFAULT NULL,
  PRIMARY KEY (`rate_id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `product_rate_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `product_rate_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `product_rate_chk_1` CHECK (((`star` <= 5) and (`star` >= 0)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_rate`
--

LOCK TABLES `product_rate` WRITE;
/*!40000 ALTER TABLE `product_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_rate` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variant`
--

LOCK TABLES `product_variant` WRITE;
/*!40000 ALTER TABLE `product_variant` DISABLE KEYS */;
INSERT INTO `product_variant` VALUES (1,1,'S',50),(2,1,'M',50),(3,1,'L',50),(4,1,'XL',50),(5,2,'S',50),(6,2,'M',50),(7,2,'L',50),(8,2,'XL',50),(9,3,'S',50),(10,3,'M',50),(11,3,'L',50),(12,3,'XL',50),(13,4,'S',50),(14,4,'M',50),(15,4,'L',50),(16,4,'XL',50),(17,5,'S',50),(18,5,'M',50),(19,5,'L',50),(20,5,'XL',50),(21,6,'S',50),(22,6,'M',50),(23,6,'L',50),(24,6,'XL',50),(25,7,'S',50),(26,7,'M',50),(27,7,'L',50),(28,7,'XL',50),(29,8,'S',50),(30,8,'M',50),(31,8,'L',50),(32,8,'XL',50),(33,9,'S',50),(34,9,'M',50),(35,9,'L',50),(36,9,'XL',50),(37,10,'S',50),(38,10,'M',50),(39,10,'L',50),(40,10,'XL',50),(41,11,'S',50),(42,11,'M',50),(43,11,'L',50),(44,11,'XL',50),(45,12,'S',50),(46,12,'M',50),(47,12,'L',50),(48,12,'XL',50),(49,13,'S',50),(50,13,'M',50),(51,13,'L',50),(52,13,'XL',50),(53,14,'S',50),(54,14,'M',50),(55,14,'L',50),(56,14,'XL',50),(57,15,'S',50),(58,15,'M',50),(59,15,'L',50),(60,15,'XL',50),(61,16,'S',50),(62,16,'M',50),(63,16,'L',50),(64,16,'XL',50),(65,17,'S',50),(66,17,'M',50),(67,17,'L',50),(68,17,'XL',50),(69,18,'S',50),(70,18,'M',50),(71,18,'L',50),(72,18,'XL',50),(73,19,'S',50),(74,19,'M',50),(75,19,'L',50),(76,19,'XL',50),(77,20,'S',50),(78,20,'M',50),(79,20,'L',50),(80,20,'XL',50),(81,21,'S',50),(82,21,'M',50),(83,21,'L',50),(84,21,'XL',50),(85,22,'S',50),(86,22,'M',50),(87,22,'L',50),(88,22,'XL',50),(89,23,'S',50),(90,23,'M',50),(91,23,'L',50),(92,23,'XL',50),(93,24,'S',50),(94,24,'M',50),(95,24,'L',50),(96,24,'XL',50),(97,25,'S',50),(98,25,'M',50),(99,25,'L',50),(100,25,'XL',50),(101,26,'S',50),(102,26,'M',50),(103,26,'L',50),(104,26,'XL',50),(105,27,'S',50),(106,27,'M',50),(107,27,'L',50),(108,27,'XL',50),(109,28,'S',50),(110,28,'M',50),(111,28,'L',50),(112,28,'XL',50),(113,29,'S',50),(114,29,'M',50),(115,29,'L',50),(116,29,'XL',50),(117,30,'S',50),(118,30,'M',50),(119,30,'L',50),(120,30,'XL',50),(121,31,'S',50),(122,31,'M',50),(123,31,'L',50),(124,31,'XL',50),(125,32,'S',50),(126,32,'M',50),(127,32,'L',50),(128,32,'XL',50),(129,33,'S',50),(130,33,'M',50),(131,33,'L',50),(132,33,'XL',50),(133,34,'S',50),(134,34,'M',50),(135,34,'L',50),(136,34,'XL',50),(137,35,'S',50),(138,35,'M',50),(139,35,'L',50),(140,35,'XL',50),(141,36,'S',50),(142,36,'M',50),(143,36,'L',50),(144,36,'XL',50),(145,37,'S',50),(146,37,'M',50),(147,37,'L',50),(148,37,'XL',50),(149,38,'S',50),(150,38,'M',50),(151,38,'L',50),(152,38,'XL',50),(153,39,'S',50),(154,39,'M',50),(155,39,'L',50),(156,39,'XL',50),(157,40,'S',50),(158,40,'M',50),(159,40,'L',50),(160,40,'XL',50);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','1995-05-20','0987654321','nguyenvana@example.com',1,'123 Đường ABC, Hà Nội','admin','1',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'clothesstore'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-05 21:29:39
