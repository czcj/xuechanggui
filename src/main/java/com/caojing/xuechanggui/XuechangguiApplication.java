package com.caojing.xuechanggui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.caojing.xuechanggui.dao")
public class XuechangguiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XuechangguiApplication.class, args);
    }

}
