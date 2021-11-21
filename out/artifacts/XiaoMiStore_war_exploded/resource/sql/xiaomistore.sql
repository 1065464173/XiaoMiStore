/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : xiaomistore

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 16/11/2021 18:32:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名字',
  `price` decimal(65,2) DEFAULT NULL COMMENT '单价',
  `num` int DEFAULT NULL COMMENT '库存数量',
  `imgurl` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片url',
  `color` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '颜色',
  `version` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '型号版本',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `category` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `hobby` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '爱好',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `signature` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '个性签名',
  `updatetime` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
