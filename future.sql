/*
Navicat MySQL Data Transfer

Source Server         : future
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : future

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-23 10:04:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `user_password` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(64) COLLATE utf8_bin DEFAULT NULL,  
  `state` tinyint(4) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
   PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_user
-- ----------------------------

DROP TABLE IF EXISTS `tb_workrecord`;
CREATE TABLE `tb_workrecord` (
  `work_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) COLLATE utf8_bin NOT NULL,
  `note_date` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL, 
  `state` tinyint(4) DEFAULT NULL,
  `comment` varchar(8192) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
   PRIMARY KEY (`work_id`),
   unique (`note_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

