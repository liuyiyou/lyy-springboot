package cn.liuyiyou.springboot.autoconfigure.runner;

import cn.liuyiyou.springboot.autoconfigure.LyyProperties;
import java.net.InetAddress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author liuyiyou
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class NextStartedUpRunner implements ApplicationRunner {

    private final ConfigurableApplicationContext context;


    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Value("${server.port:8080}")
    private String port;


    @Autowired
    private LyyProperties lyyProperties;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // 测试 Redis连接是否正常
            redisTemplate.hasKey("lyy");
        } catch (Exception e) {
            log.error(" ____   __    _   _ ");
            log.error("| |_   / /\\  | | | |");
            log.error("|_|   /_/--\\ |_| |_|__");
            log.error("                        ");
            log.error("用户中心启动失败{}", e.getMessage());
            log.error("Redis连接异常，请检查Redis连接配置并确保Redis服务已启动");
            context.close();
        }
        if (context.isActive()) {
            InetAddress address = InetAddress.getLocalHost();
            String url =
                String.format("http://%s:%s", address.getHostAddress(), port) + "/swagger-ui.html";
            String os = System.getProperty("os.name");
            log.info(" __    ___   _      ___   _     ____ _____  ____ ");
            log.info("/ /`  / / \\ | |\\/| | |_) | |   | |_   | |  | |_  ");
            log.info("\\_\\_, \\_\\_/ |_|  | |_|   |_|__ |_|__  |_|  |_|__ ");
            log.info("                        ");
            log.info(lyyProperties.getName() + "启动完毕，swagger地址：{}", url);
            if (os != null && os.toLowerCase().contains("win") && lyyProperties.getPopWindow()) {
                Runtime.getRuntime().exec("cmd  /c  start " + url);
            }
        }


    }
}
