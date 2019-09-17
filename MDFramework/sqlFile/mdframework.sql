/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - mdframework
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mdframework` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mdframework`;

/*Table structure for table `banner_info` */

DROP TABLE IF EXISTS `banner_info`;

CREATE TABLE `banner_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `title` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `main_pic` varchar(512) COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片',
  `link_url` varchar(512) COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接',
  `order_by` int(4) DEFAULT NULL COMMENT '排序',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` int(1) DEFAULT '0' COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_status` int(1) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `banner_info` */

insert  into `banner_info`(`id`,`user_id`,`title`,`main_pic`,`link_url`,`order_by`,`start_time`,`end_time`,`status`,`create_time`,`del_status`) values (2,NULL,'轮播图1','http://localhost/uploadfiles/2018/07/27/93f73ec186f5c2fefc1270e4d7e11c6d.jpg','http://mvnrepository.com/artifact/joda-time/joda-time/2.5',1,'2018-07-27 00:00:00','2018-07-29 00:00:00',1,'2018-07-27 16:52:12',1);

/*Table structure for table `base_info` */

DROP TABLE IF EXISTS `base_info`;

CREATE TABLE `base_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司名称',
  `main_pic` varchar(512) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'logo',
  `phone` varchar(20) COLLATE utf8_general_ci DEFAULT NULL COMMENT '客服电话',
  `qq_number` varchar(12) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'qq号码',
  `about_us` longtext COLLATE utf8_general_ci COMMENT '关于我们',
  `pay_amount` double DEFAULT '1' COMMENT '支付金额',
  `del_status` int(1) DEFAULT '1' COMMENT '删除状态',
  `person_amount` double DEFAULT '0' COMMENT '个人会员支付金额',
  `brand_amount` double DEFAULT '0' COMMENT '品牌会员支付金额',
  `person_expiry_time` int(5) DEFAULT NULL COMMENT '个人会员到期时间',
  `brand_expiry_time` int(5) DEFAULT NULL COMMENT '品牌会员到期时间',
  `person_content` longtext COLLATE utf8_general_ci COMMENT '个人会员推广内容',
  `brand_content` longtext COLLATE utf8_general_ci COMMENT '品牌会员推广内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `base_info` */

insert  into `base_info`(`id`,`name`,`main_pic`,`phone`,`qq_number`,`about_us`,`pay_amount`,`del_status`,`person_amount`,`brand_amount`,`person_expiry_time`,`brand_expiry_time`,`person_content`,`brand_content`) values (1,'司机有乐','http://localhost/uploadfiles/2018/07/27/be6e4ffe9f46f9a6967e5d891122bb33.png','020-12345611','5731104611','<p>关于我们内容</p>',1,1,99,199,365,365,NULL,NULL);

/*Table structure for table `comm_params_info` */

DROP TABLE IF EXISTS `comm_params_info`;

