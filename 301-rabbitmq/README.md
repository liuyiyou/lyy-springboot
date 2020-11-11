

# RabbitMQ

简单的发送和接收

1、如果之前没有创建queue，启动会报错

```bash
om.rabbitmq.client.ShutdownSignalException: channel error; protocol method: #method<channel.close>(reply-code=404, reply-text=NOT_FOUND - no queue 'simple' in vhost '/lyy', class-id=50, method-id=10)
```

解决方案：

```java
  @Bean
  public Queue hello() {
    return new Queue("simple");
  }
```


2、如果有两个接收，会轮询


3、如果监听消息处理失败（抛出异常）
会一直消费。造成大量日志，哪怕重启后，也会一直消费

解决方案：
1、解决异常后（删除 queue)
