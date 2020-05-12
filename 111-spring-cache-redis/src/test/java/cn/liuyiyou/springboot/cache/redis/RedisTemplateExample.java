package cn.liuyiyou.springboot.cache.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisCommands;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
public class RedisTemplateExample {


  //使用jedis完成功能
  @Test
  public void test() {
    RedisCommands<String, String> commands = getStringStringRedisCommands();
    init(commands);
    listPage(commands);
    setPage(commands);

    //删除一个元素
    commands.srem("userSet", "user:122");
    commands.del("user:122");
    commands.lrem("userList", 1, "user:123");
    commands.del("user:123");
  }

  private void init(RedisCommands<String, String> commands) {
    commands.del("userList");
    commands.del("userSet");
    for (int i = 100; i < 150; i++) {
      commands.del("user:" + i);
    }
    for (int i = 100; i < 150; i++) {
      commands.hset("user:" + i, "id", i + "");
      commands.hset("user:" + i, "name", i + "lyy");
      commands.hset("user:" + i, "email", i + "lyy.com");
      commands.rpush("userList", "user:" + i);
      commands.sadd("userSet", "user:" + i);
    }
  }

  private void setPage(RedisCommands<String, String> commands) {
    Set<String> userSet = commands.smembers("userSet");
    System.out.println(userSet);
    int total = userSet.size();
    int pageSize = 10;
    int totalPage = (int) (total / pageSize) + 1;
    for (int i = 0; i < totalPage; i++) {
      final List<String> userSet1 = commands.srandmember("userSet", 10);
      for (String userKey : userSet1) {
        Map<String, String> user = commands.hgetall(userKey);
        System.out.print(
            "id:" + user.get("id") + "\tname:" + user.get("name") + "\temail:" + user.get("email"));
      }
      System.out.println();
    }
  }

  private void listPage(RedisCommands<String, String> commands) {
    final Long total = commands.llen("userList");
    int pageSize = 10;
    int totalPage = (int) (total / pageSize) + 1;

    for (int i = 0; i < totalPage; i++) {
      System.out.println("第" + i + "页");
      List<String> userList = commands.lrange("userList", i * pageSize, (i + 1) * pageSize);
      for (String userKey : userList) {
        Map<String, String> user = commands.hgetall(userKey);
        System.out.println(
            "id:" + user.get("id") + "\tname:" + user.get("name") + "\temail:" + user.get("email"));
      }

    }
  }

  private RedisCommands<String, String> getStringStringRedisCommands() {
    RedisURI redisUri = RedisURI.builder()                    // <1> 创建单机连接的连接信息
        .withHost("localhost")
        .withPort(6379)
        .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
        .build();
    RedisClient redisClient = RedisClient.create(redisUri);   // <2> 创建客户端
    return redisClient.connect().sync();
  }


}