CREATE TABLE `comm_params_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type_name` varchar(20) COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属类型名称',
  `unique_type` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型唯一标识',
  `key_name` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '数据名称',
  `key_value` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '数据对应值',
  `order_by` int(2) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_status` int(1) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `comm_params_info` */

insert  into `comm_params_info`(`id`,`type_name`,`unique_type`,`key_name`,`key_value`,`order_by`,`create_time`,`del_status`) values (44,'状态','commstatus','已停用','0',0,'2018-07-27 12:30:25',1),(45,'状态','commstatus','已启用','1',1,'2018-07-27 12:30:45',1);

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `real_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `constellation` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `emotion` int(11) DEFAULT NULL,
  `profession` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `login_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `password` varchar(200) COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_LOGIN_NAME` (`id`,`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `member` */

insert  into `member`(`id`,`name`,`real_name`,`sex`,`address`,`age`,`constellation`,`emotion`,`profession`,`login_name`,`password`,`email`,`phone`,`create_time`,`status`) values (1,'test','test',1,'test',18,'金牛座',1,'IT','test','25bb7c42604b0e7aba7bcae50e7762a9','591165537@qq.com','15820257339','2017-09-20 12:00:00',1),(2,'test1','test1',1,'test1',18,'处女座',1,'IT','test1','111111','591165537@qq.com','15820257339','2017-09-19 22:00:00',1),(3,'test2','test2',1,'test2',18,'天蝎座',1,'IT','test2','111111','591165537@qq.com','15820257339','2017-09-19 22:00:00',1),(4,'test3','test3',1,'test3',18,'双鱼座',1,'IT','test3','111111','591165537@qq.com','15820257339','2017-09-24 00:00:00',1);

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1845 DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `sys_log` */

/*Table structure for table `sys_macro` */

DROP TABLE IF EXISTS `sys_macro`;

CREATE TABLE `sys_macro` (
  `macro_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(255) DEFAULT NULL COMMENT '父级id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `value` varchar(2000) DEFAULT NULL COMMENT '值',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态，0：隐藏   1：显示',
  type tinyint(20) DEFAULT NULL COMMENT '类型,0:目录，1:参数配置',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`macro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='通用字典表';

/*Data for the table `sys_macro` */

insert  into `sys_macro`(`macro_id`,`type_id`,`name`,`value`,`status`,type,`order_num`,`remark`,`gmt_create`,`gmt_modified`) values (1,0,'系统参数',NULL,1,0,0,NULL,'2017-08-15 14:51:27',NULL),(2,1,'用户状态','userStatus',1,0,0,NULL,'2017-08-15 14:51:30',NULL),(3,2,'正常','1',0,1,0,'用户可登录','2017-08-15 14:52:48','2017-08-15 20:23:29'),(4,2,'禁用','0',1,1,0,'禁止用户登录','2017-08-15 14:52:51','2017-08-15 20:44:42'),(5,0,'客户关系',' clientManage',1,0,1,NULL,'2017-08-15 19:58:24',NULL),(6,5,'产品信息','clientProduct',1,0,0,NULL,'2017-08-15 19:59:06',NULL);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  type int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`parent_id`,`name`,`url`,`perms`,type,`icon`,`order_num`,`gmt_create`,`gmt_modified`) values (1,0,'基础管理','','',0,'fa fa-bars',0,'2017-08-09 22:49:47',NULL),(2,3,'系统菜单','sys/menu/','sys:menu:menu',1,'fa fa-th-list',2,'2017-08-09 22:55:15',NULL),(3,0,'系统管理',NULL,NULL,0,'fa fa-desktop',1,'2017-08-09 23:06:55','2017-08-14 14:13:43'),(6,3,'用户管理','sys/user/','sys:user:user',1,'fa fa-user',0,'2017-08-10 14:12:11',NULL),(7,3,'角色管理','sys/role','sys:role:role',1,'fa fa-paw',1,'2017-08-10 14:13:19',NULL),(12,6,'新增','','sys:user:add',2,'',0,'2017-08-14 10:51:35',NULL),(13,6,'编辑','','sys:user:edit',2,'',0,'2017-08-14 10:52:06',NULL),(14,6,'删除',NULL,'sys:user:remove',2,NULL,0,'2017-08-14 10:52:24',NULL),(15,7,'新增','','sys:role:add',2,'',0,'2017-08-14 10:56:37',NULL),(20,2,'新增','','sys:menu:add',2,'',0,'2017-08-14 10:59:32',NULL),(21,2,'编辑','','sys:menu:edit',2,'',0,'2017-08-14 10:59:56',NULL),(22,2,'删除','','sys:menu:remove',2,'',0,'2017-08-14 11:00:26',NULL),(24,6,'批量删除','','sys:user:batchRemove',2,'',0,'2017-08-14 17:27:18',NULL),(25,6,'停用',NULL,'sys:user:disable',2,NULL,0,'2017-08-14 17:27:43',NULL),(26,6,'重置密码','','sys:user:resetPwd',2,'',0,'2017-08-14 17:28:34',NULL),(27,1,'系统日志','common/log','common:log',1,'fa fa-warning',2,'2017-08-14 22:11:53',NULL),(28,27,'刷新',NULL,'sys:log:list',2,NULL,0,'2017-08-14 22:30:22',NULL),(29,27,'删除',NULL,'sys:log:remove',2,NULL,0,'2017-08-14 22:30:43',NULL),(30,27,'清空',NULL,'sys:log:clear',2,NULL,0,'2017-08-14 22:31:02',NULL),(48,1,'代码生成','common/generator','common:generator',1,'fa fa-code',NULL,NULL,NULL),(55,7,'编辑','','sys:role:edit',2,'',NULL,NULL,NULL),(56,7,'删除','','sys:role:remove',2,NULL,NULL,NULL,NULL),(57,1,'运行监控','/druid/index.html','',1,'fa fa-caret-square-o-right',NULL,NULL,NULL),(61,2,'批量删除','','sys:menu:batchRemove',2,NULL,NULL,NULL,NULL),(62,7,'批量删除','','sys:role:batchRemove',2,NULL,NULL,NULL,NULL),(68,0,'会员管理','','',0,'fa fa-user',NULL,NULL,NULL),(69,74,'批量删除','','member:batchRemove',2,NULL,NULL,NULL,NULL),(70,74,'删除','','member:remove',2,'',NULL,NULL,NULL),(71,74,'新增','','member:add',2,NULL,NULL,NULL,NULL),(72,74,'编辑','','member:edit',2,NULL,NULL,NULL,NULL),(73,74,'重置密码','','member:resetPwd',2,NULL,NULL,NULL,NULL),(74,68,'会员列表','member','member:member',1,'fa fa-list',NULL,NULL,NULL),(92,0,'站点配置','','',0,'fa fa-desktop',NULL,NULL,NULL),(93,92,'站点信息','baseInfo/edit/1','baseInfo:baseInfo',1,'fa fa-desktop',NULL,NULL,NULL),(94,93,'查看','','baseInfo:list,baseInfo:info',2,'',NULL,NULL,NULL),(95,93,'新增','','baseInfo:save',2,'fa fa-desktop',NULL,NULL,NULL),(96,93,'编辑','','baseInfo:update',2,'fa fa-desktop',NULL,NULL,NULL),(97,93,'删除','','baseInfo:remove',2,'fa fa-desktop',NULL,NULL,NULL),(98,1,'参数配置','commParamsInfo','commParamsInfo:commParamsInfo',1,'fa fa-list',6,NULL,NULL),(99,98,'查看',NULL,'commParamsInfo:list,commParamsInfo:info',2,NULL,6,NULL,NULL),(100,98,'新增',NULL,'commParamsInfo:save',2,NULL,6,NULL,NULL),(101,98,'修改',NULL,'commParamsInfo:update',2,NULL,6,NULL,NULL),(102,98,'删除',NULL,'commParamsInfo:remove',2,NULL,6,NULL,NULL),(103,0,'内容管理','','',0,'fa fa-desktop',NULL,NULL,NULL),(104,103,'轮播图管理','bannerInfo','bannerInfo:bannerInfo',1,'fa fa-list',6,NULL,NULL),(105,104,'查看',NULL,'bannerInfo:list,bannerInfo:info',2,NULL,6,NULL,NULL),(106,104,'新增',NULL,'bannerInfo:save',2,NULL,6,NULL,NULL),(107,104,'修改',NULL,'bannerInfo:update',2,NULL,6,NULL,NULL),(108,104,'删除',NULL,'bannerInfo:remove',2,NULL,6,NULL,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) DEFAULT NULL COMMENT '角色标识',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `user_id_create` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_sign`,`remark`,`user_id_create`,`gmt_create`,`gmt_modified`) values (1,'超级用户角色','admin','拥有最高权限',2,'2017-08-12 00:43:52','2017-08-12 19:14:59'),(56,'系统管理员',NULL,'系统管理员',NULL,NULL,NULL);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2306 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values (367,44,1),(368,44,32),(369,44,33),(370,44,34),(371,44,35),(372,44,28),(373,44,29),(374,44,30),(375,44,38),(376,44,4),(377,44,27),(378,45,38),(379,46,3),(380,46,20),(381,46,21),(382,46,22),(383,46,23),(384,46,11),(385,46,12),(386,46,13),(387,46,14),(388,46,24),(389,46,25),(390,46,26),(391,46,15),(392,46,2),(393,46,6),(394,46,7),(581,48,38),(582,48,32),(583,48,33),(584,48,34),(585,48,35),(586,48,4),(587,48,28),(588,48,29),(589,48,30),(590,48,27),(591,48,1),(598,50,38),(632,38,42),(737,51,38),(738,51,39),(739,51,40),(740,51,41),(741,51,4),(742,51,32),(743,51,33),(744,51,34),(745,51,35),(746,51,27),(747,51,28),(748,51,29),(749,51,30),(750,51,1),(1038,49,-1),(1039,52,50),(1040,52,49),(1064,54,53),(1095,55,2),(1096,55,6),(1097,55,7),(1098,55,3),(1099,55,50),(1100,55,49),(1101,55,1),(1375,59,1),(1376,59,3),(2237,1,27),(2238,1,48),(2239,1,57),(2240,1,1),(2241,1,20),(2242,1,21),(2243,1,22),(2244,1,61),(2245,1,2),(2246,1,12),(2247,1,13),(2248,1,14),(2249,1,24),(2250,1,25),(2251,1,26),(2252,1,6),(2253,1,15),(2254,1,55),(2255,1,56),(2256,1,62),(2257,1,7),(2258,1,3),(2259,1,69),(2260,1,70),(2261,1,71),(2262,1,72),(2263,1,73),(2264,1,74),(2265,1,68),(2266,1,98),(2267,1,99),(2268,1,100),(2269,1,101),(2270,1,102),(2271,56,20),(2272,56,21),(2273,56,22),(2274,56,61),(2275,56,2),(2276,56,12),(2277,56,13),(2278,56,14),(2279,56,24),(2280,56,25),(2281,56,26),(2282,56,6),(2283,56,15),(2284,56,55),(2285,56,56),(2286,56,62),(2287,56,7),(2288,56,3),(2289,56,69),(2290,56,70),(2291,56,71),(2292,56,72),(2293,56,73),(2294,56,74),(2295,56,68),(2296,56,94),(2297,56,96),(2298,56,93),(2299,56,92),(2300,56,103),(2301,56,104),(2302,56,105),(2303,56,106),(2304,56,107),(2305,56,108);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(255) DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `user_id_create` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`username`,`password`,`email`,`mobile`,`status`,`user_id_create`,`gmt_create`,`gmt_modified`,`name`) values (1,'admin','27bd386e70f280e24c2f4f2a549b82cf','admin@example.com','123456111',1,1,'2017-08-15 21:40:39','2017-08-15 21:41:00','超级管理员'),(126,'system','58597bc12e1ec8ee2662bd9c121cec7d','12121@qq.com',NULL,1,NULL,NULL,NULL,'网站管理员');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values (73,30,48),(74,30,49),(75,30,50),(76,31,48),(77,31,49),(78,31,52),(79,32,48),(80,32,49),(81,32,50),(82,32,51),(83,32,52),(84,33,38),(85,33,49),(86,33,52),(87,34,50),(88,34,51),(89,34,52),(110,1,1),(116,126,56);

/*Table structure for table `tb_member` */

DROP TABLE IF EXISTS `tb_member`;

CREATE TABLE `tb_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `real_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `constellation` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `emotion` int(11) DEFAULT NULL,
  `profession` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(200) COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin NOT NULL,
  `status` int(11) NOT NULL COMMENT '0:停用,1启用',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `I_PHONE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_member` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
