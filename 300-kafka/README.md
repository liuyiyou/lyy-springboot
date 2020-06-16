# 启动kafka

使用的版本为：kafka_2.11-1.1.0

先启动zookeeper：

>bin\windows\zookeeper-server-start.bat  config\zookeeper.properties

再启动kafka服务

>bin\windows\kafka-server-start.bat  config\server.properties

# 一对一
同一个group 同一个topic 随机消费

# 一对多
不同group 同一topic 全部消费

# 自定义分区、和拦截器

# 延时队列

# 事务消息



