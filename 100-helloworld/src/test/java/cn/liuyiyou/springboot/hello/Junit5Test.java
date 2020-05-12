package cn.liuyiyou.springboot.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 地址：https://www.ibm.com/developerworks/cn/java/j-introducing-junit5-part2-vintage-jupiter-extension-model/index.html
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@Slf4j
@DisplayName("Testing using JUnit 5")
public class Junit5Test {

  private List<String> list;

  @BeforeAll
  public static void init() {
    // Do something before ANY test is run in this class
    log.info("@BeforeAll 告诉 JUnit 在运行这个类中的所有 @Test 方法之前运行 init() 方法一次");
  }

  @AfterAll
  public static void done() {
    // Do something after ALL tests in this class are run
    log.info("@AfterAll 告诉 JUnit 在运行这个类中的所有 @Test 方法之后运行 done() 方法一次。");
  }

  @BeforeEach
  public void setUp() throws Exception {
    list = new ArrayList<>();
    log.info("@BeforeEach 告诉 JUnit 在此类中的每个@Test 方法之前运行 setUp() 方法。");
  }

  @AfterEach
  public void tearDown() throws Exception {
    list = null;
    log.info("@AfterEach 告诉 JUnit 在此类中的每个@Test 方法之后运行 tearDown() 方法。");
  }

  @Test
  @DisplayName("Dummy test")
  void aTest() {
    log.info("As written, this test will always pass!");
    assertEquals(4, (2 + 2));
  }

  @Test
  @Disabled
  @DisplayName("A disabled test")
  void testNotRun() {
    log.info("@Disabled 告诉 JUnit 不运行此 @Test 方法，因为它已被禁用。");
  }
}
