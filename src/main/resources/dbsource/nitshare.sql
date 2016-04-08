/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : nitshare

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2016-04-08 10:16:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `cid` bigint(20) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `cid` bigint(20) NOT NULL COMMENT '商品id',
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) NOT NULL DEFAULT '-1' COMMENT '引用评论id',
  `commtime` date NOT NULL COMMENT '评论时间',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pubDate` datetime NOT NULL COMMENT '商品发布日期',
  `cname` varchar(255) NOT NULL COMMENT '商品名',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `imgUrl0` varchar(255) NOT NULL COMMENT '图片地址',
  `imgUrl1` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `imgUrl2` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `tradePlace` varchar(100) NOT NULL COMMENT '交易地址',
  `type` int(20) NOT NULL COMMENT '商品类型',
  `qq` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `bargain` int(10) NOT NULL COMMENT '是否可以讲价',
  `state` int(10) NOT NULL COMMENT '商品状态',
  `click` bigint(255) NOT NULL DEFAULT '0' COMMENT '商品点击量',
  `mid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品消息id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('0', '2016-04-04 12:43:07', '连衣裙', '188.80', '新品连衣裙，没穿过', 'http://ww2.sinaimg.cn/mw690/ad108d28gw1f2lsupkuekj204g04gt8l.jpg', 'test', 'test', '0', '二期', '0', 'test', 'test', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('1', '2016-04-05 09:18:19', '999真钻戒', '888.88', '999真钻戒', 'http://ww4.sinaimg.cn/mw690/ad108d28gw1f2lsuot8o8j204g04gjr8.jpg', 'test', 'test', '1', '八分钟', '0', 'test', 'test', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('2', '2016-04-05 11:07:08', 'Polo衫', '89.00', 'Polo衫', 'http://ww4.sinaimg.cn/mw690/ad108d28gw1f2lsup8m4pj204g04gglg.jpg', 'url', 'url', '1', '三期', '0', '850657012', '14556413', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('3', '2016-04-05 11:07:08', '白色卫衣', '125.00', '白色卫衣', 'http://ww4.sinaimg.cn/mw690/ad108d28gw1f2lsuomebgj204g04gdfp.jpg', 'url', 'url', '1', '石磷', '0', '850657012', '14556413', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('4', '2016-04-05 11:07:08', '后悔药', '1024.00', '后悔药', 'http://ww1.sinaimg.cn/mw690/ad108d28gw1f2lsunyfy4j204g04g3ye.jpg', 'url', 'url', '1', '老食堂', '0', '850657012', '14556413', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('5', '2016-04-05 11:07:08', '水上漂跑鞋', '9999.90', '水上漂跑鞋', 'http://ww4.sinaimg.cn/mw690/ad108d28gw1f2lsuno129j204g04gwee.jpg', 'url', 'url', '1', 'NB121', '0', '850657012', '14556413', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('6', '2016-04-05 11:07:08', '羽绒服', '555.00', '羽绒服', 'http://ww3.sinaimg.cn/mw690/ad108d28gw1f2lsun500bj204g04ggli.jpg', 'url', 'url', '1', '一期', '0', '850657012', '14556413', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('7', '2016-04-05 11:07:08', '小西装', '666.00', '小西装', 'http://ww3.sinaimg.cn/mw690/ad108d28gw1f2lsumraohj204g04gglg.jpg', 'url', 'url', '1', '学府苑', '0', '850657012', '14556413', '0', '0', '0', '0');
INSERT INTO `commodity` VALUES ('8', '2016-04-05 11:07:08', '衬衫', '78.00', '衬衫', 'http://ww4.sinaimg.cn/mw690/ad108d28gw1f2lsumexm9j204g04g3ye.jpg', 'url', 'url', '1', '图书馆', '0', '850657012', '14556413', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `account` varchar(60) NOT NULL,
  `pwd` varchar(60) NOT NULL,
  `mobile` varchar(60) DEFAULT NULL,
  `mail` varchar(60) DEFAULT NULL,
  `qq` varchar(60) DEFAULT NULL,
  `nickname` varchar(60) NOT NULL,
  `headimg` varchar(60) DEFAULT NULL,
  `score` bigint(255) unsigned zerofill NOT NULL,
  `rank` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
