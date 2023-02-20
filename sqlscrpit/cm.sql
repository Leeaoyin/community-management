/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : test-jksh.mysql.rds.aliyuncs.com:3306
 Source Schema         : community_management

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 20/02/2023 14:14:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_active
-- ----------------------------
DROP TABLE IF EXISTS `apply_active`;
CREATE TABLE `apply_active`  (
                                 `id` int(0) NOT NULL AUTO_INCREMENT,
                                 `user_id` int(0) NOT NULL COMMENT '用户ID',
                                 `active_type` int(0) NULL DEFAULT NULL COMMENT '0:外出，1:进入',
                                 `active_time` datetime(0) NOT NULL COMMENT '外出/进入时间',
                                 `reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请原因',
                                 `family_friend` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '亲戚朋友姓名',
                                 `state` int(0) NOT NULL DEFAULT 0 COMMENT '状态，0未审核/1审核通过',
                                 `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT 'create time',
                                 `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'update time',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出门申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for apply_material
-- ----------------------------
DROP TABLE IF EXISTS `apply_material`;
CREATE TABLE `apply_material`  (
                                   `id` int(0) NOT NULL AUTO_INCREMENT,
                                   `user_id` int(0) NOT NULL COMMENT '用户ID',
                                   `material_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物资名称',
                                   `num` int(0) NOT NULL DEFAULT 1 COMMENT '物资数量',
                                   `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                                   `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物资申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'user id',
                         `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user name',
                         `user_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user password',
                         `user_type` int(0) NULL DEFAULT NULL COMMENT '0:administrator，1:ordinary user',
                         `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT 'create time',
                         `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'update time',
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE INDEX `user_name_unique`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
                              `id` int(0) NOT NULL AUTO_INCREMENT,
                              `user_id` int(0) NOT NULL COMMENT '用户ID',
                              `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住户姓名',
                              `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email',
                              `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'phone',
                              `room_number` int(0) NOT NULL COMMENT '房间编号',
                              `health_state` int(0) NOT NULL DEFAULT 0 COMMENT '健康状态：0康/1病',
                              `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                              `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '住户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vaccine_order
-- ----------------------------
DROP TABLE IF EXISTS `vaccine_order`;
CREATE TABLE `vaccine_order`  (
                                  `id` int(0) NOT NULL AUTO_INCREMENT,
                                  `user_id` int(0) NOT NULL COMMENT '预约人ID',
                                  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预约人手机号',
                                  `vaccine_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预约疫苗名称',
                                  `order_time` datetime(0) NOT NULL COMMENT '预约时间',
                                  `state` int(0) NOT NULL DEFAULT 0 COMMENT '是否过期，0未过期/1已过期',
                                  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                                  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '疫苗预约表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
