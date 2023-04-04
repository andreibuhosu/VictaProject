CREATE DATABASE  IF NOT EXISTS `victawebsite` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `victawebsite`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: victawebsite
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `paitents`
--

DROP TABLE IF EXISTS `paitents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paitents` (
  `PatientNumber` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `Surname` varchar(50) DEFAULT NULL,
  `Initials` varchar(50) DEFAULT NULL,
  `Middlename` varchar(50) DEFAULT NULL,
  `DateofBirth` datetime DEFAULT NULL,
  `Age` varchar(50) DEFAULT NULL,
  `SexGender` varchar(50) DEFAULT NULL,
  `HospitalNumber` varchar(50) DEFAULT NULL,
  `HospitalName` varchar(50) DEFAULT NULL,
  `Continent` varchar(50) DEFAULT NULL,
  `Region of the Continent` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Longitude` varchar(50) DEFAULT NULL,
  `Latitude` varchar(50) DEFAULT NULL,
  `Altitude` varchar(50) DEFAULT NULL,
  `DateOpenedFile` datetime DEFAULT NULL,
  `Time` datetime DEFAULT NULL,
  `Recent Travel Migration` varchar(50) DEFAULT NULL,
  `Endemic DiseasesCountryRegion` varchar(50) DEFAULT NULL,
  `Disease Vectors` varchar(50) DEFAULT NULL,
  `CommunicableDiseaseContact` varchar(50) DEFAULT NULL,
  `RecentFoodEatenSource` varchar(50) DEFAULT NULL,
  `RecentWaterDrunkSource` varchar(50) DEFAULT NULL,
  `RecentToiletSanitationSystem` varchar(50) DEFAULT NULL,
  `LongTermEnvironmentExposure` varchar(50) DEFAULT NULL,
  `NaturalCatastrophyExposure` varchar(50) DEFAULT NULL,
  `MaritalStatus` varchar(50) DEFAULT NULL,
  `TypeofIdentityDocument` varchar(50) DEFAULT NULL,
  `IdentityDocumentNumber` varchar(50) DEFAULT NULL,
  `Race` varchar(50) DEFAULT NULL,
  `Tribe` varchar(50) DEFAULT NULL,
  `Clan` varchar(50) DEFAULT NULL,
  `Totem` varchar(50) DEFAULT NULL,
  `Nextofkin` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `AddressofNextofkin` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PatientNumber`),
  KEY `Identity Document Number` (`IdentityDocumentNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paitents`
--

LOCK TABLES `paitents` WRITE;
/*!40000 ALTER TABLE `paitents` DISABLE KEYS */;
INSERT INTO `paitents` VALUES (100,'Albert','Semakula','ABS','Barry','1952-12-12 00:00:00','55 Yrs','M','900571/24/2','Solwezi General Hospital','Africa','Southern','Zambia','Tropic of Capricorn','GMT+2','3,000 Metres','2008-03-22 00:00:00','1899-12-30 12:21:00','Tanzania','British/ Leicester','House Flies','Flu','Home Cooked','Tap water','Sewer system','Zambian','Cold Weather','Married','PP','PP Number','African','Lango','Okadameri','Duiker','Family','87 Bringhurst Rd. Leicester, LE3','87 Bringhurst Rd. Leicester, LE3'),(101,'Lilian','Otim','LMT','Mayanda','2005-02-16 00:00:00','3Yrs','F','712682/23/1','Akalo District Hospital','Africa','East','Uganda','Equator','GMT+3','4,000 Metres','2008-03-28 00:00:00','1899-12-30 18:27:00','Democratic Republic of Congo','Ugandan','Mosquitoes Anopheles','Measles','Home Cooked','Well Water','Pit latrine','Ugandan','Floods wind','Child','Mothers ID','NRC Number','African','Lango','Oyam','Elephant','Family','124 Kamanga Road Nsambya, Kampala, Uganda','124 Kamanga Road Nsambya, Kampala, Uganda'),(102,'Regina','Opio','ROP','Mumba','2008-04-01 00:00:00','1 Week','F','726354/21/2','Kidera General Hospital','Africa','East','Uganda','Equator','GMT+3','4,000 Metres','2008-04-06 00:00:00','1899-12-30 18:54:00','Kisumu','Ugandan','Mosquitoes Culex','Typhoid Fever','Breast Feeding','Breast Feeding','Napkins','Ugandan','Hurricane','Newborn','Mother PP','Mother PP Number','African','Soga','Ngoma','Eel','Mother','634 Matero Road, Mbale, Uganda','634 Matero Road, Mbale, Uganda'),(103,'Rachel','Okwir','ROM','Mutunda','1981-05-02 00:00:00','16Yrs','F','927616/12/1','Masaka Mission Hospital','Africa','East','Uganda','Equator','GMT+3','4,000 Metres','2008-03-29 00:00:00','1899-12-30 02:15:00','Mbale','Ugandan','Mosquitoes','Cholera','Market cooked','Market Tap','Pit Latrine','Ugandan','Drought','Single','Passport','PP Number','African','Gisu','Unknown','Unknown','Mother','246 Makerere Estates, Kampala, Uganda','246 Makerere Estates, Kampala, Uganda'),(104,'Ramdada','Banda','ROB','Obyara','1990-08-02 00:00:00','17Yrs','F','172652//23/1','Kamuli General Hospital','Africa','East','Uganda','Equator','GMT+3','5,500 Metres','2008-03-29 00:00:00','1899-12-30 17:37:00','Jinja','Ugandan','House Flies','Malaria Falciparum','Home cooked','Tap water','Sewer System','Ugandan','Floods','Single','PP','PP Number','African','Soga','Unknown','Unknown','Brother','1652 chainda Road, Bukoto Estates Kampala, Uganda','1652 chainda Road, Bukoto Estates Kampala, Uganda'),(105,'Kebby','Masasa','KAM','Agom','2008-04-02 00:00:00','1 Week','M','726534/24/2','Masindi District Hospital','Africa','East','Uganda','Equator','GMT+3','4,500 Metres','2008-04-06 00:00:00','1899-12-30 18:11:00','Mombasa','Ugandan','Mosquitoes','Trypanosomiasis','Breast Feeding','Breast Feeding','Napkins','Ugandan','Earthquke','Newborn','Mothers PP','Mother PP Number','African','Teso','Unknown','Unknown','Mother','532 Chawama Road, Lugogo, Kampala, Uganda','532 Chawama Road, Lugogo, Kampala, Uganda'),(106,'Fatima','Switzman','FSP','Palabana','1970-03-02 00:00:00','38Yrs','F','203389/28/1','Choma Rural Hospital','Africa','Souther','Zambia','Tropic of Capricon','GMT+2','3,000 Metres','2008-03-30 00:00:00','1899-12-30 05:42:00','Mpulungu','Zambian','Mosquitoes, House flies','Malaria, Cholera, Flu','Market Vented','Tap water, River, Well Protected','Septic Tank, Sewer, Pit Latrine','Zambian, Tanzanian','Floods','Devorced','NRC','NRC Number','African','Tonga','Unknown','Unknown','Son','217 Obote Road, Kamwala, Lusaka, Zambia','217 Obote Road, Kamwala, Lusaka, Zambia'),(107,'Febby','Palibe','KLP','Lishomwa','1946-03-02 00:00:00','52Yrs','F','262529/48/1','Chibwika District Hospital','Africa','Southern','Zambia','Tropic of Capricon','GMT+2','4,000 Metres','2008-04-04 00:00:00','1899-12-30 17:36:00','Dar Es Salam','Zambian','Mosquitoes, House flies','Malaria CQ resistant, Cholera','Road Side, Market, Restaurants','Tap Water, Wells','Sewer, Septic Tanks, Pit Latrines','Zambian','Drought','Married','PP','PP Number','African','Nyanja','Unknown','Unknown','Husband','785 chawama Road, Lusaka, Zambia','785 chawama Road, Lusaka, Zambia'),(108,'Daniela','Namutowe','DKP','Kapita','1969-03-02 00:00:00','38Yrs','F','282735/58/1','Nangoma Mission Hospital','Africa','Southern','Zambia','Tropic of Capricon','GMT+2','4,000 Metres','2008-04-05 00:00:00','1899-12-30 04:04:00','Mongu','Zambian','Mosquitoes, House flies','Typhus Fever','Home cooked, Market, Restaurants','Well water, Chlorinated, Tap water','Sewer, Septic Tank, pit latrine','Zambian','Floods','Married','Driving Licence','NRC Number','African','Namwanga','Kolwe','Monkey','Husband','285 Kampala Road, Kamwala, Lusaka, Zambia','285 Kampala Road, Kamwala, Lusaka, Zambia'),(109,'Euginia','Nasilele','EPN','Prisca','1972-03-02 00:00:00','35Yrs','F','282647/28/1','Mosi Otunya District Hospital','Africa','Southern','Zambia','Tropic of Capricon','GMT+2','4,000 Metres','2008-04-05 00:00:00','1899-12-30 04:30:00','Siavonga','Zambian','Mosquitoes, House flies','Malaria, TB, Cholera, Typhoid','Home cooked, Market, Restaurant','Well water, Boiled, River water, raw','Sewer, Septic Tank, Pit latrine','Zambian','Droughts','Married','NRC','NRC Number','African','Lozi','Unknown','Unknown','Husband','2 Kampala Road, Kamwala, Lusaka, Zambia','2 Kampala Road, Kamwala, Lusaka, Zambia'),(110,'Joseph','Kisonka','JPK','Polita','1968-03-02 00:00:00','40Yrs','M','214325/48/1','Chainama Provincial Hospital','Africa','Southern','Zambia','Tropic of Capricon','GMT+2','3,500 Metres','2008-04-05 00:00:00','1899-12-30 04:54:00','Democratic Republic of Congo','Zambian','Mosquitoes, House flies, Tse Tse flies, Myasis','Malaria, TB, Measles','Home cooked, Hospital Cooked','Tap Water','Sewer, Pit latrine','Zambian','Drought','Married','NRC','NRC Number','African','Lenje','Unknown','Unknown','Wife','231 Obote Road, Kamwala, Lusaka, Zambia','231 Obote Road, Kamwal, Lusaka, Zambia'),(111,'Rachel','Namatovu','RPN','Pastela','1974-03-02 00:00:00','34Yrs','F','258742/88/1','Ndejje Specialist Hospital','Africa','Southern','Zambia','Tropic of Capricon','GMT+2','4,000 Metres','2008-04-05 00:00:00','1899-12-30 18:51:00','Uganda','Zambian','Mosquitoes, House flies','Malaria Malariae','Home cooked, Hotel, Canteen','Tap water, Boiled','Sewer System','Zambian','Rain','Married','NRC','NRC Number','African','Chewa','Unknown','Unknown','Husband','251 Kampala Road, kamwala, Lusaka, Zambia','251 Kampala Road, kamwala, Lusaka, Zambia'),(112,'Regina','Nakasize','RNK','Kasanda','1974-03-02 00:00:00','38Yrs','F','172630/28/1','Nkuluashi District Hospital','Africa','Southern','Zambia','Tropic of Capricon','GMT+2','3,500 Metres','2008-04-05 00:00:00','1899-12-30 19:08:00','Zimbabwe','Zambian','Mosquitoes, Tse Tse flies','Malaria Vivax','Home cooked','Tap water, Chlorinated','Sewer System','Zambian','Snowfall','Widower','NRC','NRC Number','African','Chewa','Unknown','Unknown','Father','356 Oparacha Road, Kamwala, Lusaka, Zambia','356 Oparacha Road, Kamwala, Lusaka, Zambia'),(113,'Fantom','Musoke','FMP','Pampini','1985-02-02 00:00:00','32Yrs','M','250542/18/1','Chimwemwe Rural Hospital','Africa','Southern','Zambia','Tropic of Capricon','GMT+2','4,000 Metres','2008-04-06 00:00:00','1899-12-30 01:33:00','Malawi','Zambian','Mosquitoes, House flies','Malaria, Tuberculosis','Home cooked, Hotel cooked, Market','Tap Water, Boiled','Sewer System','Zambian','Wind High','Single','NRC','NRC Number','African','Chewa','Unknown','Unknown','Father','926 Kampala Road, Kamwala, Lusaka, Zambia','926 Kampala Road, Kamwala, Lusaka, Zambia'),(114,'Moses','Siapenga','MSR','Renamo','1974-02-02 00:00:00','34Yrs','M','250716/98/1','Bundibugyo Rural Hospital','Africa','Southern','Zambia','Tropic of Caprocon','GMT+2','4,000 Metres','2008-04-06 00:00:00','1899-12-30 01:51:00','Tanzania','Zambian','Mosquitoes,Tse Tse flies','Malaria, Tuberculosis, Cholera','Home cooked, Road Side market','Tap Water, Chlorinated','Sewer System','Zambian','Drought','Single','NRC','NRC, PP, DL Number','African','Ngoni','Unknown','Duiker','Mother','287 Kampala Road, Chingola, Zambia','287 Kampala Road, Chingola, Zambia');
/*!40000 ALTER TABLE `paitents` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-28 11:49:29
