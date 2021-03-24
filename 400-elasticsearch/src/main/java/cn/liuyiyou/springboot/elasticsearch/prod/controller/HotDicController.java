package cn.liuyiyou.springboot.elasticsearch.prod.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/11
 * @version: V1.0
 */
@RestController
@Slf4j
@RequestMapping("hot")
public class HotDicController {

    private static List<String> dicts = new ArrayList<>();

    @GetMapping("/add")
    public String add(String dict) {
        dicts.add(dict);
        return "success";
    }

    private static final String CHARSET = "UTF-8";


    @GetMapping("/dict")
    public void dict(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        StringBuilder content = new StringBuilder();
        if (dicts != null) {
            for (String word : dicts) {
                content.append(word).append("\n");
            }
            OutputStream out = response.getOutputStream();
            response.setContentType("text/plain; charset=" + CHARSET);
            response.setHeader("Last-Modified", String.valueOf(content.length()));
            response.setHeader("ETag", String.valueOf(content.length()));
            out.write(content.toString().getBytes(CHARSET));
            out.flush();
        }
    }
}
