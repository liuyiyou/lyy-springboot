package cn.liuyiyou.boot.temp;

import javax.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/10
 * @version: V1.0
 */
@Slf4j
@Component
public class BeanLifecycle implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
    ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware,
    ApplicationContextAware, ServletContextAware, BeanPostProcessor {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setBeanName(String name) {
    log.info("如果实现了BeanNameAware接口，会调用#setBeanName方法");
  }

  @Override
  public void setBeanClassLoader(ClassLoader classLoader) {
    log.info("如果实现了BeanClassLoaderAware接口，会调用#setBeanClassLoader方法");
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    log.info("如果实现了BeanFactoryAware接口，会调用#setBeanFactory方法");
  }

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    log.info("如果实现了ResourceLoaderAware接口，会调用#setResourceLoader方法");
  }


  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    log.info("如果实现了ApplicationEventPublisherAware接口，会调用#setApplicationEventPublisher方法");
  }

  @Override
  public void setMessageSource(MessageSource messageSource) {
    log.info("如果实现了MessageSourceAware接口，会调用#setMessageSource方法");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    log.info("如果实现了ApplicationContextAware接口，会调用#setApplicationContext方法");
  }

  @Override
  public void setServletContext(ServletContext servletContext) {
    log.info("如果实现了ServletContextAware接口，会调用#setServletContext方法");
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    log.info("如果实现了BeanPostProcessor接口，会调用#postProcessBeforeInitialization方法");
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info("如果实现了BeanPostProcessor接口，会调用#postProcessAfterInitialization方法");
    return bean;
  }
}
