package com.test.service;

import com.test.entity.UserEntity;
import com.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<UserEntity> select() {
        return mapper.select();
    }

    public List<UserEntity> selectPage(int page, int pageSize) {
        return mapper.selectPage(page, pageSize);
    }

    public boolean insert() {
        String username  = getRandomString(4);
        String password  = getRandomString(8);
        mapper.insert(username, password);
        return true;
    }

    public int count() {
        return mapper.count();
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
