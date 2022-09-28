package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class HelloWorld {
    public static final Jedis jedis = new Jedis("43.138.64.89" , Integer.parseInt("6379"));

    @Autowired
    DataSource dataSource;
    //用于访问数据库的组件
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public String hello(){
        jedis.auth("123456");
        String value = jedis.get("kk");
        System.out.println("已执行");
        return "spring boot 2.0 say helloWorld " + value;
    }

    @RequestMapping("/hello2")
    public String helloMysql(){
        Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `emp`", Integer.class);
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * from `emp`;");
        List<String> info = new ArrayList<>();
        list.stream().forEach(mmap -> {
            StringBuilder temp = new StringBuilder("<tr>");
            mmap.entrySet().stream().forEach(entry ->{
                String key = entry.getKey();
                Object value = entry.getValue();
                temp.append("<th>").append(value).append("</th>");
                System.out.println("Key : " + key + ", value : "+ value);
            });
            temp.append("</tr>");
            info.add(temp.toString());
            System.out.println("-----------------------");
        });
        System.out.println("mysql已执行");
        String s = "<table border=\"1\" cellpadding=\"10\">  <tr>" +
                "<th>职工id</th>" +
                "<th>姓名</th>" +
                "<th>部门id</th>" +
                "<th>薪酬</th>" +
                "</tr>";
        String ss = s + info.stream().collect(Collectors.joining("")) + "</table>";

        //return "spring boot 2.0 say helloWorld " + i;
        return ss;
    }

    @RequestMapping("/add")
    public String add(){
        String sql = "insert into emp values(4,'赵四',10002, 35000);";
        jdbcTemplate.execute(sql);
        return "added";
    }
}
