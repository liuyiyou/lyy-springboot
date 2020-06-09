## SpringBoo继承admin



### 遗留问题

${spring.security.user.name} 如何获取，可参考server.port中的设置

```
spring.boot.admin.client:
    url: http://localhost:10001
    instance:
      metadata:
        user.name: ${spring.security.user.name}
        user.password: ${spring.security.user.password}
```