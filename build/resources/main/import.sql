/*
 * Copyright   : KOMA-Network (Indonesia IoT Club)
 * Create by   : Yan Yan Purdiansah
 * Create date : 21/06/2020
 * Link        : https://github.com/yypurdi/koma-auc
 * Description : This is the MSB Connector for Authentication & Control Inter Domain in KOMA Network
 *               This module is implemented in MicroSB side for Public/Private Environment
 */

create database if not exists `microsb_node`;

USE `microsb_node`;

/*Table structure for table `msb_account` */

DROP TABLE IF EXISTS `msb_account`;

CREATE TABLE `msb_account` (
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `account` varchar(64) default NULL,
  `email` varchar(100) default NULL,
  `phone` varchar(64) default NULL,
  `mobile` varchar(64) default NULL,
  `enabled` tinyint(1) default NULL,
  `token` varchar(64) NOT NULL,
  PRIMARY KEY  (`username`),
  KEY `FK_app_users` (`token`),
  KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_account` */

insert  into `msb_account`(`username`,`password`,`account`,`email`,`phone`,`mobile`,`enabled`,`token`) values ('6210001','8725c6f3e548f02262db02577e385aa3','6210001','6210001@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210002','8725c6f3e548f02262db02577e385aa3','6210002','6210002@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210003','8725c6f3e548f02262db02577e385aa3','6210003','6210003@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210004','8725c6f3e548f02262db02577e385aa3','6210004','6210004@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210005','8725c6f3e548f02262db02577e385aa3','6210005','6210005@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210006','8725c6f3e548f02262db02577e385aa3','6210006','6210006@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210007','8725c6f3e548f02262db02577e385aa3','6210007','6210007@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210008','8725c6f3e548f02262db02577e385aa3','6210008','6210008@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210009','8725c6f3e548f02262db02577e385aa3','6210009','6210009@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210010','8725c6f3e548f02262db02577e385aa3','6210010','6210010@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210011','8725c6f3e548f02262db02577e385aa3','6210011','6210011@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210012','8725c6f3e548f02262db02577e385aa3','6210012','6210012@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210013','8725c6f3e548f02262db02577e385aa3','6210013','6210013@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210014','8725c6f3e548f02262db02577e385aa3','6210014','6210014@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('6210015','8725c6f3e548f02262db02577e385aa3','6210015','6210015@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('admin','8725c6f3e548f02262db02577e385aa3','admin','admin@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i'),('user','8725c6f3e548f02262db02577e385aa3','User','user@domain.com',NULL,NULL,1,'wmQ45QjYpC38W3i');

/*Table structure for table `msb_affiliation` */

DROP TABLE IF EXISTS `msb_affiliation`;

CREATE TABLE `msb_affiliation` (
  `affiliation` bigint(20) NOT NULL,
  `description` varchar(100) default NULL,
  PRIMARY KEY  (`affiliation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_affiliation` */

insert  into `msb_affiliation`(`affiliation`,`description`) values (10,'Owner'),(20,'Administrator'),(30,'Moderator');

/*Table structure for table `msb_authorities` */

DROP TABLE IF EXISTS `msb_authorities`;

CREATE TABLE `msb_authorities` (
  `username` varchar(64) NOT NULL,
  `authority` varchar(64) default NULL,
  PRIMARY KEY  (`username`),
  CONSTRAINT `FK_app_authorities` FOREIGN KEY (`username`) REFERENCES `msb_account` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_authorities` */

insert  into `msb_authorities`(`username`,`authority`) values ('admin','ROLE_ADMIN'),('user','ROLE_USER');

/*Table structure for table `msb_menus` */

DROP TABLE IF EXISTS `msb_menus`;

CREATE TABLE `msb_menus` (
  `name` varchar(64) NOT NULL,
  `link` varchar(64) NOT NULL,
  `display` varchar(64) NOT NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_menus` */

insert  into `msb_menus`(`name`,`link`,`display`) values ('appGroups','searchAppGroups','AppGroups'),('appUsers','searchAppUsers','AppUsers');

/*Table structure for table `msb_mucaffiliation` */

DROP TABLE IF EXISTS `msb_mucaffiliation`;

CREATE TABLE `msb_mucaffiliation` (
  `roomID` bigint(20) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `affiliation` bigint(4) NOT NULL,
  PRIMARY KEY  (`roomID`,`affiliation`),
  KEY `roomID` (`roomID`),
  KEY `affiliation` (`affiliation`),
  CONSTRAINT `FK_msb_mucaffiliation_1` FOREIGN KEY (`roomID`) REFERENCES `msb_mucroom` (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_mucaffiliation` */

/*Table structure for table `msb_mucmember` */

DROP TABLE IF EXISTS `msb_mucmember`;

CREATE TABLE `msb_mucmember` (
  `roomID` bigint(20) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `subscriber` varchar(64) NOT NULL,
  `nickname` varchar(255) default NULL,
  `firstName` varchar(100) default NULL,
  `lastName` varchar(100) default NULL,
  `url` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `faqentry` varchar(100) default NULL,
  PRIMARY KEY  (`roomID`,`jid`(70)),
  UNIQUE KEY `roomID` (`roomID`),
  UNIQUE KEY `subscriber` (`subscriber`),
  CONSTRAINT `FK_msb_mucmember_2` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`),
  CONSTRAINT `FK_msb_mucmember` FOREIGN KEY (`roomID`) REFERENCES `msb_mucroom` (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_mucmember` */

/*Table structure for table `msb_mucroom` */

DROP TABLE IF EXISTS `msb_mucroom`;

CREATE TABLE `msb_mucroom` (
  `roomID` bigint(20) NOT NULL auto_increment,
  `serviceID` bigint(20) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  `name` varchar(50) NOT NULL,
  `naturalName` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `lockedDate` char(15) NOT NULL,
  `emptyDate` char(15) default NULL,
  `canChangeSubject` tinyint(4) NOT NULL default '0',
  `maxUsers` int(11) NOT NULL default '100',
  `publicRoom` tinyint(4) NOT NULL default '1',
  `moderated` tinyint(4) NOT NULL default '0',
  `membersOnly` tinyint(4) NOT NULL default '0',
  `canInvite` tinyint(4) NOT NULL default '0',
  `roomPassword` varchar(50) default NULL,
  `canDiscoverJID` tinyint(4) NOT NULL default '1',
  `logEnabled` tinyint(4) NOT NULL default '0',
  `subject` varchar(100) default NULL,
  `rolesToBroadcast` tinyint(4) NOT NULL default '7',
  `useReservedNick` tinyint(4) NOT NULL default '0',
  `canChangeNick` tinyint(4) NOT NULL default '1',
  `canRegister` tinyint(4) NOT NULL default '1',
  PRIMARY KEY  (`serviceID`,`roomID`),
  KEY `ofMucRoom_roomid_idx` (`roomID`),
  KEY `ofMucRoom_serviceid_idx` (`serviceID`),
  CONSTRAINT `FK_msb_mucroom` FOREIGN KEY (`serviceID`) REFERENCES `msb_mucservice` (`serviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

/*Data for the table `msb_mucroom` */

insert  into `msb_mucroom`(`roomID`,`serviceID`,`creationDate`,`modificationDate`,`name`,`naturalName`,`description`,`lockedDate`,`emptyDate`,`canChangeSubject`,`maxUsers`,`publicRoom`,`moderated`,`membersOnly`,`canInvite`,`roomPassword`,`canDiscoverJID`,`logEnabled`,`subject`,`rolesToBroadcast`,`useReservedNick`,`canChangeNick`,`canRegister`) values (1,1,'001475729743086','001475729743328','00ecb11','Nanggroe Aceh Darussalam (NAD)','Nanggroe Aceh Darussalam (NAD)','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Nanggroe Aceh Darussalam (NAD)',7,0,1,1),(2,1,'001475729743086','001475729743328','00ecb12','Sumatera Utara','Sumatera Utara','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sumatera Utara',7,0,1,1),(3,1,'001475729743086','001475729743328','00ecb13','Sumatera Barat','Sumatera Barat','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sumatera Barat',7,0,1,1),(4,1,'001475729743086','001475729743328','00ecb14','Riau','Riau','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Riau',7,0,1,1),(5,1,'001475729743086','001475729743328','00ecb15','Jambi','Jambi','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Jambi',7,0,1,1),(6,1,'001475729743086','001475729743328','00ecb16','Sumatera Selatan','Sumatera Selatan','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sumatera Selatan',7,0,1,1),(7,1,'001475729743086','001475729743328','00ecb17','Bengkulu','Bengkulu','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Bengkulu',7,0,1,1),(8,1,'001475729743086','001475729743328','00ecb18','Lampung','Lampung','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Lampung',7,0,1,1),(9,1,'001475729743086','001475729743328','00ecb19','Bangka Belitung','Bangka Belitung','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Bangka Belitung',7,0,1,1),(10,1,'001475729743086','001475729743328','00ecb21','Kepulauan Riau','Kepulauan Riau','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Kepulauan Riau',7,0,1,1),(11,1,'001475729743086','001475729743328','00ecb31','DKI Jakarta','DKI Jakarta','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'DKI Jakarta',7,0,1,1),(12,1,'001475729743086','001475729743328','00ecb32','Jawa Barat','Jawa Barat','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Jawa Barat',7,0,1,1),(13,1,'001475729743086','001475729743328','00ecb33','Jawa Tengah','Jawa Tengah','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Jawa Tengah',7,0,1,1),(14,1,'001475729743086','001475729743328','00ecb34','DI Yogyakarta','DI Yogyakarta','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'DI Yogyakarta',7,0,1,1),(15,1,'001475729743086','001475729743328','00ecb35','Jawa Timur','Jawa Timur','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Jawa Timur',7,0,1,1),(16,1,'001475729743086','001475729743328','00ecb36','Banten','Banten','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Banten',7,0,1,1),(17,1,'001475729743086','001475729743328','00ecb51','Bali','Bali','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Bali',7,0,1,1),(18,1,'001475729743086','001475729743328','00ecb52','Nusa Tenggara Barat (NTB)','Nusa Tenggara Barat (NTB)','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Nusa Tenggara Barat (NTB)',7,0,1,1),(19,1,'001475729743086','001475729743328','00ecb53','Nusa Tenggara Timur (NTT)','Nusa Tenggara Timur (NTT)','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Nusa Tenggara Timur (NTT)',7,0,1,1),(20,1,'001475729743086','001475729743328','00ecb61','Kalimantan Barat','Kalimantan Barat','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Kalimantan Barat',7,0,1,1),(21,1,'001475729743086','001475729743328','00ecb62','Kalimantan Tengah','Kalimantan Tengah','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Kalimantan Tengah',7,0,1,1),(22,1,'001475729743086','001475729743328','00ecb63','Kalimantan Selatan','Kalimantan Selatan','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Kalimantan Selatan',7,0,1,1),(23,1,'001475729743086','001475729743328','00ecb64','Kalimantan Timur','Kalimantan Timur','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Kalimantan Timur',7,0,1,1),(24,1,'001475729743086','001475729743328','00ecb65','Kalimantan Utara','Kalimantan Utara','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Kalimantan Utara',7,0,1,1),(25,1,'001475729743086','001475729743328','00ecb71','Sulawesi Utara','Sulawesi Utara','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sulawesi Utara',7,0,1,1),(26,1,'001475729743086','001475729743328','00ecb72','Sulawesi Tengah','Sulawesi Tengah','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sulawesi Tengah',7,0,1,1),(27,1,'001475729743086','001475729743328','00ecb73','Sulawesi Selatan','Sulawesi Selatan','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sulawesi Selatan',7,0,1,1),(28,1,'001475729743086','001475729743328','00ecb74','Sulawesi Tenggara','Sulawesi Tenggara','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sulawesi Tenggara',7,0,1,1),(29,1,'001475729743086','001475729743328','00ecb75','Gorontalo','Gorontalo','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Gorontalo',7,0,1,1),(30,1,'001475729743086','001475729743328','00ecb76','Sulawesi Barat','Sulawesi Barat','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Sulawesi Barat',7,0,1,1),(31,1,'001475729743086','001475729743328','00ecb81','Maluku','Maluku','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Maluku',7,0,1,1),(32,1,'001475729743086','001475729743328','00ecb82','Maluku Utara','Maluku Utara','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Maluku Utara',7,0,1,1),(33,1,'001475729743086','001475729743328','00ecb91','Papua','Papua','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Papua',7,0,1,1),(34,1,'001475729743086','001475729743328','00ecb92','Papua Barat','Papua Barat','000000000000000','001475995518863',0,100,1,0,0,0,'password',1,0,'Papua Barat',7,0,1,1);

/*Table structure for table `msb_mucroomprop` */

DROP TABLE IF EXISTS `msb_mucroomprop`;

CREATE TABLE `msb_mucroomprop` (
  `roomID` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY  (`roomID`,`name`),
  CONSTRAINT `FK_msb_mucroomprop` FOREIGN KEY (`roomID`) REFERENCES `msb_mucroom` (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_mucroomprop` */

/*Table structure for table `msb_mucservice` */

DROP TABLE IF EXISTS `msb_mucservice`;

CREATE TABLE `msb_mucservice` (
  `serviceID` bigint(20) NOT NULL auto_increment,
  `domain` varchar(255) NOT NULL,
  `subdomain` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `isHidden` tinyint(4) NOT NULL,
  PRIMARY KEY  (`serviceID`),
  KEY `ofMucService_serviceid_idx` (`serviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `msb_mucservice` */

insert  into `msb_mucservice`(`serviceID`,`domain`,`subdomain`,`description`,`isHidden`) values (1,'domain.com','province','Conference',0);

/*Table structure for table `msb_mucserviceprop` */

DROP TABLE IF EXISTS `msb_mucserviceprop`;

CREATE TABLE `msb_mucserviceprop` (
  `serviceID` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY  (`serviceID`,`name`),
  CONSTRAINT `FK_msb_mucserviceprop` FOREIGN KEY (`serviceID`) REFERENCES `msb_mucservice` (`serviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_mucserviceprop` */

/*Table structure for table `msb_offline` */

DROP TABLE IF EXISTS `msb_offline`;

CREATE TABLE `msb_offline` (
  `subscriber` varchar(64) NOT NULL,
  `messageID` varchar(20) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `messageSize` int(11) NOT NULL,
  `stanza` text NOT NULL,
  PRIMARY KEY  (`subscriber`,`messageID`,`creationDate`),
  CONSTRAINT `FK_msb_offline` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_offline` */

/*Table structure for table `msb_persistent_logins` */

DROP TABLE IF EXISTS `msb_persistent_logins`;

CREATE TABLE `msb_persistent_logins` (
  `username` varchar(64) default NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) default NULL,
  `last_used` datetime NOT NULL,
  PRIMARY KEY  (`series`,`last_used`),
  KEY `FK_app_persistent_logins` (`username`),
  CONSTRAINT `FK_app_persistent_logins` FOREIGN KEY (`username`) REFERENCES `msb_account` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_persistent_logins` */

insert  into `msb_persistent_logins`(`username`,`series`,`token`,`last_used`) values ('admin','ao-Gkqw9W8zcIohu_2pFKFCt1pjrTTcB','','2020-07-01 06:44:06'),('admin','D2Cg5zfWAIOopZZLfeD0B8tkF-AcEQmn','HO2-8F1FsFO5UDK1AAAQ','2020-06-30 07:12:49'),('admin','kXb5qsL8hjHRzTyoKtqQ4A6IvLbrl8YY','','2020-06-30 11:58:10'),('admin','NcAo7Y1zKI1vlfFRbYGQ3O4kl1FLYWQs','','2020-07-01 06:18:37'),('admin','U3GxUHfVfL7DsnspqX9fOUJkIMLZwuJ6','','2020-07-01 07:09:41'),('admin','uAp4fGroByh2eicVx9MeTL4EVTPZzTvt','','2020-07-01 06:48:48');

/*Table structure for table `msb_presence` */

DROP TABLE IF EXISTS `msb_presence`;

CREATE TABLE `msb_presence` (
  `subscriber` varchar(64) NOT NULL,
  `offlinePresence` varchar(200) NOT NULL,
  `offlineDate` char(15) NOT NULL,
  PRIMARY KEY  (`subscriber`,`offlinePresence`),
  CONSTRAINT `FK_msb_presence` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_presence` */

insert  into `msb_presence`(`subscriber`,`offlinePresence`,`offlineDate`) values ('6010009','<presence xmlns=\"jabber:client\" from=\"admin@msb_it.com\" id=\"Ipxn7-86\" to=\"6010009@msb_it.com\" type=\"unsubscribed\"/>','020190412171742');

/*Table structure for table `msb_property` */

DROP TABLE IF EXISTS `msb_property`;

CREATE TABLE `msb_property` (
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_property` */

insert  into `msb_property`(`name`,`propValue`) values ('micro.service.balancer.number','10'),('queue.balancer.dealer','tcp://localhsot:6001'),('queue.balancer.router','tcp://localhost:6000'),('queue.cache.dealer','tcp://localhost:6007'),('queue.cache.router','tcp://localhost:6006'),('queue.proxy.dealer','tcp://localhost:6005'),('queue.proxy.router','tcp://localhost:6004'),('queue.publisher.pubsub','tcp://localhost:6003'),('queue.publisher.puller','tcp://localhost:6002'),('server.domain','iiot-club.com'),('server.mqtt.host','localhost'),('server.mqtt.port','1883'),('server.mqtt.protocol','tcp'),('server.sip.host','localhost'),('server.sip.port','5060'),('server.sip.protocol','udp'),('server.xmpp.host','localhost'),('server.xmpp.port','5222'),('server.xmpp.protocol','tcp');

/*Table structure for table `msb_pubsub` */

DROP TABLE IF EXISTS `msb_pubsub`;

CREATE TABLE `msb_pubsub` (
  `serviceID` varchar(100) NOT NULL,
  `protocol` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY  (`serviceID`,`protocol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_pubsub` */

insert  into `msb_pubsub`(`serviceID`,`protocol`,`description`) values ('MQTT','MQTT3','MQTT Protocol version 3'),('XMPP','XMPP3','XMPP Protocol version 3'),('ZMQ','ZeroMQ','ZeroMQ Protocol verion 5');

/*Table structure for table `msb_pubsubaffiliation` */

DROP TABLE IF EXISTS `msb_pubsubaffiliation`;

CREATE TABLE `msb_pubsubaffiliation` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `affiliation` bigint(20) NOT NULL,
  PRIMARY KEY  (`serviceID`,`nodeID`,`jid`(70)),
  KEY `serviceID` (`serviceID`),
  CONSTRAINT `FK_msb_pubsubaffiliation` FOREIGN KEY (`serviceID`, `nodeID`) REFERENCES `msb_pubsubnode` (`serviceID`, `nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_pubsubaffiliation` */

/*Table structure for table `msb_pubsubitem` */

DROP TABLE IF EXISTS `msb_pubsubitem`;

CREATE TABLE `msb_pubsubitem` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `payload` mediumtext,
  PRIMARY KEY  (`serviceID`,`nodeID`,`id`),
  CONSTRAINT `FK_msb_pubsubitem` FOREIGN KEY (`serviceID`, `nodeID`) REFERENCES `msb_pubsubnode` (`serviceID`, `nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_pubsubitem` */

/*Table structure for table `msb_pubsubnode` */

DROP TABLE IF EXISTS `msb_pubsubnode`;

CREATE TABLE `msb_pubsubnode` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `leaf` tinyint(4) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  `parent` varchar(100) default NULL,
  `deliverPayloads` tinyint(4) NOT NULL,
  `maxPayloadSize` int(11) default NULL,
  `persistItems` tinyint(4) default NULL,
  `maxItems` int(11) default NULL,
  `notifyConfigChanges` tinyint(4) NOT NULL,
  `notifyDelete` tinyint(4) NOT NULL,
  `notifyRetract` tinyint(4) NOT NULL,
  `presenceBased` tinyint(4) NOT NULL,
  `sendItemSubscribe` tinyint(4) NOT NULL,
  `publisherModel` varchar(15) NOT NULL,
  `subscriptionEnabled` tinyint(4) NOT NULL,
  `configSubscription` tinyint(4) NOT NULL,
  `accessModel` varchar(10) NOT NULL,
  `payloadType` varchar(100) default NULL,
  `bodyXSLT` varchar(100) default NULL,
  `dataformXSLT` varchar(100) default NULL,
  `creator` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `language` varchar(255) default NULL,
  `name` varchar(50) default NULL,
  `replyPolicy` varchar(15) default NULL,
  `associationPolicy` varchar(15) default NULL,
  `maxLeafNodes` int(11) default NULL,
  PRIMARY KEY  (`serviceID`,`nodeID`),
  CONSTRAINT `FK_msb_pubsubnode` FOREIGN KEY (`serviceID`) REFERENCES `msb_pubsub` (`serviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_pubsubnode` */

/*Table structure for table `msb_pubsubnodegroups` */

DROP TABLE IF EXISTS `msb_pubsubnodegroups`;

CREATE TABLE `msb_pubsubnodegroups` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `rosterGroup` varchar(100) NOT NULL,
  PRIMARY KEY  (`serviceID`,`nodeID`),
  KEY `ofPubsubNodeGroups_idx` (`serviceID`,`nodeID`),
  CONSTRAINT `FK_msb_pubsubnodegroups` FOREIGN KEY (`serviceID`, `nodeID`) REFERENCES `msb_pubsubnode` (`serviceID`, `nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_pubsubnodegroups` */

/*Table structure for table `msb_pubsubsubscriber` */

DROP TABLE IF EXISTS `msb_pubsubsubscriber`;

CREATE TABLE `msb_pubsubsubscriber` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `associationType` varchar(20) NOT NULL,
  PRIMARY KEY  (`serviceID`,`nodeID`,`jid`(70)),
  CONSTRAINT `FK_msb_pubsubsubscriber` FOREIGN KEY (`serviceID`, `nodeID`) REFERENCES `msb_pubsubnode` (`serviceID`, `nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_pubsubsubscriber` */

/*Table structure for table `msb_pubsubsubscription` */

DROP TABLE IF EXISTS `msb_pubsubsubscription`;

CREATE TABLE `msb_pubsubsubscription` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `state` varchar(15) NOT NULL,
  `deliver` tinyint(4) NOT NULL,
  `digest` tinyint(4) NOT NULL,
  `digest_frequency` int(11) NOT NULL,
  `expire` char(15) default NULL,
  `includeBody` tinyint(4) NOT NULL,
  `showValues` varchar(30) default NULL,
  `subscriptionType` varchar(10) NOT NULL,
  `subscriptionDepth` tinyint(4) NOT NULL,
  `keyword` varchar(200) default NULL,
  PRIMARY KEY  (`serviceID`,`nodeID`,`id`),
  CONSTRAINT `FK_msb_pubsubsubscription` FOREIGN KEY (`serviceID`, `nodeID`) REFERENCES `msb_pubsubnode` (`serviceID`, `nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_pubsubsubscription` */

/*Table structure for table `msb_remoteserver` */

DROP TABLE IF EXISTS `msb_remoteserver`;

CREATE TABLE `msb_remoteserver` (
  `xmppDomain` varchar(255) NOT NULL,
  `remoteAddress` varchar(255) default NULL,
  `remotePort` int(11) default NULL,
  `user` varchar(40) default NULL,
  `password` varchar(40) default NULL,
  `permission` varchar(10) NOT NULL,
  PRIMARY KEY  (`xmppDomain`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_remoteserver` */

/*Table structure for table `msb_revenue` */

DROP TABLE IF EXISTS `msb_revenue`;

CREATE TABLE `msb_revenue` (
  `subscriber` varchar(64) NOT NULL,
  `account` varchar(64) NOT NULL,
  `from` varchar(100) NOT NULL,
  `to` varchar(100) default NULL,
  `debit` double NOT NULL default '0',
  `credit` double default '0',
  `description` text,
  `activity` varchar(100) NOT NULL,
  `dateTime` datetime NOT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY  (`subscriber`),
  KEY `FK_adm_revenue` (`account`),
  CONSTRAINT `FK_adm_revenue_subscriber` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_revenue` */

/*Table structure for table `msb_roster` */

DROP TABLE IF EXISTS `msb_roster`;

CREATE TABLE `msb_roster` (
  `rosterID` bigint(20) NOT NULL auto_increment,
  `subscriber` varchar(64) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `sub` tinyint(4) NOT NULL,
  `ask` tinyint(4) NOT NULL,
  `recv` tinyint(4) NOT NULL,
  `nick` varchar(255) default NULL,
  `key` varchar(64) default NULL,
  PRIMARY KEY  (`rosterID`),
  UNIQUE KEY `subscriber` (`subscriber`,`jid`),
  KEY `ofRoster_unameid_idx` (`subscriber`),
  KEY `ofRoster_jid_idx` (`jid`),
  CONSTRAINT `FK_msb_roster` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `msb_roster` */

insert  into `msb_roster`(`rosterID`,`subscriber`,`jid`,`sub`,`ask`,`recv`,`nick`,`key`) values (1,'admin','6010001@domain.com',3,-1,-1,'6010001','wmQ45QjYpC38W3i'),(2,'6010001','admin@domain.com',3,-1,-1,'admin','wmQ45QjYpC38W3i'),(3,'admin','6010002@domain.com',3,-1,-1,'6010002','wmQ45QjYpC38W3i'),(4,'admin','6010003@domain.com',3,-1,-1,'6010003','wmQ45QjYpC38W3i'),(5,'6010003','admin@domain.com',3,-1,-1,'admin','wmQ45QjYpC38W3i'),(6,'6010002','admin@domain.com',3,-1,-1,'admin','wmQ45QjYpC38W3i'),(7,'admin','6010004@domain.com',3,-1,0,'6010004','wmQ45QjYpC38W3i'),(8,'6010004','admin@domain.com',3,-1,1,'admin','wmQ45QjYpC38W3i'),(9,'admin','6010005@domain.com',3,-1,-1,'6010005','wmQ45QjYpC38W3i'),(10,'6010005','admin@domain.com',3,-1,-1,'admin','wmQ45QjYpC38W3i'),(11,'admin','6010006@domain.com',3,-1,-1,'6010006','wmQ45QjYpC38W3i'),(12,'6010006','admin@domain.com',3,-1,-1,'admin','wmQ45QjYpC38W3i'),(13,'admin','6010007@domain.com',3,-1,-1,'6010007','wmQ45QjYpC38W3i'),(14,'6010007','admin@domain.com',3,-1,-1,'admin','wmQ45QjYpC38W3i'),(16,'admin','tester07@domain.com',3,-1,-1,'tester07','wmQ45QjYpC38W3i'),(17,'admin','6010010@domain.com',3,-1,-1,'6010010','wmQ45QjYpC38W3i'),(18,'6010010','admin@domain.com',3,-1,-1,'admin','wmQ45QjYpC38W3i'),(19,'6010001','6010010@domain.com',3,-1,-1,'6010010','wmQ45QjYpC38W3i'),(20,'6010001','6010011@domain.com',3,-1,-1,'6010011','wmQ45QjYpC38W3i'),(21,'admin','6010011@domain.com',1,-1,-1,'6010011','wmQ45QjYpC38W3i'),(22,'6010011','admin@domain.com',2,-1,-1,'admin','wmQ45QjYpC38W3i');

/*Table structure for table `msb_rostergroups` */

DROP TABLE IF EXISTS `msb_rostergroups`;

CREATE TABLE `msb_rostergroups` (
  `rosterID` bigint(20) NOT NULL,
  `rank` tinyint(4) NOT NULL,
  `groupName` varchar(255) NOT NULL,
  PRIMARY KEY  (`rosterID`,`rank`),
  KEY `ofRosterGroup_rosterid_idx` (`rosterID`),
  CONSTRAINT `FK_msb_rostergroups` FOREIGN KEY (`rosterID`) REFERENCES `msb_roster` (`rosterID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_rostergroups` */

/*Table structure for table `msb_session` */

DROP TABLE IF EXISTS `msb_session`;

CREATE TABLE `msb_session` (
  `sessionId` varchar(40) NOT NULL,
  `subscriber` varchar(64) default NULL,
  `domain` varchar(40) default NULL,
  `ipAddress` varchar(40) NOT NULL,
  `ipPort` varchar(10) default NULL,
  `protocol` varchar(10) default NULL,
  `startTime` varchar(40) default NULL,
  `endTime` varchar(40) default NULL,
  `resource` varchar(20) default NULL,
  `presence` varchar(20) default 'unavailable',
  `status` varchar(160) default 'Offline',
  PRIMARY KEY  (`sessionId`),
  KEY `FK_msb_session` (`subscriber`),
  CONSTRAINT `FK_msb_session` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_session` */

insert  into `msb_session`(`sessionId`,`subscriber`,`domain`,`ipAddress`,`ipPort`,`protocol`,`startTime`,`endTime`,`resource`,`presence`,`status`) values ('3fbd5fe8474dd540','admin','domain.com','127.0.0.1','1883','tcp','20200701000014',NULL,'JavaClient 1.0','available','Online'),('3fe504a350c59307','admin','domain.com','127.0.0.1','1883','tcp','20200630235232',NULL,'JavaClient 1.0','available','Online');

/*Table structure for table `msb_subscriber` */

DROP TABLE IF EXISTS `msb_subscriber`;

CREATE TABLE `msb_subscriber` (
  `subscriber` varchar(64) NOT NULL,
  `password` varchar(255) default NULL,
  `name` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  `subtype` varchar(40) NOT NULL default 'user',
  `account` varchar(64) default NULL,
  `userKey` varchar(20) NOT NULL,
  PRIMARY KEY  (`subscriber`),
  KEY `ofUser_cDate_idx` (`creationDate`),
  KEY `FK_msb_subscriber` (`subtype`),
  KEY `FK_msb_subscriber_account` (`account`),
  CONSTRAINT `FK_msb_subscriber_account` FOREIGN KEY (`account`) REFERENCES `msb_account` (`account`),
  CONSTRAINT `FK_msb_subscriber` FOREIGN KEY (`subtype`) REFERENCES `msb_subscribertype` (`subtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_subscriber` */

insert  into `msb_subscriber`(`subscriber`,`password`,`name`,`email`,`creationDate`,`modificationDate`,`subtype`,`account`,`userKey`) values ('6010001','c072302dd797abf7cc800b976f9ff27c8df92a9c85f46dd3','6010001','admin@ejtran.com','20190130180317','20190130180317','device',NULL,'wmQ45QjYpC38W3i'),('6010002','416e14d2981b14ab8efffb2df9592b43eba5a5e4e276fb1a','6010002','admin@ejtran.com','20190130180317','20190130180317','device',NULL,'wmQ45QjYpC38W3i'),('6010003','66ddf6f07c5c85851bb68ecb98f6efee2bd69a29afbb54b3','6010003','admin@ejtran.com','20190130182840','20190130182840','device',NULL,'wmQ45QjYpC38W3i'),('6010004','57a0defabf2a7bf6a930d38b71c2b1d5e0a7ba44153e5ea9','6010004','admin@ejtran.com','20190130180839','20190130180839','device',NULL,'wmQ45QjYpC38W3i'),('6010005','b81228b5306543d33fe5b7b4a672858dd60323cfc23810e9','6010005','admin@ejtran.com','20190130181024','20190130181024','device',NULL,'wmQ45QjYpC38W3i'),('6010006','6460611c27525854fa8ad6462c80d3e48a159e30145dee91','6010006','admin@ejtran.com','20190130181040','20190130181040','device',NULL,'wmQ45QjYpC38W3i'),('6010007','14802de3bcf8986087c24f9618430cb46329232e5a0ea535','6010007','admin@ejtran.com','20190130181051','20190130181051','device',NULL,'wmQ45QjYpC38W3i'),('6010008','ceef41a4dd85604db51f4d76ebb7dc6fd44c7564e8cda802','6010008','admin@ejtran.com','20190130181104','20190130181104','device',NULL,'wmQ45QjYpC38W3i'),('6010009','cfe9f1ab920769f5f1f6d336a81dcdeafa6a72a74dc905f5','6010009','admin@ejtran.com','20190130181115','20190130181115','device',NULL,'wmQ45QjYpC38W3i'),('6010010','cc4bf33df5f16431dd456e44c5f49c8878532e5fc82ff08d','6010010','admin@ejtran.com','20190130181146','20190130181146','device',NULL,'wmQ45QjYpC38W3i'),('6010011','ea0e868f0a10de604e4d373c96164636e15a5743f46f0516','6010011','admin@ejtran.com','20190130181155','20190130181155','device',NULL,'wmQ45QjYpC38W3i'),('6010012','c481b2f361e458ef7ba67b7d9999872411d7783eba7c286a','6010012','admin@ejtran.com','20190130181204','20190130181204','device',NULL,'wmQ45QjYpC38W3i'),('6010013','e9cbf7180ac93a01698d2184356cc876290d2dcd03dc8f87','6010013','admin@ejtran.com','20190130181222','20190130181222','device',NULL,'wmQ45QjYpC38W3i'),('6010014','dcb7c14a5bff9d96e0d73b482084c2c813fc972558a6b4be','6010014','admin@ejtran.com','20190130181240','20190130181240','device',NULL,'wmQ45QjYpC38W3i'),('6010021','8de8832aa5fc6a37c92ab3456b14ca1b0e1cfdcbbec22f55','6010021','admin@ejtran.com','20190130180816','20190130180816','device',NULL,'wmQ45QjYpC38W3i'),('6010022','41c4366a124c68b551a6ec9868ff9a910511b522e6566ee9','6010022','admin@ejtran.com','20190130181551','20190130181551','device',NULL,'wmQ45QjYpC38W3i'),('6010023','46e75416cbca7f892050b3a789e85f25fc9a90db4dda6d81','6010023','admin@ejtran.com','20190130181600','20190130181600','device',NULL,'wmQ45QjYpC38W3i'),('6010024','f9cae0539c6e1ac255861f52fda502505db9760894d14415','6010024','admin@ejtran.com','20190130181608','20190130181608','device',NULL,'wmQ45QjYpC38W3i'),('6010025','e32e329a754ca290ed354d7b939810e132008e4288d2b4ec','6010025','admin@ejtran.com','20190130181615','20190130181615','device',NULL,'wmQ45QjYpC38W3i'),('6010026','25569ed5991db014a3605cea523985665ae848b91a429b81','6010026','admin@ejtran.com','20190130181630','20190130181630','device',NULL,'wmQ45QjYpC38W3i'),('6010027','4a19f5eb3191c73966a6d5351aa782f220cb93c567787f8b','6010027','admin@ejtran.com','20190130181637','20190130181637','device',NULL,'wmQ45QjYpC38W3i'),('6010031','42280f27154645dfc432ab88dc818ecc1703332423eb9a06','6010031','admin@ejtran.com','20190130181850','20190130181850','device',NULL,'wmQ45QjYpC38W3i'),('6010033','b701553f95039515a4c9a9bb84ad83c3a6dccb07c862263d','6010033','admin@ejtran.com','20190130181937','20190130181937','device',NULL,'wmQ45QjYpC38W3i'),('6010035','8e93c8afe56e196b83e528c579adcb1859e050766089f82b','6010035','admin@ejtran.com','20190130181959','20190130181959','device',NULL,'wmQ45QjYpC38W3i'),('6010041','d846ca8cbaf8fb174dcc2bf640b785546dd38fd53fd8ecf2','6010041','admin@ejtran.com','20190130182234','20190130182234','device',NULL,'wmQ45QjYpC38W3i'),('6010047','c4c7805ded2613f4748a47e8ddc2e7e144d58001053cfa23','6010047','admin@ejtran.com','20190130182420','20190130182420','device',NULL,'wmQ45QjYpC38W3i'),('6010048','4eee2a2ed6d3fcfdae9c59f34cf82df54b0b275a0a141178','6010048','admin@ejtran.com','20190130182424','20190130182424','device',NULL,'wmQ45QjYpC38W3i'),('6010049','f56e068f2616f59820eefe349eac45dc442a6ff90b686a36','6010049','admin@ejtran.com','20190130182429','20190130182429','device',NULL,'wmQ45QjYpC38W3i'),('6010050','0605f73d90d2871f8b051932176e0f2d5a8701b02b6e08eb','6010050','admin@ejtran.com','20190130182437','20190130182437','device',NULL,'wmQ45QjYpC38W3i'),('6010051','ef77ef958efeb5f999e5c40a6a71948a0f0636c64303d910','6010051','admin@ejtran.com','20190130182441','20190130182441','device',NULL,'wmQ45QjYpC38W3i'),('6010055','0969e47f52f668dabb577f4c6a86a784c4239f739743f104','6010055','admin@ejtran.com','20190130182456','20190130182456','device',NULL,'wmQ45QjYpC38W3i'),('6010056','fe7c770658d9813f133c11188ec304b3c7b440a9a7dc33b8','6010056','admin@ejtran.com','20190130182501','20190130182501','device',NULL,'wmQ45QjYpC38W3i'),('6010057','467dd9a199e7b2d5e7501faebe3b050e89ee47a1c56888c9','6010057','admin@ejtran.com','20190130182506','20190130182506','device',NULL,'wmQ45QjYpC38W3i'),('6010058','1fb59ba8a6b42a47060dea6f992dcaf433c0d700ee325f08','6010058','admin@ejtran.com','20190130182511','20190130182511','device',NULL,'wmQ45QjYpC38W3i'),('6010061','1b5050f0e6abdfb33c2d443a2b1f29f52025874f0d2c7578','6010061','admin@ejtran.com','20190130182524','20190130182524','device',NULL,'wmQ45QjYpC38W3i'),('6010062','1055dc3c6cda573c551f5f2b84c84a12ab78d4f0fe762861','6010062','admin@ejtran.com','20190130182534','20190130182534','device',NULL,'wmQ45QjYpC38W3i'),('6010063','2403431bb981b9c05ed2f19e07afb15c16320d25c1d55cfe','6010063','admin@ejtran.com','20190130182538','20190130182538','device',NULL,'wmQ45QjYpC38W3i'),('6010067','e754fc761aeb9f0eb8db0c9b9acfcd7d23f7640894ba0eef','6010067','admin@ejtran.com','20190130182558','20190130182558','device',NULL,'wmQ45QjYpC38W3i'),('6010073','6bfb76666faeb09acc5fd84c89a02c2fce8aa17d1ffbb2d0','6010073','admin@ejtran.com','20190130182626','20190130182626','device',NULL,'wmQ45QjYpC38W3i'),('6010074','5625bcfd7445a9df6c5abdabc601eed7019c08e099092872','6010074','admin@ejtran.com','20190130182631','20190130182631','device',NULL,'wmQ45QjYpC38W3i'),('6010076','e147713ebe3d673d91fb42a8cba1c44bb855bc74fde1f922','6010076','admin@ejtran.com','20190130182639','20190130182639','device',NULL,'wmQ45QjYpC38W3i'),('6010077','88938834e2251ff60bbc0f0eb87191c78462ee03bd1cf392','6010077','admin@ejtran.com','20190130182645','20190130182645','device',NULL,'wmQ45QjYpC38W3i'),('6010079','c7e1a66e78ac6b630b98f32ed636a5cbdee591b6ddb66c6d','6010079','admin@ejtran.com','20190130182654','20190130182654','device',NULL,'wmQ45QjYpC38W3i'),('6010080','02453c8f486423804db1aab46dc521ecd0945acd46d84db4','6010080','admin@ejtran.com','20190130182658','20190130182658','device',NULL,'wmQ45QjYpC38W3i'),('6020015','8d18770d48588af4a7fe407112ebfe2193f91e9822cf7eb7','6020015','admin@ejtran.com','20190130181258','20190130181258','device',NULL,'wmQ45QjYpC38W3i'),('6020016','e3d29895ed1b951969a03b9c66e0a0950026dac053cf5f41','6020016','admin@ejtran.com','20190130181358','20190130181358','device',NULL,'wmQ45QjYpC38W3i'),('6020017','92c0f3e5243662756f7529f44334e067ea8a837bf039d414','6020017','admin@ejtran.com','20190130181408','20190130181408','device',NULL,'wmQ45QjYpC38W3i'),('6020018','3ec1b48cbf2498529ac000e8e757b7b7aa99ce72b1931b52','6020018','admin@ejtran.com','20190130181419','20190130181419','device',NULL,'wmQ45QjYpC38W3i'),('6020019','979bb8775cbd40805e5f8d2bc39f096612e90b77602f1da5','6020019','admin@ejtran.com','20190130181428','20190130181428','device',NULL,'wmQ45QjYpC38W3i'),('6020020','9029bf1790468449cde1322ce13fc7c63ff3d3454f16efba','6020020','admin@ejtran.com','20190130181522','20190130181522','device',NULL,'wmQ45QjYpC38W3i'),('6020028','aefe79f81203260bbb157012b030d863ad0ba2a1b88fe487','6020028','admin@ejtran.com','20190130181646','20190130181646','device',NULL,'wmQ45QjYpC38W3i'),('6020029','e98cad1eba501ca9007115390bf8eaa30ebac0002cdfe626','6020029','admin@ejtran.com','20190130181701','20190130181701','device',NULL,'wmQ45QjYpC38W3i'),('6020030','607cf2d9ba74b9484e37636feecbc366de2e7a6c1451f8bd','6020030','admin@ejtran.com','20190130181711','20190130181711','device',NULL,'wmQ45QjYpC38W3i'),('6020034','7ea0f3153775a52fdccb525d98dd934b3609197a9aa127b1','6020034','admin@ejtran.com','20190130181947','20190130181947','device',NULL,'wmQ45QjYpC38W3i'),('6020036','9194175f83ba7a7f92f87c3736a4336e45023d51ab60e02e','6020036','admin@ejtran.com','20190130182009','20190130182009','device',NULL,'wmQ45QjYpC38W3i'),('6020037','0c61f7ae33e962c7aacc76d6a1ac75f7b572a603695be09f','6020037','admin@ejtran.com','20190130182018','20190130182018','device',NULL,'wmQ45QjYpC38W3i'),('6020038','e42e7a387d07a72a796c4676b344f1d6c76998252d5e177e','6020038','admin@ejtran.com','20190130182028','20190130182028','device',NULL,'wmQ45QjYpC38W3i'),('6020039','7d40c5a0e3cb1ff6cee101be6c0ad7479082ac4a84c92d23','6020039','admin@ejtran.com','20190130182036','20190130182036','device',NULL,'wmQ45QjYpC38W3i'),('6020040','3926d425ed53758dd505be6c190f256e3805a057f81b3051','6020040','admin@ejtran.com','20190130182213','20190130182213','device',NULL,'wmQ45QjYpC38W3i'),('6020042','99561d7c291354538867e0e218ba7cce0d16ca5a6b557f12','6020042','admin@ejtran.com','20190130182353','20190130182353','device',NULL,'wmQ45QjYpC38W3i'),('6020043','91694a0e0a629e6a72f980df99e1165ec1fdfd74e1f6f153','6020043','admin@ejtran.com','20190130182359','20190130182359','device',NULL,'wmQ45QjYpC38W3i'),('6020044','426f587f8022d116f1853aa82b501085f8db989d3f2e6b0f','6020044','admin@ejtran.com','20190130182405','20190130182405','device',NULL,'wmQ45QjYpC38W3i'),('6020045','f62c5210bf46486b6954e579f1929c14e0ed2bcd2e4d1fc4','6020045','admin@ejtran.com','20190130182410','20190130182410','device',NULL,'wmQ45QjYpC38W3i'),('6020046','b9dee883528f3c3dab1e1c88a0456ad650ac14f4132a809c','6020046','admin@ejtran.com','20190130182415','20190130182415','device',NULL,'wmQ45QjYpC38W3i'),('6020052','7841c11c74940acff8d631b962d461cd66646853eb033bc6','6020052','admin@ejtran.com','20190130182444','20190130182444','device',NULL,'wmQ45QjYpC38W3i'),('6020053','49427500b16357c219b4263f58ac5caeae70155e1c88c565','6020053','admin@ejtran.com','20190130182448','20190130182448','device',NULL,'wmQ45QjYpC38W3i'),('6020054','134731cad9d5cdb35bea66314baf5fd3044c00fa20b12aa0','6020054','admin@ejtran.com','20190130182452','20190130182452','device',NULL,'wmQ45QjYpC38W3i'),('6020059','ad18cfe665cdfeae9c70655cc1cf2966080096b1ef207d64','6020059','admin@ejtran.com','20190130182515','20190130182515','device',NULL,'wmQ45QjYpC38W3i'),('6020060','9813934f17eb6dd5c92e5f22bc3e255b108a9b4471f102a0','6020060','admin@ejtran.com','20190130182520','20190130182520','device',NULL,'wmQ45QjYpC38W3i'),('6020064','e489db7d2153eb6c22963f4ba6d8d3bc46f53407473a0f12','6020064','admin@ejtran.com','20190130182545','20190130182545','device',NULL,'wmQ45QjYpC38W3i'),('6020065','b0e01c313b3d76afa2c34f1241e854bd5039d4a92bb92a7f','6020065','admin@ejtran.com','20190130182549','20190130182549','device',NULL,'wmQ45QjYpC38W3i'),('6020066','b011574d698b1d88aba22ed9773a1c10880d33322b2a521f','6020066','admin@ejtran.com','20190130182553','20190130182553','device',NULL,'wmQ45QjYpC38W3i'),('6020068','86abb3bae6acf8b5aaa51c31cdf48f952dd7a110e486f8cf','6020068','admin@ejtran.com','20190130182603','20190130182603','device',NULL,'wmQ45QjYpC38W3i'),('6020069','f737f5ea3214ca13b2ebeae178fa25a855a0e44ae01654af','6020069','admin@ejtran.com','20190130182608','20190130182608','device',NULL,'wmQ45QjYpC38W3i'),('6020070','d3c3d58797131335af4633b3806216dac4146b40d0258066','6020070','admin@ejtran.com','20190130182615','20190130182615','device',NULL,'wmQ45QjYpC38W3i'),('6020071','221603ce396d98ccba0f7172000c92a7f089f34274ce3411','6020071','admin@ejtran.com','20190130182618','20190130182618','device',NULL,'wmQ45QjYpC38W3i'),('6020072','10fecf5495c19eb3d1b6de1c4884c45fad14e17773b251dc','6020072','admin@ejtran.com','20190130182622','20190130182622','device',NULL,'wmQ45QjYpC38W3i'),('6020075','5a70d6ffcbcd68dfa112c03ff176035fc96ae78841b833ba','6020075','admin@ejtran.com','20190130182635','20190130182635','device',NULL,'wmQ45QjYpC38W3i'),('6020078','b494d9a0001d8d3acc8dc955ba0962bdffdd46fb74a06770','6020078','admin@ejtran.com','20190130182650','20190130182650','device',NULL,'wmQ45QjYpC38W3i'),('6020081','e8c4eca89050974b31e2c3b37d5501224b55bc51eb3ac3ab','6020081','admin@ejtran.com','20190130182704','20190130182704','device',NULL,'wmQ45QjYpC38W3i'),('6020082','73fdb5c8ec9a518aff0c0b7d30896bd9ea5585e7b669df5d','6020082','admin@ejtran.com','20190130182708','20190130182708','device',NULL,'wmQ45QjYpC38W3i'),('6020083','0460a17ccc452926d70415fab54c7cb05eb7e76afaff009e','6020083','admin@ejtran.com','20190130182714','20190130182714','device',NULL,'wmQ45QjYpC38W3i'),('admin','65df9967b153743bb4b7a54fe7a568a7e7b47ee89645f6e7','admin','admin@ejtran.com','20190130175158','20190130175158','user','admin','wmQ45QjYpC38W3i'),('S00111','b56803882f06cfc5513f6dedc44ad400c43d30909faf1889','S00111','admin@ejtran.com','20190130225303','20190130225303','service',NULL,'wmQ45QjYpC38W3i'),('S00112','869a1a0847cdf3885a1ea0f0209fecee1a38784db5467a30','S00112','admin@ejtran.com','20190224074853','20190224074853','service',NULL,'wmQ45QjYpC38W3i'),('S00113','7fcd6b8879ce6b4e292ee326d2c40f15a466f8d6a78c7bcb','S00113','admin@ejtran.com','20190219102735','20190219102735','service',NULL,'wmQ45QjYpC38W3i'),('S00114','f0913438daf3b6873a196542e4710db4a6c51d1e51710475','S00114','admin@ejtran.com','20190219102831','20190219102831','service',NULL,'wmQ45QjYpC38W3i'),('S00115','628caca2d5696c1351505f0efa7f320668b4861e6df6eafc','S00115','admin@ejtran.com','20190219102947','20190219102947','service',NULL,'wmQ45QjYpC38W3i'),('yypurdi','c97755cdf72b1a40e0f52b658e07ee84b04fadd01791d4c8','yypurdi','yypurdi@yahoo.com','20190410201819','20190410201819','user',NULL,'wmQ45QjYpC38W3i');

/*Table structure for table `msb_subscriberprop` */

DROP TABLE IF EXISTS `msb_subscriberprop`;

CREATE TABLE `msb_subscriberprop` (
  `subscriber` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` varchar(600) NOT NULL,
  PRIMARY KEY  (`subscriber`,`name`),
  CONSTRAINT `FK_msb_subscriberprop` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_subscriberprop` */

/*Table structure for table `msb_subscribertype` */

DROP TABLE IF EXISTS `msb_subscribertype`;

CREATE TABLE `msb_subscribertype` (
  `subtype` varchar(40) NOT NULL,
  `description` varchar(100) default NULL,
  PRIMARY KEY  (`subtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_subscribertype` */

insert  into `msb_subscribertype`(`subtype`,`description`) values ('device','device provider data sensor and actuator'),('server','server domain inter communication '),('service','sevice provider micro service processing'),('user','user of data and services');

/*Table structure for table `msb_traffic` */

DROP TABLE IF EXISTS `msb_traffic`;

CREATE TABLE `msb_traffic` (
  `subscriber` varchar(64) NOT NULL,
  `account` varchar(64) NOT NULL,
  `from` varchar(100) NOT NULL,
  `to` varchar(100) default NULL,
  `counter` bigint(20) NOT NULL,
  `type` varchar(100) NOT NULL,
  `last_update` datetime NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY  (`subscriber`),
  KEY `FK_adm_traffic` (`account`),
  CONSTRAINT `FK_adm_traffic_subscriber` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_traffic` */

/*Table structure for table `msb_vcard` */

DROP TABLE IF EXISTS `msb_vcard`;

CREATE TABLE `msb_vcard` (
  `subscriber` varchar(64) NOT NULL,
  `vcard` mediumtext NOT NULL,
  PRIMARY KEY  (`subscriber`),
  CONSTRAINT `FK_msb_vcard` FOREIGN KEY (`subscriber`) REFERENCES `msb_subscriber` (`subscriber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_vcard` */

/*Table structure for table `msb_version` */

DROP TABLE IF EXISTS `msb_version`;

CREATE TABLE `msb_version` (
  `name` varchar(50) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `msb_version` */

insert  into `msb_version`(`name`,`version`) values ('microsb',1);
