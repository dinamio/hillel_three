CREATE DATABASE `real_estate_agency` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `apartments` (
  `IDApartments` int(255) NOT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `typeEstate` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `floor` int(255) DEFAULT NULL,
  `countOfRoom` int(255) DEFAULT NULL,
  `size` decimal(2,0) DEFAULT NULL,
  `additionalDescription` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`IDApartments`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
