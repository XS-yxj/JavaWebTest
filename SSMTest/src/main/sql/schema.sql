-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE ssm;
-- 使用数据库
use ssm;

-- 创建用户表
drop table user;

CREATE TABLE `user`(
`username` varchar(50) NOT NULL COMMENT '用户名',
`password` varchar(16) NOT NULL COMMENT '密码',
`email` varchar(50) NOT NULL COMMENT '浏览器',
`user_image_path` varchar(120) DEFAULT '233.jpg' COMMENT '用户头像',
`state` tinyint NOT NULL DEFAULT '0'COMMENT '用户状态: 0:正常;',
PRIMARY KEY(username)
)DEFAULT CHARSET=utf8 COMMENT '用户表';

insert into user(username,password,email) values('admin','admin','admin@gmail.com');
insert into user(username,password,email) values('孤世','admin','gushi@gmail.com');

-- 创建用户动态信息表
drop table message;

CREATE TABLE `message`(
`username` varchar(50) NOT NULL COMMENT '用户名',
`time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`content` varchar(500) NOT NULL COMMENT '内容',
`file_path` varchar(120) COMMENT '文件路径',
PRIMARY KEY (username, time)
)DEFAULT CHARSET=utf8 COMMENT='用户动态信息表';

-- 创建互动信息表
drop table communication;

CREATE TABLE `communication`(
`username` varchar(50) NOT NULL COMMENT '发信息人',
`follow_name` varchar(50) NOT NULL COMMENT '评论人',
`time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
`content` varchar(500) NOT NULL COMMENT '内容',
PRIMARY KEY (username, follow_name, time)
)DEFAULT CHARSET=utf8 COMMENT='互动信息表';

-- 创建朋友关系表
drop table friend;

CREATE TABLE `friend`(
`user_a` varchar(50) NOT NULL COMMENT '用户名A',
`user_b` varchar(50) NOT NULL COMMENT '用户名B',
PRIMARY KEY (user_a, user_b)
)DEFAULT CHARSET=utf8 COMMENT='  朋友关系表';