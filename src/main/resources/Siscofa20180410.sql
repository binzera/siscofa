CREATE DATABASE  IF NOT EXISTS `siscofa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `siscofa`;
-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: siscofa
-- ------------------------------------------------------
-- Server version	5.6.22-71.0

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
-- Table structure for table `Configuracao`
--

DROP TABLE IF EXISTS `Configuracao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Configuracao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dt_ultima_sincronizacao` datetime DEFAULT NULL,
  `id_app` int(11) DEFAULT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Configuracao`
--

LOCK TABLES `Configuracao` WRITE;
/*!40000 ALTER TABLE `Configuracao` DISABLE KEYS */;
/*!40000 ALTER TABLE `Configuracao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `despesa`
--

DROP TABLE IF EXISTS `despesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `despesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `excluido` int(11) NOT NULL,
  `updated` datetime DEFAULT NULL,
  `valor` double NOT NULL,
  `fazenda_id` int(11) DEFAULT NULL,
  `tipo_despesa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tb5fb8xvneqjo5nwj0bdeia77` (`fazenda_id`),
  KEY `FK_4wffih4kpcf85fhyd80j85ox7` (`tipo_despesa_id`),
  CONSTRAINT `FK_4wffih4kpcf85fhyd80j85ox7` FOREIGN KEY (`tipo_despesa_id`) REFERENCES `tipo_despesa` (`id`),
  CONSTRAINT `FK_tb5fb8xvneqjo5nwj0bdeia77` FOREIGN KEY (`fazenda_id`) REFERENCES `fazenda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despesa`
--

LOCK TABLES `despesa` WRITE;
/*!40000 ALTER TABLE `despesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `despesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fazenda`
--

DROP TABLE IF EXISTS `fazenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fazenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `excluido` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `qtd_alqueires` int(11) DEFAULT NULL,
  `total_gado_atual` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3r64fhbjvapelxcyxsjg31761` (`usuario_id`),
  CONSTRAINT `FK_3r64fhbjvapelxcyxsjg31761` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fazenda`
--

LOCK TABLES `fazenda` WRITE;
/*!40000 ALTER TABLE `fazenda` DISABLE KEYS */;
INSERT INTO `fazenda` VALUES (1,'2018-04-10 18:29:22','2018-04-10 18:29:22',0,'Fazenda Jordenia',160,1500,1),(2,'2018-04-10 18:29:44','2018-04-10 18:29:44',0,'Fazenda Cedro',236,1200,1),(3,'2018-04-10 18:29:56','2018-04-10 18:29:56',0,'Fazenda Zezinho',120,800,2),(4,'2018-04-10 18:30:17','2018-04-10 18:30:17',0,'Fazenda Joaozinho',100,600,3);
/*!40000 ALTER TABLE `fazenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `salario` float NOT NULL,
  `fazenda_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gr64g5rpk1c1d7ae6eff9cxbd` (`fazenda_id`),
  CONSTRAINT `FK_gr64g5rpk1c1d7ae6eff9cxbd` FOREIGN KEY (`fazenda_id`) REFERENCES `fazenda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Sinval',1600,1),(2,'Ajudante',800,1),(3,'Sué',1800,2),(4,'Baiano',1000,2),(5,'Flavio',1300,3);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idade_gado`
--

DROP TABLE IF EXISTS `idade_gado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idade_gado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idade_gado`
--

LOCK TABLES `idade_gado` WRITE;
/*!40000 ALTER TABLE `idade_gado` DISABLE KEYS */;
INSERT INTO `idade_gado` VALUES (1,'0 a 6 meses'),(2,'6 a 12 meses'),(3,'12 a 18 meses'),(4,'18 a 24 meses');
/*!40000 ALTER TABLE `idade_gado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maquina`
--

DROP TABLE IF EXISTS `maquina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maquina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `valor` double NOT NULL,
  `fazenda_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dqtpjs8selac3pvuwnmm59tqd` (`fazenda_id`),
  CONSTRAINT `FK_dqtpjs8selac3pvuwnmm59tqd` FOREIGN KEY (`fazenda_id`) REFERENCES `fazenda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquina`
--

LOCK TABLES `maquina` WRITE;
/*!40000 ALTER TABLE `maquina` DISABLE KEYS */;
/*!40000 ALTER TABLE `maquina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacao_gado`
--

DROP TABLE IF EXISTS `movimentacao_gado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimentacao_gado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `data` date DEFAULT NULL,
  `excluido` int(11) NOT NULL,
  `peso` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `valor` double NOT NULL,
  `fazenda_id` int(11) DEFAULT NULL,
  `idade_gado_id` int(11) DEFAULT NULL,
  `tipo_movimentacao_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9f88v1ejtfnn2xt12q0a3bjdt` (`fazenda_id`),
  KEY `FK_qijfxy62ka6igxmjav66i1eps` (`idade_gado_id`),
  KEY `FK_qxu2vvr3lr1u8nbhfbx58herg` (`tipo_movimentacao_id`),
  CONSTRAINT `FK_9f88v1ejtfnn2xt12q0a3bjdt` FOREIGN KEY (`fazenda_id`) REFERENCES `fazenda` (`id`),
  CONSTRAINT `FK_qijfxy62ka6igxmjav66i1eps` FOREIGN KEY (`idade_gado_id`) REFERENCES `idade_gado` (`id`),
  CONSTRAINT `FK_qxu2vvr3lr1u8nbhfbx58herg` FOREIGN KEY (`tipo_movimentacao_id`) REFERENCES `tipo_movimentacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacao_gado`
--

LOCK TABLES `movimentacao_gado` WRITE;
/*!40000 ALTER TABLE `movimentacao_gado` DISABLE KEYS */;
INSERT INTO `movimentacao_gado` VALUES (1,'2018-04-10 18:54:21','2018-04-10 18:54:21','2018-04-09',0,8,300,'M',1100,1,3,1),(2,'2018-04-10 18:57:13','2018-04-10 18:57:13','2018-04-09',0,12,180,'M',1800,2,3,2),(3,'2018-04-10 18:57:48','2018-04-10 18:57:48','2018-04-09',0,6,80,'F',780,1,1,3),(4,'2018-04-10 18:59:47','2018-04-10 18:59:47','2018-04-09',0,14,300,'V',2100,3,4,2);
/*!40000 ALTER TABLE `movimentacao_gado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_despesa`
--

DROP TABLE IF EXISTS `tipo_despesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_despesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_despesa`
--

LOCK TABLES `tipo_despesa` WRITE;
/*!40000 ALTER TABLE `tipo_despesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_despesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_movimentacao`
--

DROP TABLE IF EXISTS `tipo_movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_movimentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_movimentacao`
--

LOCK TABLES `tipo_movimentacao` WRITE;
/*!40000 ALTER TABLE `tipo_movimentacao` DISABLE KEYS */;
INSERT INTO `tipo_movimentacao` VALUES (1,'Compra'),(2,'Venda'),(3,'Ferra'),(4,'Morte'),(5,NULL);
/*!40000 ALTER TABLE `tipo_movimentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'2018-04-09 18:15:47','2018-04-09 18:15:47','glaubert.schult@gmail.com','Glaubert','123456','zeh'),(2,'2018-04-09 18:16:10','2018-04-09 18:16:10','joao@gmail.com','João','123456','joao'),(3,'2018-04-09 18:17:09','2018-04-09 18:17:09','pedro@gmail.com','Pedro','123456','pedro');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-10 19:04:45
