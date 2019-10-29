-- run these one by one      , Author: Sharad Raj, GIHSM, Lucknow https://linkedin.com/in/srsmaurya

CREATE DATABASE `mynote`;

USE `mynote`;

CREATE TABLE `notes` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` mediumtext NOT NULL,
  `content` longtext,
  PRIMARY KEY (`note_id`),
  UNIQUE KEY `note_id_UNIQUE` (`note_id`)
);
