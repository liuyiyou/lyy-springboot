package cn.liuyiyou.boot.temp.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/11
 * @version: V1.0
 */
public class ConfigurationTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        final MyBean myBean = ctx.getBean(MyBean.class);
        myBean.sayHello();
        final YourBean you = ctx.getBean(YourBean.class);
        you.sayHello();
    }

}
