package com.test.controller;

import com.test.entity.UserEntity;
import com.test.service.UserService;
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

            System.out.println(sj);
        });
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
            System.out.println("第 " + i +" 页");
            entities.forEach(entity -> {
                String sj = new StringJoiner("\t|\t")
                        .add(String.valueOf(entity.getId()))
                        .add(entity.getUsername())
                        .add(entity.getPassword())
                        .toString();
                System.out.println(sj);
            });
            System.out.println("第 " + i +" 页结束");
            System.out.println();
        }
        return "select pages";
    }

    @RequestMapping("/insert")
    public String insert(){
        userService.insert();
        System.out.println("插入数据....");
        return "插入数据";
    }

}
