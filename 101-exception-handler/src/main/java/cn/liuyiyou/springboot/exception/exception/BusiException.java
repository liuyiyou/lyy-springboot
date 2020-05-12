package cn.liuyiyou.springboot.exception.exception;

/**
 * 业务异常，正常提示
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
public class BusiException extends RuntimeException {

  public BusiException() {
  }

  public BusiException(String message) {
    super(message);
  }

  public BusiException(String message, Throwable cause) {
    super(message, cause);
  }

  public BusiException(Throwable cause) {
    super(cause);
  }

  public BusiException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
