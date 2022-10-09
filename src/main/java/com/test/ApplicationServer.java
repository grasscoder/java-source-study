package com.test;

import com.test.controller.UserController;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.test.mapper")
@SpringBootApplication
public class ApplicationServer {
    private static final Logger logger= LoggerFactory.getLogger(ApplicationServer.class);

    public static void main(String[] args) {
        logger.info("spring-boot 开始启动");
        SpringApplication.run(ApplicationServer.class);
        logger.info("spring-boot 启动完成");
    }
}
