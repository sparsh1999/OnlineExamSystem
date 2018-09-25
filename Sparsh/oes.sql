/*
SQLyog Job Agent Version 7.02 Copyright(c) Webyog Softworks Pvt. Ltd. All Rights Reserved.


MySQL - 5.5.5-10.1.34-MariaDB : Database - oes
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`oes` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `oes`;

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `qno` int(3) NOT NULL DEFAULT '0',
  `question` varchar(50) NOT NULL,
  `option1` varchar(50) NOT NULL,
  `option2` varchar(50) NOT NULL,
  `option3` varchar(50) NOT NULL,
  `option4` varchar(50) NOT NULL,
  `answer` int(2) NOT NULL,
  `examid` int(2) NOT NULL DEFAULT '0',
  `qid` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `questions` */

insert  into `questions` values (1,'which is a type of int','char','longint','double','none of above',2,1,2),(2,'Who discovered C','Danis Ritchies','Mark Jokovich','Abshishek Jain','Bhai Ne',1,1,3),(3,'Which os supports C','linux','windows','fedora','all of above',4,1,4),(4,'C is a ','High Level Language','Low Level Language','Both 1 and 2','None',3,1,5),(5,'Variable is a ','location in CPU register','location in memory','Both 1 and 2','location in compiler execution environment',3,1,6),(6,'Where c was invented','Ghar par','At & T Labs','Jaipur','Dennis Ritchie ke Godam me',2,1,7),(7,'Which symbol terminated statement in c',';','\'',',','.',1,1,8),(8,'What is size of int','4','16','2','Compiler Specific',4,1,9),(9,'C is a Successor of ','C++','B','B++','AB',2,1,10),(10,'Which OS was completely built on C','Windows','Linux','Redhat','SunSolaris',2,1,11);

/*Table structure for table `report` */

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `reportid` int(3) NOT NULL AUTO_INCREMENT,
  `studentid` int(3) NOT NULL,
  `date` varchar(30) NOT NULL,
  `examid` int(3) NOT NULL,
  `marks` int(3) NOT NULL,
  `remark` varchar(5) NOT NULL,
  PRIMARY KEY (`reportid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `report` */

insert  into `report` values (1,2,'hello',1,23,'pass'),(2,3,'good',1,23,'pass'),(3,3,'now',2,34,'fail'),(4,3,'now',2,34,'pass'),(5,2,'2018-09-25T12:42:05.366',1,5,'fail');

/*Table structure for table `udetails` */

DROP TABLE IF EXISTS `udetails`;

CREATE TABLE `udetails` (
  `uid` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `udetails` */

insert  into `udetails` values (1,'admin','admin123','admin@admin.com'),(2,'sparsh','sdf23','sparsh@1.com'),(3,'utkarsh','sdf23','ukki@ukki.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
