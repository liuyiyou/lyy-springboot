package cn.liuyiyou.springboot.quartz.trigger;

import cn.liuyiyou.springboot.quartz.job.InMemoryCornJob;
import cn.liuyiyou.springboot.quartz.job.InMemorySimpleJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
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
public class InMemorySimpleTrigger {

  @Bean
  public JobDetail inMemorySimpleJob() {
    return JobBuilder.newJob(InMemorySimpleJob.class).storeDurably().build();
  }


  @Bean
  public Trigger simpleTrigger() {
    SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
        .withIntervalInSeconds(1)
        .repeatForever();
    return TriggerBuilder.newTrigger().forJob(inMemorySimpleJob())
        .withSchedule(scheduleBuilder).build();
  }
}
