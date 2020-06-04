package cn.liuyiyou.springboot.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/3
 * @version: V1.0
 */
@Slf4j
public class InMemoryDynamicJob extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext) {
    log.info("执行时间，根据前端传过来的corn表达式来确定");
    log.info("这是一个InMemoryDynamicJob定时任务");

  }

}
