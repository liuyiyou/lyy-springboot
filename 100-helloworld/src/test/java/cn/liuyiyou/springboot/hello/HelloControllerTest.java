package cn.liuyiyou.springboot.hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("MVC测试")
class HelloControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("测试返回常规字符串")
  void helloStr() throws Exception {
    mockMvc.perform(get("/hello/str"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello World"));
  }

  @Test
  @DisplayName("测试返回JSON格式的")
  void helloJson() throws Exception {
    mockMvc.perform(get("/hello/json"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.message").value("Hello World"));
  }
}