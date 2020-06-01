# 项目说明

这里是大纲，每个项目下后面会有一个README的文档，里面有该项目涉及到的知识点以及操作步骤

## 000-common-temp
这个是临时项目，有时候需要验证一些功能的时候，会在这里做测试

## 100-helloworld

1. 启动方式可以使用```SpringApplication.run(Application.class, args);```或者```new SpringApplicationBuilder().xx.run(args);```
2. 增加了一些单元测试的功能

## 101-exception-handler
全局异常处理

## 101-log
springBoot日志处理

## 103
SpringBoot属性配置

## 110-spring-cache
1.cache和缓存无关，可以不依赖任何缓存中间件
2. 测试方式

启动成功后，访问```http://localhost:8080/users/1```控制台打印"到了服务层",刷新页面，没有日志打印，表示是从缓存中获取
访问```http://localhost:8080/users/save?id=7&name=lyy```，后再次访问```http://localhost:8080/users/7```也没有打印日志表示缓存有效
 

### 引入JPA之后

会缓存null值，比如 http://localhost:8080/users/4  第一次会访问数据库，第二次不会

## 111-spring-cache-redis
110的缓存是基于内存的。 该项目是基于redis的，其他地方差不多


## 200-sql-jpa
集成JPA，另外，考虑到迁移问题，使用了h2内存数据库

## 201-mybatis

## 202-mybatis-plus

## 300-kafka
集成kafka

## 400-elasticsearch
集成es

## 自定义Starter

仿照mybatis-starter