/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : kadawang

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-08-24 22:37:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for k_answer
-- ----------------------------
DROP TABLE IF EXISTS `k_answer`;
CREATE TABLE `k_answer` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '答案编号',
  `answer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of k_answer
-- ----------------------------
INSERT INTO `k_answer` VALUES ('1', 'A');
INSERT INTO `k_answer` VALUES ('2', 'B');
INSERT INTO `k_answer` VALUES ('3', 'C');
INSERT INTO `k_answer` VALUES ('4', 'D');

-- ----------------------------
-- Table structure for k_course
-- ----------------------------
DROP TABLE IF EXISTS `k_course`;
CREATE TABLE `k_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `user_id` int(10) NOT NULL DEFAULT '0' COMMENT '用户id',
  `cname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '课程名字',
  `curl` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '课程链接',
  PRIMARY KEY (`id`,`user_id`),
  KEY `用户` (`user_id`),
  KEY `id` (`id`),
  CONSTRAINT `用户` FOREIGN KEY (`user_id`) REFERENCES `k_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of k_course
-- ----------------------------
INSERT INTO `k_course` VALUES ('1', '1', 'JAVA基础课程', 'http://yun.itheima.com/course/375.html');
INSERT INTO `k_course` VALUES ('2', '1', ' Java教程|Mybatis由浅入深教程', 'http://yun.itheima.com/course/289.html');
INSERT INTO `k_course` VALUES ('3', '1', '4', '4');
INSERT INTO `k_course` VALUES ('4', '1', '1', '1');
INSERT INTO `k_course` VALUES ('5', '2', '2', '2');
INSERT INTO `k_course` VALUES ('7', '1', 'java', '11111');
INSERT INTO `k_course` VALUES ('8', '1', 'SpringMVC', 'https://www.cnblogs.com/mafly/p/5839863.html');
INSERT INTO `k_course` VALUES ('9', '1', '5', '5');
INSERT INTO `k_course` VALUES ('12', '1', '6', '6');

-- ----------------------------
-- Table structure for k_power
-- ----------------------------
DROP TABLE IF EXISTS `k_power`;
CREATE TABLE `k_power` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '权限等级',
  `power` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of k_power
-- ----------------------------
INSERT INTO `k_power` VALUES ('1', '管理员');
INSERT INTO `k_power` VALUES ('2', '老师');
INSERT INTO `k_power` VALUES ('3', '学生');
INSERT INTO `k_power` VALUES ('4', '访客');

-- ----------------------------
-- Table structure for k_question
-- ----------------------------
DROP TABLE IF EXISTS `k_question`;
CREATE TABLE `k_question` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `course_id` int(10) NOT NULL COMMENT '课程编号',
  `answer_id` int(10) NOT NULL COMMENT '答案编码',
  `score` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '问题分数',
  `qname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '题目名称',
  `qcontent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '题目内容',
  `qcontent_a` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '选项A的内容',
  `qcontent_b` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '选项B的内容',
  `qcontent_c` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '选项C的内容',
  `qcontent_d` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '选项D的内容',
  PRIMARY KEY (`id`,`course_id`,`answer_id`),
  KEY `课程` (`course_id`),
  KEY `答案` (`answer_id`),
  CONSTRAINT `答案` FOREIGN KEY (`answer_id`) REFERENCES `k_answer` (`id`),
  CONSTRAINT `课程` FOREIGN KEY (`course_id`) REFERENCES `k_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of k_question
-- ----------------------------
INSERT INTO `k_question` VALUES ('1', '1', '4', '2', 'JAVA基础', 'Outer类中定义了一个成员内部类Inner，需要在main()方法中创建Inner类实例对象，以下四种方式哪一种是正确的？', 'A、Inner in = new Inner()', 'B、Inner in = new Outer.Inner();', 'C、Outer.Inner in = new Outer.Inner();', 'D、Outer.Inner in = new Outer().new Inner();');
INSERT INTO `k_question` VALUES ('2', '1', '1', '2', 'JAVA基础', '下列选项中，可以正确配置classpath的命令是（ ）', 'A、set classpath =C:\\\\Program Files\\\\Java\\\\jdk1.7.0_15\\\\bin', 'B、set classpath : C:\\\\Program Files\\\\Java\\\\jdk1.7.0_15\\\\bin', 'C、classpath set =C:\\\\Program Files\\\\Java\\\\jdk1.7.0_15\\\\bin', 'D、classpath set : C:\\\\Program Files\\\\Java\\\\jdk1.7.0_15\\\\bin');
INSERT INTO `k_question` VALUES ('3', '1', '1', '2', 'JAVA基础', '下面命令中，可以用来正确执行HelloWorld案例的是（）', 'A、java HelloWorld', 'B、java HelloWorld.java', 'C、javac HelloWorld', 'D、javac HelloWorld.java');

-- ----------------------------
-- Table structure for k_report
-- ----------------------------
DROP TABLE IF EXISTS `k_report`;
CREATE TABLE `k_report` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '单科成绩id',
  `course_id` int(10) NOT NULL COMMENT '课程id',
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `score` int(10) DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`,`course_id`,`user_id`),
  KEY `课程2` (`course_id`),
  KEY `用户2` (`user_id`),
  CONSTRAINT `用户2` FOREIGN KEY (`user_id`) REFERENCES `k_user` (`id`),
  CONSTRAINT `课程2` FOREIGN KEY (`course_id`) REFERENCES `k_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of k_report
-- ----------------------------
INSERT INTO `k_report` VALUES ('1', '1', '1', '100');
INSERT INTO `k_report` VALUES ('2', '2', '1', '100');

-- ----------------------------
-- Table structure for k_user
-- ----------------------------
DROP TABLE IF EXISTS `k_user`;
CREATE TABLE `k_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `power_id` int(10) NOT NULL COMMENT '权限',
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`,`power_id`),
  KEY `权限` (`power_id`),
  KEY `id` (`id`),
  CONSTRAINT `权限` FOREIGN KEY (`power_id`) REFERENCES `k_power` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of k_user
-- ----------------------------
INSERT INTO `k_user` VALUES ('1', '1', 'admin', '123456');
INSERT INTO `k_user` VALUES ('2', '2', '蒋程', '123456');
INSERT INTO `k_user` VALUES ('3', '3', 'cheng', '123456');
INSERT INTO `k_user` VALUES ('4', '4', 'jiang', '123456');
