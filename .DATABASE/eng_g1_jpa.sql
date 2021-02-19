-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.17-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for eng_g1_jpa
DROP DATABASE IF EXISTS `eng_g1_jpa`;
CREATE DATABASE IF NOT EXISTS `eng_g1_jpa` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `eng_g1_jpa`;

-- Dumping structure for table eng_g1_jpa.business_partner
DROP TABLE IF EXISTS `business_partner`;
CREATE TABLE IF NOT EXISTS `business_partner` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `personal_identity_number` varchar(13) DEFAULT NULL,
  `firstname` varchar(128) DEFAULT NULL,
  `lastname` varchar(128) DEFAULT NULL,
  `company_identity_number` varchar(8) DEFAULT NULL,
  `tax_number` varchar(9) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `partner_type` varchar(2) DEFAULT NULL COMMENT 'FL, PL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa.business_partner: ~0 rows (approximately)
DELETE FROM `business_partner`;
/*!40000 ALTER TABLE `business_partner` DISABLE KEYS */;
INSERT INTO `business_partner` (`id`, `personal_identity_number`, `firstname`, `lastname`, `company_identity_number`, `tax_number`, `name`, `partner_type`) VALUES
	(1, NULL, NULL, NULL, '12345678', '12345678', 'Petak d.o.o', 'PL'),
	(2, '012345678', 'Mika', 'Mikic', NULL, NULL, NULL, 'FL');
/*!40000 ALTER TABLE `business_partner` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa.city
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `number` bigint(20) unsigned NOT NULL,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa.city: ~4 rows (approximately)
DELETE FROM `city`;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`number`, `name`) VALUES
	(11000, 'Beograd'),
	(13000, 'Pancevo'),
	(16000, 'Leskovac'),
	(18000, 'Nis'),
	(37000, 'Krusevac'),
	(37230, 'Aleksandrovac');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa.contact_person
DROP TABLE IF EXISTS `contact_person`;
CREATE TABLE IF NOT EXISTS `contact_person` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(128) DEFAULT NULL,
  `lastname` varchar(128) DEFAULT NULL,
  `manufacturer_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_person_manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `fk_contact_person_manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa.contact_person: ~0 rows (approximately)
DELETE FROM `contact_person`;
/*!40000 ALTER TABLE `contact_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_person` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa.manufacturer
DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE IF NOT EXISTS `manufacturer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `city_number` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_manufacturer_city_number` (`city_number`),
  CONSTRAINT `fk_manufacturer_city_number` FOREIGN KEY (`city_number`) REFERENCES `city` (`number`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa.manufacturer: ~1 rows (approximately)
DELETE FROM `manufacturer`;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` (`id`, `name`, `city_number`) VALUES
	(17, 'proizvodjac - 1', 11000);
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `manufacturer_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `fk_product_manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa.product: ~1 rows (approximately)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `manufacturer_id`) VALUES
	(2, 'proizvod - 2', 17);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa.product_category
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE IF NOT EXISTS `product_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa.product_category: ~4 rows (approximately)
DELETE FROM `product_category`;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` (`id`, `name`) VALUES
	(1, 'kategorija - 1'),
	(2, 'kategorija - 2'),
	(3, 'kategorija - 3'),
	(4, 'kategorija - 4');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa.product_product_category
DROP TABLE IF EXISTS `product_product_category`;
CREATE TABLE IF NOT EXISTS `product_product_category` (
  `product_id` bigint(20) unsigned DEFAULT NULL,
  `category_id` bigint(20) unsigned DEFAULT NULL,
  KEY `fk_product_id` (`product_id`),
  KEY `fk_category_id` (`category_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa.product_product_category: ~2 rows (approximately)
DELETE FROM `product_product_category`;
/*!40000 ALTER TABLE `product_product_category` DISABLE KEYS */;
INSERT INTO `product_product_category` (`product_id`, `category_id`) VALUES
	(2, 1),
	(2, 2);
/*!40000 ALTER TABLE `product_product_category` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
