
首先，日期序列化分为两种情况，一种是Date，一种是Java8的Time

# Date

spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8
后即可起作用，

# LocalDateTime
## 默认
```
{
id: 1,
name: "手机",
createTime: "2020-06-09T14:01:26.282"
}
```

## jakson序列化

spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

```
{
id: 1,
name: "手机",
createTime: "2020-06-09T14:04:51.992"
}
```

@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
起作用了
```
{
id: 1,
name: "手机",
createTime: "2020-06-09 14:10:41"
}
```
## 自定义

Java8DateTimeConfig


# 参考资料

https://www.baeldung.com/spring-boot-formatting-json-dates