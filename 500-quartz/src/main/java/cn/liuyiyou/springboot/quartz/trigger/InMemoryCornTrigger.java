package cn.liuyiyou.springboot.quartz.trigger;

import cn.liuyiyou.springboot.quartz.job.InMemoryCornJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/3
 * @version: V1.0
 */
@Configuration
public class InMemoryCornTrigger {

  @Bean
  public JobDetail inMemoryCornJob() {
    return JobBuilder.newJob(InMemoryCornJob.class).storeDurably().build();
  }

  @Bean
  public Trigger cornTrigger() {
//    JobDetail inMemoryJob = Application.applicationContext
//        .getBean("inMemoryJob", JobDetail.class);
    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
        .cronSchedule("0/5 * * * * ?");
    return TriggerBuilder.newTrigger().forJob(inMemoryCornJob())
        .withSchedule(cronScheduleBuilder).build();
  }

}
