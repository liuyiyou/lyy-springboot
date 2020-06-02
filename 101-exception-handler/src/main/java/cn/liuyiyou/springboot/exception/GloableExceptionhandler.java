package cn.liuyiyou.springboot.exception;

import cn.liuyiyou.springboot.exception.exception.BusiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 有限处理最匹配的
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@ControllerAdvice
@Slf4j
public class GloableExceptionhandler {


  @ExceptionHandler(BusiException.class)
  public void busiException(BusiException exception) {
    log.error("业务异常", exception);
  }

  @ExceptionHandler(NullPointerException.class)
  public void npeException(NullPointerException exception) {
    log.error("空指针异常", exception);
  }

  @ExceptionHandler(RuntimeException.class)
  public void exception(RuntimeException exception) {
    log.error("运行时异常", exception);
  }


  //http://localhost:8080/prod/exception1
  @ExceptionHandler(Exception.class)
  public void exception(Exception exception) {
    log.error("其他异常", exception);
  }
}
