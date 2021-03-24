package cn.liuyiyou.boot.temp.configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/11
 * @version: V1.0
 */
public class YourBean {

    private MyBean myBean;

    public YourBean(final MyBean myBean) {
        this.myBean = myBean;
    }

    public void sayHello() {
        System.out.println("YourBean Hello");
    }
}
