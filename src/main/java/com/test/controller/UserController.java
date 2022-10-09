package com.test.controller;

import com.test.entity.UserEntity;
import com.test.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.StringJoiner;

@Controller
@RequestMapping("/home")
@ResponseBody
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/select")
    public String select() {
        List<UserEntity> entities = userService.select();
        entities.stream().forEach(entity -> {
            String sj = new StringJoiner("\t|\t")
                    .add(String.valueOf(entity.getId()))
                    .add(entity.getUsername())
                     .add(entity.getPassword())
                             .toString();

           logger.info(sj);
        });
        logger.info("====hello world");
        return "hello world";
    }

    @RequestMapping("/selectPage")
    public String selectPage() {
        final int pageSize = 50;
        int total = userService.count();
        int pages = total / pageSize;
        if(total / pages != 0)
            pages += 1;
        for (int i = 0; i < pages; i++) {
            List<UserEntity> entities = userService.selectPage(i * pageSize, pageSize);
            //logger.info("第 " + i +" 页");
            logger.info("第 " + i +" 页");
            entities.forEach(entity -> {
                String sj = new StringJoiner("\t|\t")
                        .add(String.valueOf(entity.getId()))
                        .add(entity.getUsername())
                        .add(entity.getPassword())
                        .toString();
                logger.info(sj);
            });
            //logger.info("第 " + i +" 页结束");
            logger.info("第 " + i +" 页结束");
        }
        //logger.info("select pages");
        logger.info("select pages");
        return "select pages";
    }

    @RequestMapping("/insert")
    public String insert(){
        userService.insert();
        logger.info("插入数据....");
        return "插入数据";
    }

}
