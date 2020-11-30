package cn.liuyiyou.boot;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.lettuce.core.RedisCommandTimeoutException;
import io.lettuce.core.RedisConnectionException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 有限处理最匹配的
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@RestControllerAdvice
@Slf4j
public class RestGloableExceptionhandler {


    @ExceptionHandler(RedisConnectionException.class)
    public void busiException(RedisConnectionException exception) {
        log.info("redis连接异常");
    }

    @ExceptionHandler(RedisCommandTimeoutException.class)
    public void redisException(RedisCommandTimeoutException exception) {
        try {
            //
        } catch (RedisCommandTimeoutException excption) {
            //do noting
        }
    }

    @ExceptionHandler(NullPointerException.class)
    public JSONObject npeException(NullPointerException exception) {
        log.error("空指针异常", exception);
        return Objects
            .requireNonNull(Objects.requireNonNull(JSONUtil.createObj().put("status", 500))
                .put("success", false))
            .put("msg", "数据有问题");
    }

    @ExceptionHandler(RuntimeException.class)
    public JSONObject exception(RuntimeException exception) {
        if(exception instanceof  RedisCommandTimeoutException){
            try {
                //
            } catch (RedisCommandTimeoutException excption) {
                //do noting
            }
        }else{

        }
        log.error("运行时异常", exception);
        return Objects
            .requireNonNull(Objects.requireNonNull(JSONUtil.createObj().put("status", 500))
                .put("success", false))
            .put("msg", exception.getLocalizedMessage());

    }


    @ExceptionHandler(Exception.class)
    public JSONObject exception(Exception exception) {
        log.error("其他异常", exception);
        return Objects
            .requireNonNull(Objects.requireNonNull(JSONUtil.createObj().put("status", 500))
                .put("success", false))
            .put("msg", exception.getLocalizedMessage());
    }
}
