# lyy-springboot

## 100-helloworld

1. 启动方式可以使用```SpringApplication.run(Application.class, args);```或者```new SpringApplicationBuilder().xx.run(args);```



## 110-spring-cache

1.cache和缓存无关，可以不依赖任何缓存中间件
2. 测试方式

启动成功后，访问```http://localhost:8080/users/1```控制台打印"到了服务层",刷新页面，没有日志打印，表示是从缓存中获取
访问```http://localhost:8080/users/save?id=7&name=lyy```，后再次访问```http://localhost:8080/users/7```也没有打印日志表示缓存有效
 

### 引入JPA之后

会缓存null值，比如 http://localhost:8080/users/4  第一次会访问数据库，第二次不会