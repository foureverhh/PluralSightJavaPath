/*create database if not exists ssm;
use ssm;*/
/*create table if not exists flower(
	id int(10) primary key auto_increment comment "序号",
    name varchar(30) not null comment "花名",
    price float not null comment "价格",
    production varchar(30) not null comment "原产地"
);*/
create table if not exists flower(
	id int(10) primary key auto_increment,
    name varchar(30) not null ,
    price float not null ,
    production varchar(30) not null
);

insert into flower (id,name,price,production) values (1,'矮牵牛',2.5,'南美阿根廷');
insert into flower (id,name,price,production) values (2,'百日草',5.0,'墨西哥');
insert into flower (id,name,price,production) values (3,'半枝莲',4.3,'巴西');

create table if not exists grass(
	id int(10) primary key auto_increment comment "序号",
    name varchar(30) not null comment "草名",
    price float not null comment "价格",
    production varchar(30) not null comment "原产地"
);
