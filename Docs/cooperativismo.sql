CREATE DATABASE  IF NOT EXISTS `cooperativismo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cooperativismo`;


CREATE TABLE `associado` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;




CREATE TABLE `pauta` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `tempo` int(11) NOT NULL DEFAULT '1',
  `data_inicio` datetime DEFAULT NULL,
  `resultado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;



CREATE TABLE `voto` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `associado_id` int(10) unsigned DEFAULT NULL,
  `pauta_id` int(10) unsigned DEFAULT NULL,
  `voto` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


