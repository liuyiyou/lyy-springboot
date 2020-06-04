package cn.liuyiyou.springboot.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/3
 * @version: V1.0
 */
@Slf4j
public class InMemoryCornJob extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext) {
//    log.info("这是一个InMemoryCornJob定时任务");
  }

}
