CREATE DATABASE `simble` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `simble`.`member_user` (
  `id` VARCHAR(45) NOT NULL COMMENT 'PK',
  `username` VARCHAR(45) NULL COMMENT '用户名',
  `login_pwd` VARCHAR(45) NULL COMMENT '登陆密码',
  `user_status` VARCHAR(45) NULL COMMENT '用户状态',
  PRIMARY KEY (`id`));
