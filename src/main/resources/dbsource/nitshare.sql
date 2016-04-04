/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : nitshare

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-04-04 19:54:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pubDate` datetime NOT NULL COMMENT '发布日期',
  `cname` varchar(255) NOT NULL COMMENT '商品名',
  `price` decimal(10,0) NOT NULL COMMENT '商品价格',
  `description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `imgUrl0` varchar(255) NOT NULL COMMENT '商品图片',
  `imgUrl1` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `imgUrl2` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `tradePlace` varchar(100) NOT NULL COMMENT '交易地点',
  `type` int(20) NOT NULL COMMENT '商品类型',
  `qq` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `bargain` int(10) NOT NULL COMMENT '是否可以讲价(0可以讲价，1不可以)',
  `state` int(10) NOT NULL COMMENT '商品状态(0为上架，1为下架，2为已售出)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', '2016-04-04 12:43:07', 'test', '3', 'test', 'test', 'test', 'test', '0', 'test', '0', 'test', 'test', '0', '0');
