drop  table if exists user;

CREATE  TABLE  user (
   id int IDENTITY PRIMARY KEY ,
   name VARCHAR(20),
   emial varchar(20));

insert  into  user values (1,'lyy','lyy@163.com');