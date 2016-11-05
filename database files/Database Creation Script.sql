/* DATABASE AND USER CREATION SCRIPT */
CREATE DATABASE `webstore`;

CREATE USER `steven`@`localhost` IDENTIFIED BY '12345678';

GRANT ALL PRIVILEGES ON *.* TO `steven`@`localhost`;

/* CUSTOMER TABLE CREATION SCRIPT */
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` SERIAL,
  `email` varchar(50) PRIMARY KEY,
  `password` varchar(200) DEFAULT 'default-password',
  `name` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `numoforders` int(10) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* PRODUCT TABLE CREATION SCRIPT */
DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` SERIAL PRIMARY KEY,
  `name` varchar(20) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  `description` varchar(200) DEFAULT "Just a very cool product. Yeah, it's just cool.",
  `manufacturer` varchar(30) NOT NULL,
  `category` varchar(20) NOT NULL,
  `unitsinstock` int(10) DEFAULT 0,
  `unitsinorder` int(10) DEFAULT 0,
  `discontinued` boolean DEFAULT 0,
  `condition` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* ORDER TABLE CREATION SCRIPT */
DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` SERIAL PRIMARY KEY,
  `purchaserUsername` varchar(50) NOT NULL,
  `productId` bigint(20) unsigned NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`purchaserUsername`) REFERENCES `customer` (`email`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


