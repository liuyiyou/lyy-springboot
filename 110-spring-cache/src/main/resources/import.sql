drop  table if exists USER;

CREATE  TABLE  USER (
   id int IDENTITY PRIMARY KEY ,
   name VARCHAR(20),
   email varchar(20));

insert  into  USER values (1,'lyy','lyy@163.com');