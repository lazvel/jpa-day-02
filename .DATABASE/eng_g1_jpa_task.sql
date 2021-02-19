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


-- Dumping database structure for eng_g1_jpa_task
DROP DATABASE IF EXISTS `eng_g1_jpa_task`;
CREATE DATABASE IF NOT EXISTS `eng_g1_jpa_task` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `eng_g1_jpa_task`;

-- Dumping structure for table eng_g1_jpa_task.city
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `number` bigint(20) unsigned NOT NULL,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa_task.city: ~2 rows (approximately)
DELETE FROM `city`;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`id`, `number`, `name`) VALUES
	(1, 11000, 'Beograd'),
	(2, 11070, 'Novi Beograd');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa_task.contact
DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `value` varchar(255) NOT NULL,
  `person_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_person_id` (`person_id`),
  CONSTRAINT `fk_contact_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa_task.contact: ~0 rows (approximately)
DELETE FROM `contact`;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` (`id`, `type`, `value`, `person_id`) VALUES
	(10, 'ADDRESS', 'ul. Topolska 18', 5),
	(11, 'EMAIL', 'lazvel@gmail.com', 5),
	(12, 'PHONE', '+38162555333', 5),
	(13, 'PHONE', '+38111555333', 5);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;

-- Dumping structure for table eng_g1_jpa_task.person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `personal_identity_number` varchar(13) NOT NULL,
  `firstname` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `born_city_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_person_born_city` (`born_city_id`),
  CONSTRAINT `fk_person_born_city` FOREIGN KEY (`born_city_id`) REFERENCES `city` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table eng_g1_jpa_task.person: ~1 rows (approximately)
DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `personal_identity_number`, `firstname`, `lastname`, `born_city_id`) VALUES
	(1, '555333', 'zoxi', 'zox', 2),
	(5, '5553333122121', 'Laz', 'Vel', 2);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
