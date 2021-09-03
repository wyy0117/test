package com.wyy.testtranaction.service;

import com.wyy.testtranaction.mapper.UserMapper;
import com.wyy.testtranaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Date: 2021/9/2
 * @Author: wyy
 */
@Service
public class UserService1 {
    @Autowired
    private UserMapper userMapper;


    public void insertNoTransaction() {
        insertInTransaction();
    }

    @Transactional
    public void insertInTransaction() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setName(UUID.randomUUID().toString());
        userMapper.insert(user);
        boolean flag = true;
        if (flag){
            int[] ints = new int[1];
            System.out.println(ints[10]);
        }
    }
}
