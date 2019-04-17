CREATE DATABASE `bank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
CREATE TABLE `account` (
  `accountNumber` varchar(12) NOT NULL,
  `type` varchar(45) NOT NULL,
  `balance` float NOT NULL,
  `creationDate` varchar(45) NOT NULL,
  `ownerSSN` varchar(13) NOT NULL,
  PRIMARY KEY (`accountNumber`),
  KEY `ssn_idx` (`ownerSSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `administrator` (
  `idAdministrator` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ssn` varchar(13) NOT NULL,
  PRIMARY KEY (`idAdministrator`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `identityCardNo` varchar(6) NOT NULL,
  `ssn` varchar(13) NOT NULL,
  `address` varchar(45) NOT NULL,
  `utilitiesProvider` varchar(3) NOT NULL,
  PRIMARY KEY (`ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `employee` (
  `idEmployee` int(11) NOT NULL AUTO_INCREMENT,
  `nameEmployee` varchar(45) NOT NULL,
  `ssn` varchar(13) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmployee`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT `account`.`accountNumber`,
    `account`.`type`,
    `account`.`balance`,
    `account`.`creationDate`,
    `account`.`ownerSSN`
FROM `bank`.`account`;
SELECT `administrator`.`idAdministrator`,
    `administrator`.`email`,
    `administrator`.`password`,
    `administrator`.`ssn`
FROM `bank`.`administrator`;
SELECT `client`.`idClient`,
    `client`.`name`,
    `client`.`identityCardNo`,
    `client`.`ssn`,
    `client`.`address`,
    `client`.`utilitiesProvider`
FROM `bank`.`client`;
SELECT `employee`.`idEmployee`,
    `employee`.`nameEmployee`,
    `employee`.`ssn`,
    `employee`.`email`,
    `employee`.`password`
FROM `bank`.`employee`;
