/* DATABASE AND USER CREATION SCRIPT */
CREATE DATABASE `webstore`;

CREATE USER `steven`@`localhost` IDENTIFIED BY '12345678';

GRANT ALL PRIVILEGES ON *.* TO `steven`@`localhost`;

/* CUSTOMER TABLE CREATION SCRIPT */
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(200) DEFAULT 'default-password',
  `name` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `numoforders` int(11) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;


/* PRODUCT TABLE CREATION SCRIPT */
DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  `description` varchar(200) DEFAULT 'Just a very cool product. Yeah, its just cool. I have nothing more to say. Just buy it already.',
  `manufacturer` varchar(30) NOT NULL,
  `category` varchar(20) NOT NULL,
  `unitsinstock` int(11) DEFAULT '0',
  `unitsinorder` int(11) DEFAULT '0',
  `discontinued` tinyint(1) DEFAULT '0',
  `condition` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;


/* ORDER TABLE CREATION SCRIPT */
DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `purchaserUsername` varchar(50) NOT NULL,
  `productId` bigint(20) unsigned NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`),
  KEY `productId` (`productId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`purchaserUsername`) REFERENCES `customer` (`email`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


