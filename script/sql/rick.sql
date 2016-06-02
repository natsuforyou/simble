CREATE DATABASE 'rick' /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `rick`.`member_user` (
  `id` VARCHAR(45) NOT NULL COMMENT 'PK',
  `username` VARCHAR(45) NULL COMMENT '用户名',
  `password` VARCHAR(45) NULL COMMENT '密码',
  `user_status` VARCHAR(45) NULL COMMENT '用户状态',
  PRIMARY KEY (`id`));
