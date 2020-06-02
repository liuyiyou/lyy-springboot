## 知识点

1. 使用@ConfigurationProperties(prefix = "erp.liuyiyou")方式获取

在这种情况下，下面的属性不需要加前缀



2. 使用@Value方式


## 问题

我在application.properties中设置了 user.name=liuyiyou，但是打印的却是lyy，如果改成usera.name=liuyiyou则可以正常打印。所以，加载application.properties的顺序并不是我们看到的这样，System.getProperty("user.name")有该属性



org.springframework.boot.SpringApplication.prepareContext里面有一个
context.setEnvironment(environment);方法，这个是设置环境变量的，里面会包含系统变量、属性变量等。 而系统变量的优先级会高于

如果要想改变