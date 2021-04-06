/*
 Navicat Premium Data Transfer

 Source Server         : design
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : design

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 06/04/2021 10:52:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键PK',
  `adminname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员账号',
  `pwd` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (3, 'admin', 'admin');
INSERT INTO `admin` VALUES (4, '324', '123');
INSERT INTO `admin` VALUES (7, '1', '1');
INSERT INTO `admin` VALUES (8, '123123', '123');
INSERT INTO `admin` VALUES (1, '17060207112', '19980811');
COMMIT;

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `sort` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品分类',
  `nums` int(11) NOT NULL COMMENT '数量',
  `store` int(11) NOT NULL COMMENT '门店',
  `sdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日期',
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='门店订货';

-- ----------------------------
-- Records of order_goods
-- ----------------------------
BEGIN;
INSERT INTO `order_goods` VALUES (1, '测试1', '分类1', 1000, 2, '2019-03-31', '未审核', 't002');
INSERT INTO `order_goods` VALUES (2, '测试2', '分类2', 2000, 2, '2019-04-12', '已审核', 't002');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编号',
  `sort` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类',
  `price` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '价格',
  `nums` int(11) DEFAULT NULL COMMENT '库存',
  `remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='产品';

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (7, '产品测试1', '1554033893831', '分类2', '500', 1000, '测试1');
INSERT INTO `product` VALUES (8, '产品测试2', '1554033947974', '分类2', '222', 1000, '测试2');
COMMIT;

-- ----------------------------
-- Table structure for return_goods
-- ----------------------------
DROP TABLE IF EXISTS `return_goods`;
CREATE TABLE `return_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `sort` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品分类',
  `store` int(11) NOT NULL COMMENT '门店',
  `nums` int(11) NOT NULL COMMENT '退货数量',
  `sdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日期',
  `state` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='退货';

-- ----------------------------
-- Records of return_goods
-- ----------------------------
BEGIN;
INSERT INTO `return_goods` VALUES (1, '测试1', '分类1', 2, 111, '2021-03-31', '已审核', 't002');
COMMIT;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='产品分类';

-- ----------------------------
-- Records of sort
-- ----------------------------
BEGIN;
INSERT INTO `sort` VALUES (4, '分类1');
INSERT INTO `sort` VALUES (5, '分类2');
COMMIT;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '门店名称',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '门店地址',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `tname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店长姓名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='门店';

-- ----------------------------
-- Records of store
-- ----------------------------
BEGIN;
INSERT INTO `store` VALUES (1, '一号店', '北京', '18302124590', '李世民');
INSERT INTO `store` VALUES (2, '二号店', '南京', '18902121010', '秦始皇');
COMMIT;

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `sort` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品分类',
  `store` int(11) NOT NULL COMMENT '门店',
  `nums` int(11) NOT NULL COMMENT '调货数量',
  `sdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日期',
  `state` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='门店调货';

-- ----------------------------
-- Records of transfer
-- ----------------------------
BEGIN;
INSERT INTO `transfer` VALUES (1, '测试1', '分类1', 2, 11, '2019-03-14', '未审核', 't002');
INSERT INTO `transfer` VALUES (2, '测试2', '分类2', 2, 11, '2019-04-12', '已审核', 't002');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位',
  `store` int(11) DEFAULT NULL COMMENT '所属门店',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机',
  `limits` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限',
  PRIMARY KEY (`id`),
  KEY `store_fk` (`store`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 't001', '123', '张三丰', '男', '经理', 2, '18323442021', '经理');
INSERT INTO `user` VALUES (2, 't002', '123', '张无忌', '男', '员工', 2, '18121202410', '普通员工');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
