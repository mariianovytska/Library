-- MySQL dump 10.16  Distrib 10.1.35-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	10.1.35-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author_book`
--

DROP TABLE IF EXISTS `author_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) NOT NULL,
  `book_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7cqs8nb7l859jcwwqoawcokqf` (`author_id`),
  KEY `FKmeehr164a2cpxegeiawuv40a3` (`book_id`),
  CONSTRAINT `FK7cqs8nb7l859jcwwqoawcokqf` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`),
  CONSTRAINT `FKmeehr164a2cpxegeiawuv40a3` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_book`
--

LOCK TABLES `author_book` WRITE;
/*!40000 ALTER TABLE `author_book` DISABLE KEYS */;
INSERT INTO `author_book` VALUES (1,1,1),(2,1,2),(3,2,3),(4,2,4),(5,2,5),(6,3,6),(7,6,9),(8,4,8),(9,5,7);
/*!40000 ALTER TABLE `author_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `born` date DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'1951-06-10','male','Шкляр Василь Миколайович'),(2,'1961-07-28','male','Joshua Bloch'),(3,NULL,'male','Martin Fowler'),(4,NULL,'male','Chad Fowler'),(5,'1965-07-31','female','J. K. Rowling'),(6,'1964-06-22','male','Dan Brown'),(7,'1962-08-10','female','Suzanne Collins');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `genre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `published` date DEFAULT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'historical_novel','Залишенець. Чорний ворон',NULL,5),(2,'novel','Ключ','1999-01-01',3),(3,'technical','Effective Java: Programming Language Guide','2001-03-02',5),(4,'technical','Java Concurrency in Practice','2006-04-23',4),(5,'technical','Java Puzzlers: Traps, Pitfalls, and Corner Cases','2005-02-02',4),(6,'technical','Patterns of Enterprise Application Architecture','2002-06-25',3),(7,'fantasy','Harry Potter and the Philosophers Stone','1997-06-26',5),(8,'education','The Passionate Programmer','1999-09-21',5),(9,'crime','The Lost Symbol',NULL,4);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-15 14:08:13
