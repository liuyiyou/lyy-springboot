package cn.liuyiyou.springboot.quartz.controller;

import cn.liuyiyou.springboot.quartz.job.InMemoryDynamicJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/3
 * @version: V1.0
 */
@RestController
public class DynamicCornController {


  /**
   * 能改变，但是原来的不会删除
   */
  @GetMapping("/call")
  public String dynamic(@RequestParam(value = "corn", defaultValue = "0/5 * * * * ?") String corn)
      throws SchedulerException {
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
    if (scheduler.isStarted()) {
      scheduler.shutdown();
    }
    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(corn);
    JobDetail jobDetail = JobBuilder.newJob(InMemoryDynamicJob.class).storeDurably().build();
    //这里关联job报错
    CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder).build();
    scheduler.scheduleJob(jobDetail, cronTrigger);
    scheduler.start();
    return "success";
  }

  @GetMapping("/shutdown")
  public String shutdown()
      throws SchedulerException {
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
    scheduler.shutdown();
    return "success";
  }

}
