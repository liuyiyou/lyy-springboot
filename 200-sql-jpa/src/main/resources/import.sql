drop  table if exists user;
drop  table if exists user_address;

SET MODE MYSQL;

CREATE  TABLE  user (
   id int IDENTITY PRIMARY KEY ,
   name VARCHAR(20),
   email varchar(20));

CREATE  TABLE  user_address (
   id int IDENTITY PRIMARY KEY ,
   user_id int,
   prov VARCHAR(20),
   city varchar(20),
   county varchar (20));


insert  into  user values (1,'liuyiyou1','lyy@163.com');
insert  into  user values (2,'liuyiyou2','lyy@163.com');
insert  into  user values (3,'liuyiyou3','lyy@163.com');
insert  into  user values (4,'liuyiyou4','lyy@163.com');
insert  into  user values (5,'liuyiyou5','lyy@163.com');
insert  into  user_address values (10,1,'湖南','长沙','宁乡');
insert  into  user_address values (20,1,'湖南','常德','汉寿');